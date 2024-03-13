import java.util.ArrayList;

public class ElectiveChoices {
    private ArrayList<Course> electiveChoices;
    private int numCredits;

    public ElectiveChoices(ArrayList<Course> electiveChoices, int numCredits) {
        this.electiveChoices = electiveChoices;
        this.numCredits = numCredits;
    }

    public boolean ElectiveClusterCompleted(int requiredCredits,int electiveCreditCompleted) {
        if( requiredCredits > electiveCreditCompleted )
            return false;
        else
            return true;
    }

    public void listElectiveClustertoChoseFrom(ArrayList<Course> electives, int requiredCredits)
    {
        
    }
    
}