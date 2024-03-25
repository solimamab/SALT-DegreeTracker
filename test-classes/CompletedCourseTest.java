import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;

/*
 * Tested by Lee Moorman 
 */

public class CompletedCourseTest {
    private Course course = new Course(null, "TestName", "TestDept", "111", "TestDesc", 3, null, null, null);
    private CompletedCourse completedCourse;

    @Test
    public void testConstructorGrade(){
        assertEquals(Grade.B_PLUS, completedCourse.getLetterGrade());
    }

    @Test 
    public void testSetQualityPoints(){
        double points = 10.5;
        completedCourse = new CompletedCourse(course, Grade.B_PLUS);
        assertEquals(10.5, completedCourse.getqualityPoints());
    }
}
