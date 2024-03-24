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
public class EightSemesterPlanTest {
    private EightSemesterPlan plan;
    private Course testCourse1, testCourse2, testCourse3;
    
    @BeforeEach
    void setUp() {
        plan = new EightSemesterPlan();
        testCourse1 = new Course(UUID.randomUUID(), "Test Course 1", "TC", "101", null, 0, null, null, null);
        testCourse2 = new Course(UUID.randomUUID(), "Test Course 2", "TC", "102", null, 0, null, null, null);
        testCourse3 = new Course(UUID.randomUUID(), "Test Course 3", "TC", "103", null, 0, null, null, null);
    }
    
    @Test
    void addCourseToSemester_ValidSemester_AddsCorrectly() {
        plan.addCourseToSemester(1, testCourse1);
        assertEquals(1, plan.getSemesters().get(0).size());
        assertTrue(plan.getSemesters().get(0).contains(testCourse1));
    }
    
    @Test
    void addCourseToSemester_InvalidSemester_NoAddition() {
        plan.addCourseToSemester(9, testCourse1); // Assuming semester should be between 1 and 8
        for (ArrayList<Course> semester : plan.getSemesters()) {
            assertFalse(semester.contains(testCourse1));
        }
    }
    
    @Test
    void getAllCoursesInPlan_AddsCoursesCorrectly() {
        plan.addCourseToSemester(1, testCourse1);
        plan.addApplicationAreaCourse(testCourse2);
        plan.addElectiveChoice(testCourse3);
        
        ArrayList<Course> allCourses = plan.getAllCoursesInPlan();
        assertTrue(allCourses.contains(testCourse1));
        assertTrue(allCourses.contains(testCourse2));
        assertTrue(allCourses.contains(testCourse3));
        assertEquals(3, allCourses.size());
    }
    
    @Test
    void setMajorProgress_ValidProgress_SetsCorrectly() {
        double progress = 50.0;
        plan.setMajorProgress(progress);
        assertEquals(progress, plan.getMajorProgress());
    }
    
    @Test
    void addElectiveChoice_AddsCourseCorrectly() {
        plan.addElectiveChoice(testCourse1);
        assertTrue(plan.getElectiveChoices().contains(testCourse1));
        assertEquals(1, plan.getElectiveChoices().size());
    }
    
    @Test
    void removeElectiveChoice_RemovesCourseCorrectly() {
        plan.addElectiveChoice(testCourse1);
        plan.removeElectiveChoice(testCourse1);
        assertFalse(plan.getElectiveChoices().contains(testCourse1));
    }
    
    @Test
    void setApplicationArea_SetsCoursesCorrectly() {
        ArrayList<Course> applicationCourses = new ArrayList<>();
        applicationCourses.add(testCourse1);
        applicationCourses.add(testCourse2);
        plan.setApplicationArea(applicationCourses);
        
        assertTrue(plan.getApplicationArea().contains(testCourse1));
        assertTrue(plan.getApplicationArea().contains(testCourse2));
        assertEquals(2, plan.getApplicationArea().size());
    }
    
    @Test
    void setElectiveChoices_SetsCoursesCorrectly() {
        ArrayList<Course> electiveCourses = new ArrayList<>();
        electiveCourses.add(testCourse2);
        electiveCourses.add(testCourse3);
        plan.setElectiveChoices(electiveCourses);
        
        assertTrue(plan.getElectiveChoices().contains(testCourse2));
        assertTrue(plan.getElectiveChoices().contains(testCourse3));
        assertEquals(2, plan.getElectiveChoices().size());
    }
    
    @Test
    void addSemesterCourses_AddsMultipleCoursesCorrectly() {
        ArrayList<Course> semesterCourses = new ArrayList<>();
        semesterCourses.add(testCourse1);
        semesterCourses.add(testCourse2);
        plan.addSemesterCourses(1, semesterCourses);
        
        assertTrue(plan.getSemesters().get(0).contains(testCourse1));
        assertTrue(plan.getSemesters().get(0).contains(testCourse2));
        assertEquals(2, plan.getSemesters().get(0).size());
    }
    
    @Test
    void setSemesterCourses_SetsCoursesCorrectly() {
        ArrayList<Course> semesterCourses = new ArrayList<>();
        semesterCourses.add(testCourse3);
        plan.setSemesterCourses(1, semesterCourses);
        
        assertTrue(plan.getSemesters().get(0).contains(testCourse3));
        assertEquals(1, plan.getSemesters().get(0).size());
    }
}
