import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * User Class has been tested by Tristen 
 */
public class UserTest {
    private User currentUser =  new User("Linda", "123456", "Linda", "Blaze");
   

    // Testing the facadeLogin Method 
    @Test
    public void testValidLogin()
    {
        boolean test = currentUser.facadeLogin("Linda", "123456");
        assertEquals(true, test);
    }

    @Test
    public void Notvalidlogin()
    {
        boolean test = currentUser.facadeLogin("bob", "ross");
        assertEquals(false, test);
    }

    @Test
    public void onlyusername()
    {
        boolean test = currentUser.facadeLogin("Linda", " ");
        assertEquals(false, test);
    }

    @Test
    public void noUsername()
    {
        boolean test = currentUser.facadeLogin(" ", "123456 ");
        assertEquals(false, test);
    }
}
