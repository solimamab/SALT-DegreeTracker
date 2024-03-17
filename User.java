import java.util.UUID;

/**
 * User class
 */
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private UUID id;
    private boolean loggedIn;

    /**
     * Constructor that initializes a user
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public User(String username, String password, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID(); // Generate a random UUID
    }

    public User(UUID id,String username,String password,String firstName, String lastName )
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    /**
     * Gets user's username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * Getters for the User Class
     * @return Strings that respresent the appropriate attribute
     */
    public String getUserId() {
        return id.toString();
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * toString representation of a user
     */
    public String toString() {
        return "username:" + username + "\n" + "password:" + password + "\n" + "firstname:" + firstName + "\n"
                + "lastname: " + lastName;
    }


    /**
     * Login method for the facade that logs a user in if their username and password match
     * @param username
     * @param password
     * @return
     */
    public boolean facadeLogin(String username, String password) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.loggedIn = true;
            return true;
        }
        this.loggedIn = false;
        return false;
    }

    /**
     * Checks to see if a user has logged in
     * @return
     */
    public boolean isLoggedIn() {
        return loggedIn;
    }
}
