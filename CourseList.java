import java.util.ArrayList;

/**
 * 
 */
public class CourseList {

    private static CourseList courseList;
    private Course courseTest; //just here for a filler 
    private ArrayList<Course> availableCourses;

    /**
     * 
     */
    private CourseList()
    {
        courseList = this;
        this.availableCourses = null;
    }

    /**
     * 
     * @return
     */
    public CourseList getInstance()
    {
        courseList = new CourseList();
        return courseList;
    }

    /**
     * 
     * @param department
     * @param number
     * @return
     */
    public Course getCourseByNumber(String department, String number)
    {
        return this.courseTest;
    }
}
