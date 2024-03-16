import java.util.ArrayList;

/**
 *  This class holds all of the information for the EightSemesterPlan 
 * @author Team SALT
 */

public class EightSemesterPlan {
    private ArrayList<Course> classesInPlan;
    //private ArrayList<Course> majorRequirements; Should something like this be help to include
    private ArrayList<Course> applicationArea;
    private ArrayList<Course> electiveChoices;
    private ArrayList<Course> semester1;
    private ArrayList<Course> semester2;
    private ArrayList<Course> semester3;
    private ArrayList<Course> semester4;
    private ArrayList<Course> semester5;
    private ArrayList<Course> semester6;
    private ArrayList<Course> semester7;
    private ArrayList<Course> semester8;
    private double majorProgress;
    private int NumberofClassesinPlan;

    public EightSemesterPlan(ArrayList<Course> classesInPlan, ArrayList<Course> applicationArea, ArrayList<Course> electiveChoices, double majorProgress) {
        this.classesInPlan = classesInPlan;
        this.applicationArea = applicationArea;
        this.electiveChoices = electiveChoices;
        this.majorProgress = majorProgress;
        this.NumberofClassesinPlan = classesInPlan.size();
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

    /*does this need to be broken down by semester
    like semester 1: list classes to take 
    semester two : and so one
    */
    public void viewPlan() {
        System.out.println("Classes in Plan:");
        for (Course course : classesInPlan) {
            System.out.println(course.toString());
        }
        System.out.println("Application Area Courses:");
        for (Course course : applicationArea) {
            System.out.println(course.toString());
        }
        System.out.println("Elective Choices:");
        for (Course course : electiveChoices) {
            System.out.println(course.toString());
        }
    }

    public void viewSemesterlayout()
    {
        System.out.println("Semester One:\n" +
        semester1 + "Semester 2:\n" + semester2 +
        "Semester 3: \n " + semester3 + "Semester 4: \n"
        + semester4 + "Semester Five:\n" +
        semester5 + "Semester Six:\n" + semester6 +
        "Semester Seven: \n " + semester7 + "Semester Eigth: \n"
        + semester8);
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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nClasses in Plan:\n");
        if (!classesInPlan.isEmpty()) {
            for (Course course : classesInPlan) {
                stringBuilder.append(course.toString()).append("\n");
            }
        }
        stringBuilder.append("Application Area:\n");
        if (!applicationArea.isEmpty()) {
            for (Course course : applicationArea) {
                stringBuilder.append(course.toString()).append("\n");
            }
        }
        stringBuilder.append("Elective Choices:\n");
        if (!electiveChoices.isEmpty()) {
            for (Course course : electiveChoices) {
                stringBuilder.append(course.toString()).append("\n");
            }
        }
        stringBuilder.append("Major Progress: ").append(majorProgress).append("\n");
        return stringBuilder.toString();
    }
}
