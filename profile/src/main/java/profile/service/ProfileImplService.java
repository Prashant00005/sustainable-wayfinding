package profile.service;

import database.Database;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import profile.exceptions.UserAlreadyRegisteredException;
import profile.models.User;

@Service
public class ProfileImplService implements ProfileService {

    /**
     * Data Access for User Objects.
     */
    @Autowired
    private Database<User> userDynamoDatabase;

    @Override
    public void createUser(@NonNull User user) throws UserAlreadyRegisteredException {
        if (this.userDynamoDatabase.exists(user)) {
            throw new UserAlreadyRegisteredException("User was registered previously.");
        }

        this.userDynamoDatabase.add(user);
    }
}
