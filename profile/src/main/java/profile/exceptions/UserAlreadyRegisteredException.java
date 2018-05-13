package profile.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception used when a user attempts to register with a existing username.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="User was registered before")
public class UserAlreadyRegisteredException extends Exception {

    public UserAlreadyRegisteredException(String message) {
        super(message);
    }

    public UserAlreadyRegisteredException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
