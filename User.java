import java.util.UUID;
/**
 * 
 */
public class User {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    protected UUID id;
    public boolean loggedIn;
    
    /**
     * 
     * @param username
     * @param password
     * @param firstName
     * @param lastname
     */
    public User(String username, String password, String firstName, String lastname)
    {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastname;
        this.id = new UUID(0, 0); //not sure what to pass in
    }

    /**
     * 
     * @return
     */
    public String getUsername()
    {
        return this.username;
    }

    public String getId()
    {
        return this.id.toString();
    }

    /**
     * 
     * @return
     */
    public String getPassword()
    {
        return this.password;
    }

    /**
     * 
     * @return
     */
    public String getFirstName()
    {
        return this.firstName;
    }

    /**
     * 
     * @return
     */
    public String getLastName()
    {
        return this.lastName;
    }

    public User getUser()
    {
        return new User("asmith", "12345", "amy", "smith");
    }

    public String toString(){
        return "username:" + username + "\n" + "password:" + password + "\n" + "firstname:" + firstName + "\n" +"lastname: "+ lastName;
    }

    public boolean facadeLogin(String username, String password) {
        return login(username, password);
    }

    private boolean login(String username, String passsword) {
        if (this.username.equals(username) && this.password.equals(password)) {
            this.loggedIn = true;
            return true;
        }
        this.loggedIn = false;
        return false;
    }
}
