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
