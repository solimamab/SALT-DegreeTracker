import java.util.ArrayList;
import java.util.UUID;

/**
 * 
 */
public class Course {
    private UUID id;
    private String name;
    private String department;
    private String number;
    private String description;
    private int creditHours;
    private Availablity availablity;
    private ArrayList<Course> prerequisite;
    private ArrayList<Course> corequisite;

    /**
     * 
     * @param id
     * @param name
     * @param department
     * @param number
     * @param description
     * @param creditHours
     * @param availablity
     * @param prerequisite
     * @param corequisite
     */
    public Course(UUID id, String name, String department, String number, String description, int creditHours,
    Availablity availablity, ArrayList<Course> prerequisite, ArrayList<Course> corequisite)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.number = number;
        this.department = description;
        this.creditHours = creditHours;
        this.availablity = availablity;
        this.prerequisite = prerequisite;
        this.corequisite= corequisite;
    }

    /**
     * The method to be able to view course details
     * @param course the course for the details to be accessed
     * @return the string to represent the course details
     */
    public String viewCourseDetails(Course course)
    {
        return course.name + " " + course.department + " " + course.number + " " 
        + course.description + " " + course.creditHours + " " + course.availablity + " " 
        + course.prerequisite + " " + course.corequisite;
    }
    
    
}
