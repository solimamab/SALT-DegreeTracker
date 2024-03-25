import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class GradeSystemFACADETest {

    private GradeSystemFACADE facade;
    private UserList mockUserList;
    private CourseList mockCourseList;
    private MajorList mockMajorList;
    private final String writePlantoTextFilePath = "SemesterPlan.txt.txt"; // TODO: Define the actual path

    @BeforeEach
    public void setUp() throws Exception {

        mockUserList = userList.getInstance();
        mockCourseList = courseList.getInstance();
        mockMajorList = majorList.getInstance();
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
        Course expectedCourse = new Course(); // Assuming Course constructor exists
        when(mockCourseList.getCourseByNumber(anyString(), anyString())).thenReturn(expectedCourse);

        Course result = facade.findCourse("CSCE", "247");
        assertEquals(expectedCourse, result, "Expected course should be returned");
    }

    @Test
    public void testLogin() {
        User mockUser = new User("BWest", "12345", "Brax", "West"); 
        when(mockUserList.getUser(anyString())).thenReturn(mockUser);

        boolean loginSuccess = facade.login("BWest", "12345");
        assertTrue(loginSuccess, "Login should succeed with correct credentials");
    }

    @Test
    public void testGetUserDetails() {
        User mockUser = new User("BWest", "12345", "Brax", "West");
        when(mockUserList.getUser(anyString())).thenReturn(mockUser);

        String userDetails = facade.getUserDetails("BWest");
        assertNotNull(userDetails, "User details should be returned");
    }

    @Test
    public void testFindStudent() {
        Student mockStudent = new Student(); 
        when(mockUserList.getUser(anyString())).thenReturn(mockStudent);

        Student result = facade.findStudent("studentUsername");
        assertEquals(mockStudent, result, "Expected student should be returned");
    }

    @Test
    public void testWritePlantoTextFileExists() {
        Student student = mockUserList.getStudent("BWest");
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
