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

    public Major(UUID id2, String majorName2, ArrayList<UUID> requiredCoursesIDs, ArrayList<EightSemesterPlan> defaultPlan) {
        // stuff goes here
    }
}
