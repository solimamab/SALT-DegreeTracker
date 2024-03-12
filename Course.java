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
    private long number;
    private String description;
    private long creditHours;
    private Availablity availablity;
    private HashMap<UUID, String> prerequisite;
    private ArrayList<UUID> corequisite;
    
    public Course(UUID id, String name, String department, long number, String description, long creditHours,
    Availablity availability, HashMap<UUID, String> prerequisiteIDs, ArrayList<UUID> corequisiteIDs) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.number = number;
        this.description = description;
        this.creditHours = creditHours;
        this.availablity = availablity; 
        this.prerequisite = new HashMap<>();
        for (UUID prerequisiteID : prerequisite) {
            this.prerequisite.put(prerequisiteID, ""); // Placeholder for grade requirement, if any
        }
        this.corequisite = new ArrayList<>();
        for (UUID corequisiteID : corequisiteIDs) {
            this.corequisite.add(corequisiteID);
        }
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
    
    public long getNumber() {
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
    
    public void setNumber(long number) {
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
