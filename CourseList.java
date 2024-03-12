import java.util.ArrayList;

/**
 * 
 */
public class CourseList {

    private static CourseList courseList;
    // private Course courseTest; //just here for a filler 
    private ArrayList<Course> listOfCourses;

    /**
     * 
     */
    private CourseList()
    {
        listOfCourses = (DataLoader.loadCourses() == null ? new ArrayList<>() : DataLoader.loadCourses());
    }

    private CourseList(ArrayList<Course> courses) {
        listOfCourses = courses;
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

    public void saveCourses() {
        DataWriter.saveCourses(listOfCourses);
    }
}
