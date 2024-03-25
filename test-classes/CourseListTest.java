import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.HashMap;

/*
 * Tested by Lee Moorman 
 */

public class CourseListTest {
    private CourseList courseList = CourseList.getInstance();

    @Test
    public void testGetCourseByValidNumber(){
        Course course = new Course(null, "TestName", "TestDept", "111", "TestDesc", 3, null, null, null);
        courseList.addCourse(course);
        Course test = courseList.getCourseByNumber("TestDept", "111");
        assertEquals(test, course);
    }

    @Test
    public void testGetCourseByNotValidNumber(){
        Course course = new Course(null, "TestName", "TestDept", "111", "TestDesc", 3, null, null, null);
        courseList.addCourse(course);
        Course test = courseList.getCourseByNumber("TestDept", "112");
        assertEquals(null, test);
    }

    @Test
    public void testGetCourseByNotValidDepartment(){
        Course course = new Course(null, "TestName", "TestDept", "111", "TestDesc", 3, null, null, null);
        courseList.addCourse(course);
        Course test = courseList.getCourseByNumber("WrongDept", "112");
        assertEquals(null, test);
    }
}
