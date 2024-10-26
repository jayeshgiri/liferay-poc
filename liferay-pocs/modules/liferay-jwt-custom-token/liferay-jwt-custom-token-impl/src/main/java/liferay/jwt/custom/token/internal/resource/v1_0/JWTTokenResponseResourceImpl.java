package liferay.jwt.custom.token.internal.resource.v1_0;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import liferay.jwt.custom.token.dto.v1_0.JWTTokenRequest;
import liferay.jwt.custom.token.dto.v1_0.JWTTokenResponse;
import liferay.jwt.custom.token.resource.v1_0.JWTTokenResponseResource;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import java.util.Date;
import java.util.UUID;

/**
 * @author JayeshGoswami
 */
@Component(properties = "OSGI-INF/liferay/rest/v1_0/jwt-token-response.properties", scope = ServiceScope.PROTOTYPE, service = JWTTokenResponseResource.class)
public class JWTTokenResponseResourceImpl extends BaseJWTTokenResponseResourceImpl {

    private static final String SECRET_KEY = "0123456789abcdef0123456789abcdef"; // Use a strong key


    @Override
    public JWTTokenResponse getJwtToken() throws Exception {
        String jweString = StringPool.BLANK;
        try {

            // Generate a unique JWT ID (jti)
            String jwtID = UUID.randomUUID().toString();

            // Set the current time and expiration time (e.g., 10 minutes from iat)
            long currentTimeMillis = System.currentTimeMillis();
            Date iat = new Date(currentTimeMillis);
            Date exp = new Date(currentTimeMillis + 3 * 60 * 1000); // Expire in 3 minutes

            long userId = ServiceContextThreadLocal.getServiceContext().getUserId();

            User user = UserLocalServiceUtil.getUserById(userId);
            JWTClaimsSet claimsSet = null;
            if (user != null) {

                // Create JWT claims with required details
                 claimsSet = new JWTClaimsSet.Builder()
                        .jwtID(jwtID)                                                             // Generated jti
                        .claim("client_id", "id-425b7dc7-2bf4-5f46-b49a-27cea2f473")              // client_id
                        .issueTime(iat)                                                          // iat
                        .expirationTime(exp)                                                     // exp
                        .subject(String.valueOf(user.getUserId()))                                                        // sub
                        .claim("username", user.getContact().getUserName())
                        .claim("email", user.getEmailAddress())            // username
                        .issuer("liferay")                                                       // iss
                        .claim("scope", "[]]") // scope
                        .claim("grant_type", "custom_grant_type")                   // grant_type
                        .build();

            }
            // Create signed JWT (optional)
            SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);
            signedJWT.sign(new MACSigner(SECRET_KEY));

            // Create JWE object
            JWEObject jweObject = new JWEObject(new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A256GCM), new Payload(signedJWT));

            // Encrypt with shared secret
            jweObject.encrypt(new DirectEncrypter(SECRET_KEY.getBytes()));

            // Serialize to compact form, produces a JWE string
            jweString = jweObject.serialize();

            //   return Response.ok(jweString).build();
        } catch (Exception e) {
            // return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            jweString = "Internal Server Error";
            e.printStackTrace();
        }

        JWTTokenResponse jwtTokenResponse = new JWTTokenResponse();

        jwtTokenResponse.setJwtToken(jweString);
        // jwtTokenResponse.setJwtToken("TEST token");
        return jwtTokenResponse;
    }


    @Override
    public JWTTokenResponse getDecodedJwtToken(JWTTokenRequest jwtTokenRequest) throws Exception {

        String jweString = jwtTokenRequest.getEncodedToken();
        // Parse the JWE token
        JWEObject jweObject = JWEObject.parse(jweString);

// Decrypt with shared secret
        jweObject.decrypt(new DirectDecrypter(SECRET_KEY.getBytes()));


// Extract the signed JWT (JWS) from the decrypted JWE payload
        SignedJWT signedJWT = jweObject.getPayload().toSignedJWT();

// Verify the signature (assuming HS256 and same secret key)
        if (signedJWT.verify(new MACVerifier(SECRET_KEY))) {
            // Extract claims after verification
            JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

            // Create response with decoded claims
            JWTTokenResponse jwtTokenResponse = new JWTTokenResponse();
            jwtTokenResponse.setJwtToken(claimsSet.toJSONObject().toString()); // or directly as a JSON string

            return jwtTokenResponse;

        } else {
            throw new JOSEException("Signature verification failed");
        }
    }

    public JWTTokenResponse verifyJwtToken(JWTTokenRequest jwtTokenRequest) throws Exception {

        String jweString = jwtTokenRequest.getEncodedToken();
        // Parse the JWE token
        JWEObject jweObject = JWEObject.parse(jweString);

// Decrypt with shared secret
        jweObject.decrypt(new DirectDecrypter(SECRET_KEY.getBytes()));

        // Extract payload (the signed JWT)
        SignedJWT signedJWT = jweObject.getPayload().toSignedJWT();

// Validate the signature
        boolean isValid = signedJWT.verify(new MACVerifier(SECRET_KEY));

        System.out.println("Is Valid Token ::: " + isValid);

        jweString = jweObject.serialize();
        JWTTokenResponse jwtTokenResponse = new JWTTokenResponse();

        jwtTokenResponse.setJwtToken(jweString);
        return jwtTokenResponse;
    }

}