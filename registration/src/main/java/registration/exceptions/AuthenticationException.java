package registration.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception used when a user attempts to authenticate against the application but an validation error is triggered.
 */
@ResponseStatus(value= HttpStatus.UNAUTHORIZED, reason="Unauthorized user")
public class AuthenticationException extends Exception {

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
