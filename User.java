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
}
