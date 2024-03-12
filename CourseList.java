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
        for(int i = 0; i < availableCourses.size(); i++)
        {
            if (availableCourses.get(i).getDepartment().equals(department) && availableCourses.get(i).getNumber().equals(number))
            {
                return availableCourses.get(i);
            }
            i++;
        }
        return null;
    }

    public void saveCourses() {
        DataWriter.saveCourses(listOfCourses);
    }
}
