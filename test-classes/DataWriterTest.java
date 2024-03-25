import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class DataWriterTest {

    private Student testStudent;
    private Advisor testAdvisor;
    private Major testMajor;
    private Course testCourse;
    private EightSemesterPlan testPlan;

    @BeforeEach
    public void setUp() throws Exception {
        // Clear files before each test
        new FileWriter("tester_advisor.json", false).close();
        new FileWriter("tester_course.json", false).close();
        new FileWriter("tester_students.json", false).close();
        new FileWriter("tester_major.json", false).close();

        // Initialize objects for testing - assuming these methods exist and work as described
        ArrayList<Advisor> advisors = UserList.getInstance().getAdvisors();
        HashMap<UUID, Course> courses = CourseList.getInstance().getAllCourses();
        ArrayList<Major> majors = MajorList.getInstance().getAvailableMajors();
        ArrayList<Student> students = UserList.getInstance().getStudents();

        // Assuming these lists/maps are never empty. Adjust accordingly.
        //testAdvisor = advisors.get(1);
        //testMajor = majors.get(1);
        //testStudent = students.get(1);
        // Grabbing the first course from the map
        //testCourse = courses.values().iterator().next();
        // Assuming EightSemesterPlan is a property of Student
        //testPlan = testStudent.getEightSemesterPlan();
    }

    @Test
    public void saveAdvisors_FileNotEmpty() {
        DataWriter.saveAdvisors();
        try {
            assertTrue(Files.size(Paths.get("tester_advisor.json")) > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveAdvisors_FileProperlyFormatted() throws Exception {
        DataWriter.saveAdvisors();
        try (FileReader reader = new FileReader("tester_advisor.json")) {
            JSONParser parser = new JSONParser();
            JSONArray json = (JSONArray) parser.parse(reader);
            assertTrue(json.toJSONString().contains("\n"), "JSON format incorrect");
        }
    }

    // Repeat similar structure for saveCourses, saveStudents, saveMajor

    @Test
    public void getAdvisorJSON_MatchesAttributes() {
        ArrayList<Advisor> advisors = UserList.getInstance().getAdvisors();
        testAdvisor = advisors.get(0);
        JSONObject jsonAdvisor = DataWriter.getAdvisorJSON(testAdvisor);
        assertEquals(testAdvisor.getAdvisorID().toString(), jsonAdvisor.get("id"), "Advisor IDs don't match.");
        assertEquals(testAdvisor.getUsername(), jsonAdvisor.get("username"));
        assertEquals(testAdvisor.getPassword(), jsonAdvisor.get("password"));
        assertEquals(testAdvisor.getFirstName(), jsonAdvisor.get("firstname"));
        assertEquals(testAdvisor.getLastName(), jsonAdvisor.get("lastname"));
        JSONArray studentIDsJson = (JSONArray) jsonAdvisor.get("studentIDs");
        ArrayList<UUID> studentIDs = testAdvisor.getStudents(); // Assuming this method exists
        assertEquals(studentIDs.size(), studentIDsJson.size());
    }

    @Test
    public void getCourseJSON_MatchesAttributes() {
        JSONObject jsonCourse = DataWriter.getCourseJSON(testCourse);
        assertEquals(testCourse.getId().toString(), jsonCourse.get("COURSE_ID"));
        // do this for COURSE_NAME, COURSE_CREDIT_HOURS, COURSE_DESCRIPTION,COURSE_NUMBER,COURSE_DEPARTMENT
    }

    public void getStudentJSON_MatchesAttributes() {
        JSONObject jsonStudent = DataWriter.getStudentJSON(testStudent);
        assertEquals(testStudent.getUUID().toString(), jsonStudent.get("STUDENT_ID"));
        // do this for username, password, firstname, lastname, classification, completedcredithours, remainingcredithours, FERPA, MINOR, OverallGPA, flag major, advisorID
    }


    public void getMajorJSON_MatchesAttributes() {
        JSONObject jsonMajor = DataWriter.getMajorJSON(testMajor);
        assertEquals(testMajor.getId().toString(), jsonMajor.get("Major_ID"));
        // do this for name, requiredCourses, defaultPlan
    }


    // Remember to add tests for saveStudents, saveCourses, and saveMajor following the above examples.
}