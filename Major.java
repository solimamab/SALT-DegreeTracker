import java.util.ArrayList;
import java.util.UUID;

public class Major {
    private UUID id;
    private String majorName;
    private ArrayList<Course> requiredCourses;
    private EightSemesterPlan majorMap;

    
    public Major(UUID id, String majorName, ArrayList<Course> requiredCourses, EightSemesterPlan majorMap) {
        this.id = id;
        this.majorName = majorName;
        this.requiredCourses = requiredCourses;
        this.majorMap = majorMap;
    }

    /**
     * Getters for the artibutes of the major class
     */
    public UUID getId() {
        return id;
    }

    public String getMajorName()
    {
        return this.majorName;
    }

    public ArrayList<Course> getRequiredCourses()
    {
        return this.requiredCourses;
    }

    public EightSemesterPlan getMajorMap()
    {
        return this.majorMap;
    }
}
