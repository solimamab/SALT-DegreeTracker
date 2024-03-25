//import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class is that hold the entire list of course imported from the JSON files
 * @author Team SALT
 */
public class CourseList {

    private static CourseList courseList;
    private HashMap<UUID, Course> listOfCourses;

    private CourseList() {
        listOfCourses = DataLoader.loadCourses();
        if (listOfCourses == null) {
            listOfCourses = new HashMap<>();
        }
    }

    public static CourseList getInstance() {
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
    public Course getCourseByNumber(String department, String number) {
        for (Course course : listOfCourses.values()) {
            if (course.getDepartment().equals(department) && course.getNumber().equals(number)) {
                return course;
            }
        }
        return null;
    }

    public HashMap<UUID, Course> getAllCourses() {
        return listOfCourses;
    }

    public void addCourse(Course course) {
        courseList.listOfCourses.put(course.getId(), course);
    }

    // public void saveCourses() {
    //     DataWriter.saveCourses(listOfCourses);
    // }
}
