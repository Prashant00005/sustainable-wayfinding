package TDD;

import interactor.requests.RegistrationRequest;
import registration.exceptions.AuthenticationException;
import interactor.controllers.signin.GoogleRegistrationController;
import profile.exceptions.UserAlreadyRegisteredException;

public class SignInTests {

    public void given_token_then_check_whether_user_is_authenticated_with_google_returns_authenticated()
            throws AuthenticationException, UserAlreadyRegisteredException {
        final GoogleRegistrationController googlePlusSignInController = new GoogleRegistrationController();
        googlePlusSignInController.registerUser(new RegistrationRequest(""));

        //Assert.assertTrue(isAuthenticated);
    }
}
