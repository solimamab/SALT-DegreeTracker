import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Tested by abhinavk
 */
public class DataLoaderTest {

    @Test
    void loadCourses_ReturnsNonEmptyHashMapWithValidCourses() {
        HashMap<UUID, Course> courses = DataLoader.loadCourses();
        assertNotNull(courses, "Courses map should not be null");
        assertFalse(courses.isEmpty(), "Courses map should not be empty");

        // Additional checks for the integrity of each course
        courses.forEach((uuid, course) -> {
            assertNotNull(course.getId(), "Course id should not be null");
            assertNotNull(course.getName(), "Course name should not be null");
            assertNotNull(course.getDepartment(), "Course department should not be null");
            assertNotNull(course.getNumber(), "Course number should not be null");
            assertNotNull(course.getDescription(), "Course description should not be null");
            assertNotNull(course.getCreditHours(), "Course credit hours should not be null");
            assertNotNull(course.getAvailablity(), "Course availability should not be null");
            assertNotNull(course.getPrerequisite(), "Course prerequisites should not be null");
            assertNotNull(course.getCorequisite(), "Course corequisites should not be null"); // didnt pass test
        });
    }

    @Test
    void loadStudents_ReturnsNonEmptyListWithValidStudents() {
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        assertNotNull(coursesMap, "Courses map for loading students should not be null");
        ArrayList<Student> students = DataLoader.loadStudents(coursesMap);
        assertNotNull(students, "Students list should not be null");
        assertFalse(students.isEmpty(), "Students list should not be empty");

        // Verify each student's attributes
        students.forEach(student -> {
            assertNotNull(student.getUsername(), "Student username should not be null");
            assertNotNull(student.getPassword(), "Student password should not be null");
            assertNotNull(student.getFirstName(), "Student first name should not be null");
            assertNotNull(student.getLastName(), "Student last name should not be null");
            assertNotNull(student.getUUID(), "Student id should not be null");
            assertNotNull(student.getClassification(), "Student classification should not be null");
            assertNotNull(student.getCompletedCreditHours(), "Student completed credit hours should not be null");
            assertNotNull(student.getRemainingCreditHours(), "Student remaining credit hours should not be null");
            assertNotNull(student.getFlag(), "Student flag should not be null");
            assertNotNull(student.getOverallGPA(), "Student overall GPA should not be null");
            assertNotNull(student.getMajor(), "Student major should not be null"); // didnt pass test
            assertNotNull(student.getMinor(), "Student minor should not be null");
            assertNotNull(student.getFEPRA(), "Student FERPA should not be null");
            assertNotNull(student.getAdvisor(), "Student advisor should not be null");
            assertNotNull(student.getEightSemesterPlan(), "Student eight-semester-plan should not be null");
            assertNotNull(student.getCurrentCourses(), "Student current courses should not be null");
            assertNotNull(student.getCompletedCourses(), "Student completed courses should not be null");
            assertNotNull(student.getNote(), "Student note should not be null");
        });
    }

    @Test
    void loadMajors_ReturnsNonEmptyListWithValidMajors() {
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        assertNotNull(coursesMap, "Courses map for loading majors should not be null");
        ArrayList<Major> majors = DataLoader.loadMajors(coursesMap);
        assertNotNull(majors, "Majors list should not be null");
        assertFalse(majors.isEmpty(), "Majors list should not be empty");

        // Verify each major's attributes
        majors.forEach(major -> {
            assertNotNull(major.getId(), "Major id should not be null");
            assertNotNull(major.getMajorName(), "Major name should not be null");
            assertNotNull(major.getDefaultPlan(), "Major default plan should not be null");
            assertFalse(major.getRequiredCourses().isEmpty(), "Major's required courses list should not be empty");
        });
    }

    @Test
    void loadAdvisors_ReturnsNonEmptyListWithValidAdvisors() {
        ArrayList<Advisor> advisors = DataLoader.loadAdvisors();
        assertNotNull(advisors, "Advisors list should not be null");
        assertFalse(advisors.isEmpty(), "Advisors list should not be empty");

        // Verify each advisor's attributes
        advisors.forEach(advisor -> {
            assertNotNull(advisor.getAdvisorID(), "Advisor id should not be null");
            assertNotNull(advisor.getUsername(), "Advisor username should not be null");
            assertNotNull(advisor.getPassword(), "Advisor password should not be null");
            assertNotNull(advisor.getFirstName(), "Advisor first name should not be null");
            assertNotNull(advisor.getLastName(), "Advisor last name should not be null");
            assertFalse(advisor.getStudents().isEmpty(), "Advisor's advised students list should not be empty");
        });
    }
}
