import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * The User List Class has been tested by Tristen Lilly
 */

public class UserListTest {
    private UserList userList = UserList.getInstance();
    
    //Testing getUser Method
    @Test
    public void getValidUser()
    {
        Student amy = new Student(new UUID(0, 0), "Asmith", "12345", "amy", "smith");
        userList.addStudent(amy);
        User getusertest = userList.getUser("Asmith");
        assertEquals(amy, getusertest);

    }

    @Test
    public void validUserbutWithoutCaseMatching()
    {
        Student bob = new Student(new UUID(0, 0), "Bsmith", "12345", "bob", "smith");
        userList.addStudent(bob);
        User getusertest = userList.getUser("bsmith");
        assertEquals(null, getusertest);

    }

    @Test
    public void getNotaUser()
    {
        User getUsertest = userList.getUser("Tristen");
        assertEquals(null, getUsertest);
    }

    @Test
    public void nullUsername()
    {
        User getUsertest = userList.getUser(null);
        assertEquals(null, getUsertest);
    }

    
    //Testing the findAdvisor method
    @Test
    public void findValidAdvisor()
    {
        Advisor bobby = new Advisor(UUID.fromString("12345"), "bobbysm", "2345", "bobby", "smithy", null);
        Advisor test = userList.findAdvisor(UUID.fromString("12345"));
        assertEquals(bobby, test);
    }

    @Test 
    public void notValidAdvisor()
    {
        Advisor test = userList.findAdvisor(UUID.fromString("12345678"));
        assertEquals(null, test);
    }

    @Test
    public void emptyAdvisorID()
    {
        Advisor test = userList.findAdvisor(null);
        assertEquals(null, test);
    }

    //Testing the findStudentById method
    @Test 
    public void testFindVALIDstudentbyID()
    {
        Student BB = new Student(UUID.fromString("0522203"), "BBlilly", "12345678", "BB", "Lilly");
        Student test = userList.findStudentById(UUID.fromString("0522203"));
        assertEquals(BB, test);
    }

    @Test
    public void findNotValidStudentId()
    {
        Student test = userList.findStudentById(UUID.fromString("100000000"));
        assertEquals(null, test);
    }

    @Test
    public void NoIdprovided()
    {
        Student test = userList.findStudentById(null);
        assertEquals(null, test);
    }

    // Testing the findStudentByName method
    @Test
    public void testFindValidStudentbyName()
    {
        Student JBJ = new Student(new UUID(0, 0), "junieBjones", "12345678", "junie", "jones");
        Student test = userList.findStudentByName("junie", "jones");
        assertEquals(JBJ, test);
    }

    @Test
    public void emptyFirstName()
    {
        Student test = userList.findStudentByName(null, "jones");
        assertEquals(null, test);
    }

    @Test
    public void emptyLastName()
    {
        Student test = userList.findStudentByName("junie", null);
        assertEquals(null, test);
    }

    @Test
    public void studentNotinList()
    {
        Student test = userList.findStudentByName("Delaine", "Hayden");
        assertEquals(null, test);
    }
}
