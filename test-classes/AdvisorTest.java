import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

/**
* Tested by abhinavk
*/
public class AdvisorTest {
    
    private Advisor advisor;
    private UUID advisorId;
    private ArrayList<UUID> studentIDs;
    private Student testStudent;
    
    @BeforeEach
    public void setUp() {
        advisorId = UUID.randomUUID();
        studentIDs = new ArrayList<>();
        studentIDs.add(UUID.randomUUID()); // Simulating a student ID.
        advisor = new Advisor(advisorId, "testUsername", "testPassword", "John", "Doe", studentIDs);
    }
    
    @Test
    public void testConstructorId() {
        assertEquals(advisorId, advisor.getAdvisorID(), "Advisor ID should match the one provided at construction.");
    }
    
    @Test
    public void testConstructorDetails() {
        assertEquals("John", advisor.getFirstName(), "Advisor first name should match.");
        assertEquals("Doe", advisor.getLastName(), "Advisor last name should match.");
        assertEquals("testUsername", advisor.getUsername(), "Username should match.");
        assertEquals("testPassword", advisor.getPassword(), "Password should match.");
        assertNotNull(advisor.viewAdvisingStudents(), "Advising students list should not be null.");
        assertEquals(1, advisor.viewAdvisingStudents().size(), "Should have one student ID initially.");
    }
    
    @Test
    public void testSearchForStudentById() {
        UUID studentId = studentIDs.get(0); // Using the ID added in setup.
        Student foundStudent = advisor.searchForStudent(studentId);
        assertEquals(testStudent.getUUID(), foundStudent.getUUID(), "The student ID should match the searched ID.");
    }
    
    @Test
    public void testSearchForStudentByName() {
        // Similar to ID test, but for name.
        // Test `UserList.findStudentByName` to return a specific student based on name.
        Student foundStudent = advisor.searchForStudent(testStudent.getFirstName(), testStudent.getLastName());
        assertEquals(testStudent.getFirstName(), foundStudent.getFirstName(), "First names should match.");
        assertEquals(testStudent.getLastName(), foundStudent.getLastName(), "Last names should match.");
    }

}
