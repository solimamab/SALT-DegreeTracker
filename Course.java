import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    private long creditHours;
    private Availablity availablity;
    private HashMap<UUID, String> prerequisite;
    private ArrayList<UUID> corequisite;
    
    public Course(UUID id, String name, String department, String number, String description, long creditHours,
    Availablity availability, HashMap<UUID, String> prerequisites, ArrayList<UUID> corequisiteIDs) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.number = number;
        this.description = description;
        this.creditHours = creditHours;
        this.availablity = availablity; 
        this.prerequisite = prerequisites;
        this.corequisite = corequisiteIDs;
    }
    
    /**
    * The method to be able to view course details
    * @return the string to represent the course details
    */
    public String viewCourseDetails()
    {
        return name + " " + department + " " + number + " " 
        + description + " " + creditHours + " " + availablity + " " 
        + prerequisite + " " + corequisite;
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
    
    public long getCreditHours() {
        return creditHours;
    }
    
    public Availablity getAvailablity()
    {
        return availablity;
    }
    
    public HashMap<UUID,String> getPrerequisite() {
        return prerequisite;
    }
    
    public ArrayList<UUID> getCorequisite() {
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
    
    public void setPrerequisite(HashMap<UUID, String> prerequisites) {
        this.prerequisite = prerequisites;
    }
    
    public void setCorequisite(ArrayList<UUID> corequisite) {
        this.corequisite = corequisite;
    }
    
}
