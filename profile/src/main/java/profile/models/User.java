package profile.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import database.models.DynamoDocument;
import lombok.NonNull;

@DynamoDBTable(tableName = "User")
public class User implements DynamoDocument {

    /**
     * Name of the user.
     */
    private String name;

    /**
     * Email used to register either in the application or in the third party.
     */
    private String email;

    /**
     * Password to login in the application. Password not required when third party login is used.
     */
    private String password;

    /**
     * Unique username. Used as hash key of the database
     */
    private String username;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @DynamoDBHashKey(attributeName="username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Constructor. It obtains the username from the email.
     * @param name name of the user
     * @param email email of the user
     */
    public User(@NonNull String name, @NonNull String email) {
        this.name = name;
        this.email = email;
        this.username = this.createUsernameFromEmail(email);
    }

    /**
     * Constructor. It obtains the username from the email.
     * @param name name of the user
     * @param email email of the user
     * @param password password of the user
     */
    public User(@NonNull String name, @NonNull String email, @NonNull String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.username = this.createUsernameFromEmail(email);
    }

    @Override
    @DynamoDBIgnore
    public String getPrimaryKey() {
        return this.email;
    }

    private String createUsernameFromEmail(String email) {
        int index = email.indexOf('@');
        String username = email.substring(0, index);

        return username;
    }
}
