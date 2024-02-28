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
    
        // Getters
        public UUID getId() {
            return id;
        }
    
        public String getName() {
            return name;
        }
    
        public String getDepartment() {
            return department;
        }
    
        public String getNumber() {
            return number;
        }
    
        public String getDescription() {
            return description;
        }
    
        public int getCreditHours() {
            return creditHours;
        }
    
        public ArrayList<Course> getPrerequisite() {
            return prerequisite;
        }
    
        public ArrayList<Course> getCorequisite() {
            return corequisite;
        }
    
        // Setters
        public void setId(UUID id) {
            this.id = id;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void setDepartment(String department) {
            this.department = department;
        }
    
        public void setNumber(String number) {
            this.number = number;
        }
    
        public void setDescription(String description) {
            this.description = description;
        }
    
        public void setCreditHours(int creditHours) {
            this.creditHours = creditHours;
        }
    
        public void setPrerequisite(ArrayList<Course> prerequisite) {
            this.prerequisite = prerequisite;
        }
    
        public void setCorequisite(ArrayList<Course> corequisite) {
            this.corequisite = corequisite;
        }
    
}
