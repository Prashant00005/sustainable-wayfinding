package registration.verifiers;

import registration.exceptions.AuthenticationException;
import profile.models.User;

/**
 * Authenticates the credentials and meta data used for registration or login.
 */
public interface Verifier {

    /**
     * Verifies if the token is valid.
     * @param token the token to verify
     * @return User's information
     */
    User verify(String token) throws AuthenticationException;
}
