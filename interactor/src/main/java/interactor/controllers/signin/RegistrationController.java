package interactor.controllers.signin;

import interactor.requests.RegistrationRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import registration.exceptions.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import profile.exceptions.UserAlreadyRegisteredException;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * RESTful controller to handles Registration attempts.
 */
@RequestMapping(value = "/registration")
public interface RegistrationController {

    /**
     * Register a user
     * @param request
     * @return the location of the new user's profile URI.
     * @throws AuthenticationException it is thrown when an validation exception occurred.
     * @throws UserAlreadyRegisteredException it is thrown when the user attempted to register already exists.
     */
    ResponseEntity.BodyBuilder registerUser(@RequestBody @Valid RegistrationRequest request)
            throws AuthenticationException, UserAlreadyRegisteredException;
}
