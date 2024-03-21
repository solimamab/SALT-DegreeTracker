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
    @BeforeEach
    public void setup()
    {
        userList.addStudent(null);
    }
    @Test
    public void testConstructor()
    {

    }

    //Testing getUser Method
    @Test
    public void getUser()
    {

    }

    //testing add student 
    // null username
    // null id 
    // duplicate username
    @Test
    public void testAddStudent()
    {

    }

    @Test 
    public void testAddAdvisor()
    {

    }

    @Test
    public void findAdvisor()
    {

    }

    //wrong id 
    // no id 
    // student not in list
    @Test 
    public void testFindstudentbyID()
    {

    }

    // emty first name
    // empty last name 
    // student not in the list
    @Test
    public void testFindStudentbyName()
    {

    }
}
