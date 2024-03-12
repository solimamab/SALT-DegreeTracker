import java.util.ArrayList;

public class ElectiveChoices {
    private ArrayList<Course> electiveChoices;
    private int numCredits;

    public ElectiveChoices(ArrayList<Course> electiveChoices, int numCredits) {
        this.electiveChoices = electiveChoices;
        this.numCredits = numCredits;
    }

    public boolean ElectiveClusterCompleted(ArrayList<Course> electives, int requiredCredits) {
        return true;
    }

    
}