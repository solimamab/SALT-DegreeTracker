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
     * 
     * @param course
     * @return
     */
    public ArrayList<String> viewCourseDetails(Course course)
    {
        return new ArrayList<String>();
    }
    
}
