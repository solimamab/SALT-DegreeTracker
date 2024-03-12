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
    
    /**
    * Setter for quality points based on the USC GPA scale
    */
    public void setQualityPoints() {
        double points = 0;
        if (letterGrade.equals(Grade.A.toString()))
            points = 4;
        else if (letterGrade.equals(Grade.B_PLUS.toString()))
            points = 3.5;
        else if (letterGrade.equals(Grade.B.toString()))
            points = 3;
        else if (letterGrade.equals(Grade.C_PLUS.toString()))
            points = 2.5;
        else if (letterGrade.equals(Grade.C.toString()))
            points = 2;
        else if (letterGrade.equals(Grade.D_PLUS.toString()))
            points = 1.5;
        else if (letterGrade.equals(Grade.D.toString()))
            points = 1;
        else
            points = 0;
        
        this.qualityPoints = points * super.getCreditHours();
    }
}
