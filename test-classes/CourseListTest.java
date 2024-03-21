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
    private HashMap<UUID, Course> listOfCourses;
    
    @BeforeEach
    public void setup(){
        courseList.addCourse(null);
    }

    @Test
    public void testConstructor(){

    }

    @Test
    public void testGetCourseByNumber(){

    }

    @Test

    public void testAddCourse(){

    }
}
