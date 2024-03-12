import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class CompletedCourse extends Course {
    private String letterGrade;
    private double qualityPoints;
    
    public CompletedCourse(UUID id, String name, String department, long number, String description, long creditHours,
    Availablity availability, HashMap<UUID, String> prerequisite, ArrayList<UUID> corequisite,
    String letterGrade, double qualityPoints) {
        super(id, name, department, number, description, creditHours, availability, prerequisite, corequisite);
        this.letterGrade = letterGrade;
        this.qualityPoints = qualityPoints;
    }
}
