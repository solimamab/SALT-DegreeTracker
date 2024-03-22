import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The Student Class has been tested by Tristen :)
 */

public class StudentTest {

    // Testing the setClassifcation Method
    @Test 
    public void FreshmenClassifaction()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        tree.setClassifcation(0);
        Classification test = tree.getClassification();
        assertEquals(Classification.FRESHMAN, test);

    }

    @Test
    public void SOPHOMOREClassification()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        tree.setClassifcation(30);
        Classification test = tree.getClassification();
        assertEquals(Classification.SOPHOMORE, test);
    }

    @Test
    public void JUNIORClassifictaion()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        tree.setClassifcation(65);
        Classification test = tree.getClassification();
        assertEquals(Classification.JUNIOR, test);
    }

    @Test 
    public void SENIORClassification()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        tree.setClassifcation(100);
        Classification test = tree.getClassification();
        assertEquals(Classification.SENIOR, test);
    }

    @Test
    public void nullCompletedCourses()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        Classification test = tree.getClassification();
        assertEquals(null, test);
        
    }
    // Testing the setCompletedHours Method
    @Test
    public void validCompletedHours()
    {
        Student brax = UserList.getInstance().findStudentByName("Brax", "West");
        long test = brax.setCompletedHours(brax.getCompletedCourses());
        assertEquals(63, test);
    }

    @Test
    public void noCompletedHours()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        long test = tree.setCompletedHours(null);
        assertEquals(0, test);
    }

    //Testing the setOverallGPA Method
    @Test
    public void validGPA()
    {
        Student brax = UserList.getInstance().findStudentByName("Brax", "West");
        double test = brax.setOverallGPA(brax.getCompletedCourses());
        assertEquals(4.0, test);
    }

    @Test
    public void noCompletedCoures()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        double test = tree.setOverallGPA(null);
        assertEquals(0, test);
    }

    // Testing addCompletedCourse 
    @Test 
    public void validCourse()
    {
        Student tree = new Student(null, "tree", "123456", "tree", "branch");
        Course course =new Course(null, "Basket Weaving", "ARTS", "456", null, 0, null, null, null);
        tree.addCompletedCourse(course, Grade.A);
        ArrayList<CompletedCourse> CompCourses = tree.getCompletedCourses();
        int test = CompCourses.size();
        assertEquals(1, test);
    }

    @Test
    public void emptyCourse()
    {
        Student bobbie = new Student(null, "bobbie", "123456", "tree", "branch");
        bobbie.addCompletedCourse(null, Grade.A);
        ArrayList<CompletedCourse> CompCourses = bobbie.getCompletedCourses();
        int test = CompCourses.size();
        assertEquals(0, test);
        
    }
}
