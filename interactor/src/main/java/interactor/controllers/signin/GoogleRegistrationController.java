package interactor.controllers.signin;

import interactor.requests.RegistrationRequest;
import org.springframework.web.bind.annotation.RequestBody;
import registration.exceptions.AuthenticationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import profile.exceptions.UserAlreadyRegisteredException;
import profile.models.User;
import profile.service.ProfileService;
import registration.verifiers.Verifier;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Log4j2
@Controller
public class GoogleRegistrationController implements RegistrationController {

    @Autowired
    @Qualifier("Google")
    private Verifier verifier;

    @Autowired
    private ProfileService profileService;

    @Override
    @RequestMapping(method = POST, value = "/googleplus")
    public ResponseEntity.BodyBuilder registerUser(@RequestBody @Valid RegistrationRequest request)
            throws AuthenticationException, UserAlreadyRegisteredException {
        User user = this.verifier.verify(request.getToken());
        this.profileService.createUser(user);
        log.info(String.format("User '%s' was registered with Google+ successfully.", user.getEmail()));
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/{username}")
                .buildAndExpand(user.getUsername()).toUri();
        return ResponseEntity.created(location);
    }
}
