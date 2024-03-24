import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;


/*
 * Tested by Lee Moorman
 */

public class CourseTest {
    private Course course;
    private UUID uuid = UUID.randomUUID();
    private ArrayList<Availablity> availability;
    private HashMap<UUID, String> prerequisites;
    private ArrayList<UUID> corequisitesIDs;

    @BeforeEach
    public void setup(){
        availability = new ArrayList<Availablity>();
        prerequisites = new HashMap<UUID, String>();
        corequisitesIDs = new ArrayList<UUID>();
        course = new Course(uuid, "TestName", "TestDept", "111", "TestDescription", 3, availability, prerequisites, corequisitesIDs);
    }

    @Test
    public void testConstructorId(){
        assertEquals(uuid, course.getId());
    }

    @Test
    public void testConstructorAvailability(){
        assertEquals(availability, course.getAvailablity());
    }

    @Test 
    public void testConstructorPrerequisites(){
        assertEquals(prerequisites, course.getPrerequisite());
    }

    @Test
    public void testConstructorCorequisitesId(){
        assertEquals(corequisitesIDs, course.getCorequisite());
    }

    @Test
    public void testConstructorDetails(){
        assertEquals("TestName", course.getName());
        assertEquals("TestDept", course.getDepartment());
        assertEquals("111", course.getNumber());
        assertEquals("TestDescription", course.getDescription());
        assertEquals(3, course.getCreditHours());
    }

}
