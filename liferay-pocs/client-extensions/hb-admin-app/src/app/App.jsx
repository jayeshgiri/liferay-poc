import React, {useEffect, useState} from 'react';
import { compactDecrypt, compactVerify, importJWK } from 'jose';

const App = () => {
    const SECRET_KEY = '0123456789abcdef0123456789abcdef'; // Must be 256 bits (32 characters) for A256GCM
    const [token, setToken] = useState(null);
    const [jwtToken, setJWTToken] = useState(null);
    const [decodedJWTToken, setDecodedJWTToken] = useState(null);
    const [hello, setHello] = useState(null);
    const [decodedJWTTokenByReact, setDecodedJWTTokenByReact] = useState(null);
    const [helloNode, setHelloNode] = useState(null);
    const [employeeData, setEmployeeData] = useState(null);




    // Set client ID and client secret for demonstration purposes
    const clientId = process.env.REACT_APP_CLIENT_ID || 'id-425b7dc7-2bf4-5f46-b49a-27cea2f473';
    const clientSecret = process.env.REACT_APP_CLIENT_SECRET || 'secret-805d677c-18b6-e41a-98d6-2c4df6878f9';

    const decodeJweToken = async (jweToken) => {
        try {
            // Import the secret key as a JSON Web Key (JWK) for decryption
            const secretKey = await importJWK(
                { kty: 'oct', k: btoa(SECRET_KEY), alg: 'A256GCM' },
                'A256GCM'
            );

            // Decrypt the JWE to obtain the JWS (signed JWT) as plaintext
            const { plaintext } = await compactDecrypt(jweToken, secretKey);

            // Convert the plaintext (JWS string) to a usable format
            const jwsString = new TextDecoder().decode(plaintext);

            // Verify and decode the inner JWS using the same secret key for HS256
            const { payload } = await compactVerify(jwsString, secretKey);
            const jwtPayload = JSON.parse(new TextDecoder().decode(payload));
            console.log('Decoded JWT Payload:', jwtPayload);

            return jwtPayload;
        } catch (error) {
            console.error('Error decoding token:', error);
            return null;
        }
    };

    const handleDecodeClick = async () => {
        try {
            const decoded = await decodeJweToken(jwtToken.jwtToken);
            setDecodedJWTTokenByReact(decoded);
        } catch (err) {
            console.error('Error decoding token:', err);
        }
    };


    // Fetch token on component load
    useEffect(() => {
        const fetchToken = async () => {
            try {
                const response = await fetch('/o/oauth2/token', {
                    method: 'POST', headers: {
                        'Content-Type': 'application/x-www-form-urlencoded', 'Authorization': 'Basic ' + btoa(`id-425b7dc7-2bf4-5f46-b49a-27cea2f473:secret-805d677c-18b6-e41a-98d6-2c4df6878f9`),
                    }, body: new URLSearchParams({
                        grant_type: 'client_credentials'
                    }),
                });

                if (response.ok) {
                    const data = await response.json();
                    setToken(data.access_token); // Set the token in state
                } else {
                    console.error('Failed to fetch token:', response.statusText);
                }
            } catch (error) {
                console.error('Error fetching token:', error);
            }
        };

        fetchToken();
    }, []); // Runs only once on component load

    // Fetch fetchJWTToken on button click
    const fetchJWTToken = async () => {
        if (!token) {
            console.error('Token is not available yet');
            return;
        }

        try {
            const response = await fetch('/o/liferay-jwt-custom-token/v1.0/getJwtToken', {
                method: 'GET', headers: {
                    'Authorization': `Bearer ${token}`, // Use the token in the Authorization header
                },
            });

            if (response.ok) {
                const result = await response.json();
                setJWTToken(result); // Set the fetched data in state
            } else {
                console.error('Failed to fetch data:', response.statusText);
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    // Fetch fetchDecodedJWTToken on button click
    const fetchDecodedJWTToken = async () => {
        if (!token) {
            console.error('Token is not available yet');
            return;
        }

        try {
            const response = await fetch('/o/liferay-jwt-custom-token/v1.0/getDecodedJwtToken', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json', // Set the content type to JSON
                    'Authorization': `Bearer ${token}`, // Use the token in the Authorization header
                },
                body: JSON.stringify({
                    encodedToken: jwtToken.jwtToken,
                })
            });

            if (response.ok) {
                const result = await response.json();
                setDecodedJWTToken(result); // Set the fetched data in state
            } else {
                console.error('Failed to fetch data:', response.statusText);
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    // Fetch data on button click
    const fetchHello = async () => {
        if (!token) {
            console.error('Token is not available yet');
            return;
        }

        try {
            const response = await fetch('/o/liferay-jwt-custom-token/v1.0/hello', {
                method: 'GET', headers: {
                    'Authorization': `Bearer ${token}`, // Use the token in the Authorization header
                },
            });

            if (response.ok) {
                const result = await response.json();
                setHello(result); // Set the fetched data in state
            } else {
                console.error('Failed to fetch data:', response.statusText);
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    // Fetch data on button click
    const fetchHelloNode = async () => {
        if (!token) {
            console.error('Token is not available yet');
            return;
        }

        try {
            const response = await fetch('http://localhost:3000/hello', {
                method: 'GET'
            });

            if (response.ok) {
                const result = await response.json();
                setHelloNode(result); // Set the fetched data in state
            } else {
                console.error('Failed to fetch data:', response.statusText);
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };

    // Fetch fetchDecodedJWTToken on button click
    const fetchEmployeeData = async () => {
        if (!token) {
            console.error('Token is not available yet');
            return;
        }

        try {
            const response = await fetch('http://localhost:3000/getEmployee', {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json', // Set the content type to JSON
                    'Authorization': `Bearer ${jwtToken.jwtToken}`, // Use the token in the Authorization header
                }
            });

            if (response.ok) {
                const result = await response.json();
                setEmployeeData(result); // Set the fetched data in state
            } else {
                console.error('Failed to fetch data:', response.statusText);
            }
        } catch (error) {
            console.error('Error fetching data:', error);
        }
    };


    return (<div>
        <h2>OAuth Token Example</h2>
        <p><strong>Client ID:</strong> {clientId}</p>
        <p><strong>Client Secret:</strong> {clientSecret}</p>
        <p><strong>Token:</strong>
            <span style={{
                maxWidth: '100%', padding: '16px', wordWrap: 'break-word',    // CamelCase for inline styles
                overflowWrap: 'break-word', // CamelCase for inline styles
                whiteSpace: 'normal', lineHeight: 1.5, overflow: 'hidden',
            }}>{token ? token : 'Fetching Token...'} </span>
        </p>
        <p>
            <button onClick={fetchHello} disabled={!token}>
                Say Hello
            </button>
            {hello && (<pre>Say Hello : {JSON.stringify(hello, null, 2)}</pre>)}
        </p>
        <p>
            <button onClick={fetchJWTToken} disabled={!token}>
                Fetch Encoded JWT Token For LoggedIn User
            </button>
            {jwtToken && (<pre>Data: {JSON.stringify(jwtToken, null, 2)}</pre>)}
        </p>

        <p>
            <button onClick={fetchDecodedJWTToken} disabled={!fetchJWTToken}>
                Fetch Verified Decoded JWT Token For LoggedIn User From Liferay
            </button>
            {decodedJWTToken && (<pre>Data: {JSON.stringify(decodedJWTToken, null, 2)}</pre>)}
        </p>

        <p>
            <button onClick={handleDecodeClick} disabled={!fetchJWTToken}>
                Verify and Decoded JWT Token For LoggedIn User In React
            </button>
            {decodedJWTTokenByReact ? (
                <pre>Decoded Claims: {JSON.stringify(decodedJWTTokenByReact, null, 2)} </pre>
            ) : (
                <p>No decoded claims to display</p>
            )}
        </p>

        <p>
            <button onClick={fetchHelloNode} disabled={!token}>
                Say Hello To Node (Without Authentication)
            </button>
            {helloNode && (<pre>Say Hello to Node : {JSON.stringify(helloNode, null, 2)}</pre>)}
        </p>

        <p>
            <button onClick={fetchEmployeeData} disabled={!fetchJWTToken}>
                Get Employee Data from Node, JWE Token to validate
            </button>
            {employeeData ? (
                <pre>Decoded Claims: {JSON.stringify(employeeData, null, 2)} </pre>
            ) : (
                <p>No Employee Data to display</p>
            )}
        </p>
    </div>);
};

export {App};
