import java.util.ArrayList;

class ElectiveChoices {
    private ArrayList<Course> electiveChoices;
    private int numCredits;

    public ElectiveChoices(ArrayList<Course> electiveChoices, int numCredits) {
        this.electiveChoices = electiveChoices;
        this.numCredits = numCredits;
    }

    public boolean ElectiveClusterCompleted(ArrayList<Course> electives, int requiredCredits) {
        int totalCredits = 0;
        for (Course course : electives) {
            totalCredits += course.getCredits(); //temporary implimenation
        }
        
        return totalCredits >= requiredCredits;
    }

}