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
        ArrayList<Major> majors = MajorList.getInstance().getAvailableMajors();
        testMajor = majors.get(1);
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
    public void saveCourses_FileNotEmpty() {
        DataWriter.saveCourses();
        try {
            assertTrue(Files.size(Paths.get("tester_course.json")) > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveStudents_FileNotEmpty() {
        DataWriter.saveStudents();
        try {
            assertTrue(Files.size(Paths.get("tester_students.json")) > 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void saveMajor_FileNotEmpty() {
        DataWriter.saveMajor();
        try {
            assertTrue(Files.size(Paths.get("tester_major.json")) > 0);
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

    @Test
    public void saveCourses_FileProperlyFormatted() throws Exception {
        DataWriter.saveCourses();
        try (FileReader reader = new FileReader("tester_course.json")) {
            JSONParser parser = new JSONParser();
            JSONArray json = (JSONArray) parser.parse(reader);
            assertTrue(json.toJSONString().contains("\n"), "JSON format incorrect");
        }
    }

    @Test
    public void saveStudents_FileProperlyFormatted() throws Exception {
        DataWriter.saveStudents();
        try (FileReader reader = new FileReader("tester_students.json")) {
            JSONParser parser = new JSONParser();
            JSONArray json = (JSONArray) parser.parse(reader);
            assertTrue(json.toJSONString().contains("\n"), "JSON format incorrect");
        }
    }

    @Test
    public void saveMajor_FileProperlyFormatted() throws Exception {
        DataWriter.saveMajor();
        try (FileReader reader = new FileReader("tester_major.json")) {
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
        assertEquals(testAdvisor.getUsername(), jsonAdvisor.get("username"), "Usernames don't match.");
        assertEquals(testAdvisor.getPassword(), jsonAdvisor.get("password"), "Passwords don't match.");
        assertEquals(testAdvisor.getFirstName(), jsonAdvisor.get("firstname") , "First names don't match.");
        assertEquals(testAdvisor.getLastName(), jsonAdvisor.get("lastname"), "Last names don't match.");
        JSONArray studentIDsJson = (JSONArray) jsonAdvisor.get("studentIDs");
        ArrayList<UUID> studentIDs = testAdvisor.getStudents(); 
        assertEquals(studentIDs.size(), studentIDsJson.size(), "Student ID lists don't match.");
    }

    @Test
    public void getCourseJSON_MatchesAttributes() {
        HashMap<UUID, Course> courses = CourseList.getInstance().getAllCourses();
        testCourse = courses.values().iterator().next();
        JSONObject jsonCourse = DataWriter.getCourseJSON(testCourse);
        assertEquals(testCourse.getId().toString(), jsonCourse.get("id"), "Course IDs don't match.");
        assertEquals(testCourse.getDepartment(), jsonCourse.get("department"), "Departments don't match.");
        assertEquals(testCourse.getNumber(), jsonCourse.get("number"), "Course numbers don't match.");
        assertEquals(testCourse.getName(), jsonCourse.get("name"), "Course names don't match.");
        assertEquals(testCourse.getDescription(), jsonCourse.get("description"), "Course descriptions don't match.");
        assertEquals(testCourse.getCreditHours(), jsonCourse.get("creditHours"), "Credit hours don't match.");
        assertEquals(testCourse.getAvailablity().toString(), jsonCourse.get("availability"), "Availabilities don't match.");
    }

    public void getStudentJSON_MatchesAttributes() {
        JSONObject jsonStudent = DataWriter.getStudentJSON(testStudent);
        assertEquals(testStudent.getUUID().toString(), jsonStudent.get("id"), "Student IDs don't match.");
        assertEquals(testStudent.getUsername(), jsonStudent.get("username"), "Usernames don't match.");
        assertEquals(testStudent.getPassword(), jsonStudent.get("password"), "Passwords don't match.");
        assertEquals(testStudent.getFirstName(), jsonStudent.get("firstname"), "First names don't match.");
        assertEquals(testStudent.getLastName(), jsonStudent.get("lastname"), "Last names don't match.");
        assertEquals(testStudent.getClassification().toString(), jsonStudent.get("classification"), "Classifications don't match.");
        assertEquals(testStudent.getCompletedCreditHours(), jsonStudent.get("completedcredithours"), "Completed credit hours don't match.");
        assertEquals(testStudent.getRemainingCreditHours(), jsonStudent.get("remainingcredithours"), "Remaining credit hours don't match.");
        assertEquals(testStudent.getFlag(), jsonStudent.get("flag"), "Flags don't match.");
        assertEquals(testStudent.getOverallGPA(), jsonStudent.get("OverallGPA"), "Overall GPAs don't match.");
        assertEquals(testStudent.getMajorID().toString(), jsonStudent.get("major"), "Major IDs don't match.");
        assertEquals(testStudent.getMinor(), jsonStudent.get("minor"), "Minors don't match.");
        assertEquals(testStudent.getFEPRA(), jsonStudent.get("FERPA"), "FERPAs don't match.");
        assertEquals(testStudent.getAdvisor().getAdvisorID().toString(), jsonStudent.get("advisorID"), "Advisor IDs don't match.");
    }


    public void getMajorJSON_MatchesAttributes() {
        ArrayList<Major> majors = MajorList.getInstance().getAvailableMajors();
        testMajor = majors.get(1);
        JSONObject jsonMajor = DataWriter.getMajorJSON(testMajor);
        assertEquals(testMajor.getId().toString(), jsonMajor.get("id"));
        JSONArray requiredCourseList = (JSONArray) testMajor.getRequiredCourses();
        JSONArray jsonRequiredCourseList = (JSONArray) jsonMajor.get("requiredCourses");
        assertEquals(requiredCourseList.size(), jsonRequiredCourseList.size(), "Required course lists don't match.");
    }


    // Remember to add tests for saveStudents, saveCourses, and saveMajor following the above examples.
}