import java.util.ArrayList;
import java.util.UUID;

class EightSemesterPlan {
    private ArrayList<Course> classesInPlan;
    private ArrayList<Course> applicationArea;
    private ArrayList<Course> electiveChoices;
    private double majorProgress;

    public EightSemesterPlan(ArrayList<Course> classesInPlan, ArrayList<Course> applicationArea, ArrayList<Course> electiveChoices, double majorProgress) {
        this.classesInPlan = classesInPlan;
        this.applicationArea = applicationArea;
        this.electiveChoices = electiveChoices;
        this.majorProgress = majorProgress;
    }

    public EightSemesterPlan() {
        this.classesInPlan = new ArrayList<>();
        this.applicationArea = new ArrayList<>();
        this.electiveChoices = new ArrayList<>();
        this.majorProgress = 0.0;
    }

    public void addClassToPlan(Course course) {
        classesInPlan.add(course);
    }

    public void removeClassFromPlan(Course course) {
        classesInPlan.remove(course);
    }

    public void addApplicationAreaCourse(Course course) {
        applicationArea.add(course);
    }

    public void removeApplicationAreaCourse(Course course) {
        applicationArea.remove(course);
    }

    public void addElectiveChoice(Course course) {
        electiveChoices.add(course);
    }

    public void removeElectiveChoice(Course course) {
        electiveChoices.remove(course);
    }

    public void viewPlan() {
        System.out.println("Classes in Plan:");
        for (Course course : classesInPlan) {
            System.out.println(course);
        }
        System.out.println("Application Area Courses:");
        for (Course course : applicationArea) {
            System.out.println(course);
        }
        System.out.println("Elective Choices:");
        for (Course course : electiveChoices) {
            System.out.println(course);
        }
    }

    public double getMajorProgress() {
        return majorProgress;
    }

    public ArrayList<Course> getClassesInPlan() {
        return classesInPlan;
    }

    public ArrayList<Course> getApplicationArea() {
        return applicationArea;
    }

    public ArrayList<Course> getElectiveChoices() {
        return electiveChoices;
    }

    public void setMajorProgress(double majorProgress) {
        this.majorProgress = majorProgress;
    }
}
