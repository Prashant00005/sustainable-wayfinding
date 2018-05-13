package profile.service;

import lombok.NonNull;
import profile.exceptions.UserAlreadyRegisteredException;
import profile.models.User;

/**
 *
 */
public interface ProfileService {

    /**
     * Creates an user.
     * @param user user to be created.
     * @throws UserAlreadyRegisteredException when the user already exists.
     */
    void createUser(@NonNull User user) throws UserAlreadyRegisteredException;
}
