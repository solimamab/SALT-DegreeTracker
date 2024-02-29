import java.util.ArrayList;
import java.util.UUID;

class EightSemesterPlan {
    private ArrayList<Course> classesInPlan;
    private ApplicationArea applicationArea;
    private ArrayList<ElectiveChoices> electiveChoice;
    private double majorProgress;

    public EightSemesterPlan(ArrayList<Course> plan) {
        this.classesInPlan = plan;
        this.applicationArea = new ApplicationArea(plan); 
        this.electiveChoice = new ArrayList<>();
        this.majorProgress = 0.0;
    }

    public EightSemesterPlan(ArrayList<UUID> classesInPlanIDs, ArrayList<UUID> applicationAreaIDs,ArrayList<UUID> electiveChoiceIDs) {
        // stuff goes here
    }

    public void addClassToPlan(Course course, EightSemesterPlan plan) {
        plan.classesInPlan.add(course);
    }

    public void removeClassToPlan(Course course, EightSemesterPlan plan) {
        plan.classesInPlan.remove(course);
    }

    public void viewPlan(EightSemesterPlan plan) {
        for (Course course : plan.classesInPlan) {
            System.out.println(course);
        }
    }

    public double getMajorProgress() {
        return this.majorProgress;
    }

    public void viewElectiveChoices(ArrayList<ElectiveChoices> choices) {
        for (ElectiveChoices choice : choices) {
            System.out.println(choice); 
        }
    }

}
