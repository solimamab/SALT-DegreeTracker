import java.util.ArrayList;

/**
 * 
 */
public class CourseList {

    private static CourseList courseList;
    // private Course courseTest; //just here for a filler 
    private ArrayList<Course> availableCourses;

    /**
     * 
     */
    private CourseList()
    {
        this.courseList = courseList;
        this.availableCourses = availableCourses;
    }

    /**
     * 
     * @return
     */
    public static CourseList getInstance()
    {
        if (courseList == null) {
            courseList = new CourseList();
        }
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
        return null;
    }
}
