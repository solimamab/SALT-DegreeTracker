import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class GradeSystemFACADETest {

    private GradeSystemFACADE facade;
    private UserList mockUserList;
    private CourseList mockCourseList;
    private MajorList mockMajorList;
    private final String writePlantoTextFilePath = "SemesterPlan.txt"; // TODO: Define the actual path

    @BeforeEach
    public void setUp() throws Exception {

        mockUserList = UserList.getInstance();
        mockCourseList = CourseList.getInstance();
        mockMajorList = MajorList.getInstance();
        facade = GradeSystemFACADE.getFacadeInstance(mockUserList, mockCourseList, mockMajorList);

        try {
            Files.deleteIfExists(Paths.get(writePlantoTextFilePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetFacadeInstance() {
        assertNotNull(facade, "Facade instance should not be null");
    }

    @Test
    public void testFindCourse() {
        HashMap<UUID, Course> courses = mockCourseList.getAllCourses();
        Course first = null;
        if(!courses.isEmpty()){
            first = courses.values().iterator().next();
        }

        String department = "CSCE";
        String number = "247";
        mockCourseList.addCourse(department, number, first); // Adjust method call as per your implementation

        Course result = facade.findCourse(department, number);
        assertEquals(first, result, "Expected course should be returned");
    }

    @Test
    public void testLogin() {
        User mockUser = new User("BWest", "12345", "Brax", "West"); 
        // Setting up a specific user for login instead of using anyString()
        mockUserList.addUser(mockUser); // Adjust addUser method as per your implementation

        boolean loginSuccess = facade.login("BWest", "12345");
        assertTrue(loginSuccess, "Login should succeed with correct credentials");
    }

    @Test
    public void testGetUserDetails() {
        User mockUser = new User("BWest", "12345", "Brax", "West");
        // Adding the user directly to mockUserList
        mockUserList.addUser(mockUser); // Assume this method exists and correctly adds the user

        String userDetails = facade.getUserDetails("BWest");
        assertNotNull(userDetails, "User details should be returned");
    }

    @Test
    public void testFindStudent() {
        Student mockStudent = mockUserList.getStudents().get(0);
        mockUserList.addStudent(mockStudent); // Assume this method exists and correctly adds the student

        Student result = facade.findStudent("studentUsername");
        assertEquals(mockStudent, result, "Expected student should be returned");
    }

    @Test
    public void testWritePlantoTextFileExists() {
        Student student = mockUserList.getStudents().get(0);
        facade.writePlantoTextFile(student);

        File file = new File(writePlantoTextFilePath);
        assertTrue(file.exists(), "File should exist after writePlantoTextFile method execution");
    }

    @Test
    public void testLogout() {
        facade.login("BWest", "12345");
        boolean loggedOut = facade.Logout();
        assertTrue(loggedOut, "Logout should return true when user is logged out");
    }
}
