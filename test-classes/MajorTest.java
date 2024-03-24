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
 * Tested by Libaan
 */

public class MajorTest {
    private ArrayList<Course> requiredCourses = new ArrayList<Course>();
    private EightSemesterPlan defaultPlan = new EightSemesterPlan();
    private Course sampleCourse;
    private Major major = new Major(new UUID(0, 0), "testerMajor", requiredCourses, defaultPlan);
   
     @BeforeEach
    public void setUp() {
        UUID majorId = UUID.randomUUID();
        String majorName = "Computer Science";
        requiredCourses = new ArrayList<>();
        
        UUID courseId = UUID.randomUUID();
        String courseName = "Intro to Programming";
        String department = "CS";
        String number = "101";
        String description = "Introduction to programming concepts";
        long creditHours = 4;
        ArrayList<Availablity> availabilityList = new ArrayList<>();
        availabilityList.add(Availablity.FALL); 
        HashMap<UUID, String> prerequisites = new HashMap<>();
        ArrayList<UUID> corequisites = new ArrayList<>();
        sampleCourse = new Course(courseId, courseName, department, number, description, creditHours, availabilityList, prerequisites, corequisites);
        
        requiredCourses.add(sampleCourse);
        defaultPlan = new EightSemesterPlan();
        major = new Major(majorId, majorName, requiredCourses, defaultPlan);
    }

    @Test
    public void testMajorName() {
        assertEquals("Computer Science", major.getMajorName());
    }

    @Test
    public void testMajorIdNotNull() {
        assertNotNull(major.getId());
    }

    @Test
    public void testRequiredCoursesNotEmpty() {
        assertFalse(major.getRequiredCourses().isEmpty());
    }

    @Test
    public void testDefaultPlanNotNull() {
        assertNotNull(major.getDefaultPlan());
    }
    @Test
    public void testAddCourseToFirstSemester() {
        defaultPlan.addCourseToSemester(1, sampleCourse);
        assertFalse(defaultPlan.getSemesters().get(0).isEmpty());
    }

    @Test
    public void testFirstSemesterContainsAddedCourse() {
        defaultPlan.addCourseToSemester(1, sampleCourse);
        assertTrue(defaultPlan.getSemesters().get(0).contains(sampleCourse));
    }

    @Test
    public void testToStringContainsMajorName() {
        String majorString = major.toString();
        assertTrue(majorString.contains("Computer Science"));
    }

    @Test
    public void testToStringContainsRequiredCourses() {
        String majorString = major.toString();
        assertTrue(majorString.contains(sampleCourse.toString()));
    }
}
