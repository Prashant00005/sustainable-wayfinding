package profile.dao;

import database.DynamoDatabase;
import org.springframework.stereotype.Component;
import profile.models.User;

/**
 * Data Access for User Objects to Dynamo.
 */
@Component
public class UserDAO extends DynamoDatabase<User> {

    @Override
    protected Class<User> getClassType() {
        return User.class;
    }
}