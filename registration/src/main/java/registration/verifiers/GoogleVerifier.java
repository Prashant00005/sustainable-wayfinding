package registration.verifiers;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.extensions.appengine.http.UrlFetchTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import lombok.NonNull;
import registration.exceptions.AuthenticationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import profile.models.User;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

/**
 * Authenticates the Google+ Sign In.
 */
@Service
@Log4j2
@Qualifier("Google")
public class GoogleVerifier implements Verifier {

    /**
     * Application Client ID credential which identifies the application in Google+.
     */
    @Value("${app.google.clientId}")
    private String client_ID;

    /**
     * Factory used to map the token from JSON to Object.
     */
    private static final JacksonFactory jacksonFactory = new JacksonFactory();

    @Override
    public User verify(@NonNull String token) throws AuthenticationException {
        log.info(String.format("Verifying token '%s'.", token));
        GoogleIdTokenVerifier verifier = this.createVerifier();

        GoogleIdToken idToken = null;

        try {
            idToken = verifier.verify(token);
        } catch (GeneralSecurityException | IOException e) {
            throw new AuthenticationException("Verification attempt of token '%s' failed.", e);
        }

        if (idToken == null) {
            throw new AuthenticationException("invalid token '%s'.");
        }

        Payload payload = idToken.getPayload();

        String userId = payload.getSubject();
        log.info(String.format("User with ID '%s' verification successful.", userId));

        return this.createUserFromTokenPayload(payload);
    }

    private User createUserFromTokenPayload(Payload payload) {
        String email = payload.getEmail();
        String name = (String) payload.get("name");
        User user = new User(name, email);

        return user;
    }

    private GoogleIdTokenVerifier createVerifier(){
        return new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), this.jacksonFactory)
                .setAudience(Collections.singletonList(this.client_ID))
                .build();
    }
}
