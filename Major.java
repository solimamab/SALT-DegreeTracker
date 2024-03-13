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


    //ask abhinav about data defaultplan in dataloader
    public Major(UUID id2, String majorName2, ArrayList<UUID> requiredCoursesIDs,
            ArrayList<EightSemesterPlan> defaultPlan) {
        //TODO Auto-generated constructor stub
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
