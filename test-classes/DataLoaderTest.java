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
    void loadCourses_ReturnsNonEmptyHashMap() {
        HashMap<UUID, Course> courses = DataLoader.loadCourses();
        assertNotNull(courses);
        assertEquals(false, courses.isEmpty());
    }

    @Test
    void loadStudents_ReturnsNonEmptyList() {
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        assertNotNull(coursesMap);
        ArrayList<Student> students = DataLoader.loadStudents(coursesMap);
        assertNotNull(students);
        assertEquals(false, students.isEmpty());
    }

    @Test
    void loadMajors_ReturnsNonEmptyList() {
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        assertNotNull(coursesMap);
        ArrayList<Major> majors = DataLoader.loadMajors(coursesMap);
        assertNotNull(majors);
        assertEquals(false, majors.isEmpty());
    }

    @Test
    void loadAdvisors_ReturnsNonEmptyList() {
        ArrayList<Advisor> advisors = DataLoader.loadAdvisors();
        assertNotNull(advisors);
        assertEquals(false, advisors.isEmpty());
    }
}
