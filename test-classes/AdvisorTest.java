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
        testStudent = new Student(advisorId, "studentUsername", "studentPassword", "studentFirstName", "studentLastName");
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
        assertEquals(0, advisor.viewAdvisingStudents().size(), "Should have no student IDs initially.");
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
    
    @Test
    public void setStudentsFlagSuccessfullySetsFlag() {
        Flag testFlag = Flag.Failure;
        advisor.setStudentsFlag(testFlag, testStudent);
        assertEquals(testFlag, testStudent.getFlag(), "The flag should be set correctly in the student.");
    }
    
    @Test
    public void setNumofStudentsReturnsCorrectCount() {
        ArrayList<UUID> studentList = new ArrayList<>();
        studentList.add(UUID.randomUUID());
        studentList.add(UUID.randomUUID());
        assertEquals(2, advisor.setNumofStudents(studentList), "Should return the correct number of students.");
    }
    
    @Test
    public void setNumofStudentsReturnsZeroForNull() {
        assertEquals(0, advisor.setNumofStudents(null), "Should return 0 for null input.");
    }
    
    @Test
    public void viewAdvisingStudentsReturnsCorrectList() {
        // First, add a student to ensure the list is not empty
        UUID newStudentId = UUID.randomUUID();
        advisor.addAdvisingStudent(newStudentId);
        ArrayList<Student> advisedStudents = advisor.viewAdvisingStudents();
        assertFalse(advisedStudents.isEmpty(), "The list of advising students should not be empty.");
    }
    
    @Test
    public void addAdvisingStudentIncreasesListSize() {
        int initialSize = advisor.viewAdvisingStudents().size();
        advisor.addAdvisingStudent(UUID.randomUUID());
        assertEquals(initialSize + 1, advisor.viewAdvisingStudents().size(), "Adding a student should increase the list size.");
    }
    
    @Test
    public void removeAdvisingStudentDecreasesListSize() {
        // First, add a student to ensure the list is not empty
        UUID newStudentId = UUID.randomUUID();
        advisor.addAdvisingStudent(newStudentId);
        int initialSize = advisor.viewAdvisingStudents().size();
        
        advisor.removeAdvisingStudent(newStudentId);
        assertEquals(initialSize - 1, advisor.viewAdvisingStudents().size(), "Removing a student should decrease the list size.");
    }
    
    @Test
    public void setStudentNoteSuccessfullySetsNote() {
        String note = "This is a test note.";
        advisor.setStudentNote(testStudent, note);
        assertEquals(note, testStudent.getNote(), "The advisor note should be set correctly in the student.");
    }
    
    
}
