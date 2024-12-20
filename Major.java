import java.util.ArrayList;
import java.util.UUID;

public class Major {
    private UUID id;
    private String majorName;
    private ArrayList<Course> requiredCourses;
    private EightSemesterPlan defaultPlan;

    
    public Major(UUID id, String majorName, ArrayList<Course> requiredCourses, EightSemesterPlan defaultPlan) {
        this.id = id;
        this.majorName = majorName;
        this.requiredCourses = requiredCourses;
        this.defaultPlan = defaultPlan;
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

    public EightSemesterPlan getDefaultPlan()
    {
        return this.defaultPlan;
    }

    public void setDefaultPlan(EightSemesterPlan defaultPlan) {
        this.defaultPlan = defaultPlan;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Major ID: ").append(id).append("\n");
        sb.append("Major Name: ").append(majorName).append("\n");
        sb.append("Required Courses: ").append(requiredCourses).append("\n");
        sb.append("Default Plan: ").append(defaultPlan).append("\n");
        return sb.toString();
    }
}
