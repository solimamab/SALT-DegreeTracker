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
     * This method is to be able to search for a class in the list of available classses
     * @param department the department of the course to be searched the CSCE in CSCE 247
     * @param number the number of the ourse to be searched the 247 in CSCE 247
     * @return the course that matches the department and number being search or returns null if class is not found
     */
    public Course getCourseByNumber(String department, String number)
    {
        for(int i = 0; i < listOfCourses.size(); i++)
        {
            if (listOfCourses.get(i).getDepartment().equals(department) && listOfCourses.get(i).getNumber().equals(number))
            {
                return listOfCourses.get(i);
            }
            i++;
        }
        return null;
    }

    public Course addCourse(Course course) {
        return new Course(null, null, null, null, null, 0, null, null, null);
    }

    public void saveCourses() {
        DataWriter.saveCourses(listOfCourses);
    }
}
