const express = require('express');
const cors = require('cors');
const { compactDecrypt, importJWK, decodeProtectedHeader, compactVerify } = require('jose');
const app = express();
const PORT = 3000;

// Enable CORS
app.use(cors());


// Secret key and key configuration, matching the encryption setup from the Java code
const SECRET_KEY = '0123456789abcdef0123456789abcdef'; // Replace with a secure key

// Function to validate JWE token
const validateJweToken = async (token) => {
  try {
    // Import the secret key as a JSON Web Key (JWK) for decryption
    const secretKey = await importJWK(
      { kty: 'oct', k: Buffer.from(SECRET_KEY, 'utf-8').toString('base64'), alg: 'A256GCM' },
      'A256GCM'
    );

    // Decrypt the JWE token to retrieve the inner signed JWT (JWS)
    const { plaintext } = await compactDecrypt(token, secretKey);
    const jwsString = new TextDecoder().decode(plaintext); // Decode the plaintext to a string

    // Verify and decode the inner JWS using the same secret key for HS256
    const { payload } = await compactVerify(jwsString, secretKey);
    const jwtPayload = JSON.parse(new TextDecoder().decode(payload));
    console.log('Decoded JWT Payload:', jwtPayload);

    // Return the decoded JWT payload
    return jwtPayload;
  } catch (error) {
    console.error('Token validation failed:', error);
    return null;
  }
};

// Middleware to validate JWE token
const authenticateToken = async (req, res, next) => {
  const token = req.headers['authorization']?.split(' ')[1]; // Expect "Bearer <token>"

  if (!token) {
    return res.status(401).json({ message: 'Token missing' });
  }

  const decodedPayload = await validateJweToken(token);

  if (!decodedPayload) {
    return res.status(403).json({ message: 'Invalid or expired token' });
  }

  // Attach decoded payload to request for further use
  req.user = decodedPayload;
  next();
};

// Public endpoint
app.get('/hello', (req, res) => {
  res.json({ message: 'Hello, Node!' });
});

// Secure endpoint
app.get('/getEmployee', authenticateToken, (req, res) => {
  // Access employee data only if the user is authenticated
  res.json({
    message: 'Employee data retrieved successfully',
    data: {
      id: '123',
      name: 'John Doe',
      role: 'Software Engineer',
      email: 'john.doe@example.com',
    },
  });
});

// Start the server
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
