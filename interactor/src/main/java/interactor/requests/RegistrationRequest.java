package interactor.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;

/**
 * Request for register a new user.
 */
@AllArgsConstructor
public class RegistrationRequest {

    /**
     * Token sent from the client application.
     */
    @NotNull
    @Getter
    private String token;

    public RegistrationRequest() {}
}
