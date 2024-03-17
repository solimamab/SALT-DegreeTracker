import java.util.ArrayList;

/**
 *  This class holds all of the information for the EightSemesterPlan 
 * @author Team SALT
 */

public class EightSemesterPlan {
    private ArrayList<ArrayList<Course>> semesters;
    private ArrayList<Course> applicationArea;
    private ArrayList<Course> electiveChoices;
    private double majorProgress;

    /**
     * 
     */
    public EightSemesterPlan() {
        this.semesters = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            this.semesters.add(new ArrayList<>());
        }
        this.applicationArea = new ArrayList<>();
        this.electiveChoices = new ArrayList<>();
        this.majorProgress = 0.0;
    }

    /**
     * 
     * @param semester
     * @param course
     */
    public void addCourseToSemester(int semester, Course course) {
        if (semester >= 1 && semester <= 8) {
            this.semesters.get(semester - 1).add(course);
        } else {
            System.err.println("Invalid semester number: " + semester);
        }
    }

    /**
     * 
     * @return
     */
    public ArrayList<Course> getAllCoursesInPlan() {
        ArrayList<Course> allCourses = new ArrayList<>();

        // Add all semester courses
        for (ArrayList<Course> semesterCourses : semesters) {
            allCourses.addAll(semesterCourses);
        }

        // Add application area courses
        allCourses.addAll(applicationArea);

        // Add elective choices
        allCourses.addAll(electiveChoices);

        return allCourses;
    }

    // public void removeClassFromPlan(Course course) {
    //     classesInPlan.remove(course);
    // }

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

    public ArrayList<ArrayList<Course>> getSemesters() {
        return semesters;
    }

    public double getMajorProgress() {
        return majorProgress;
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

    public void setSemesterCourses(int semester, ArrayList<Course> courses) {
        if (semester >= 1 && semester <= 8) {
            this.semesters.set(semester, courses);
        } else {
            System.err.println("Invalid semester number: " + semester);
        }
    }

    public void setApplicationArea(ArrayList<Course> courses) {
        this.applicationArea = courses;
    }

    public void setElectiveChoices(ArrayList<Course> courses) {
        this.electiveChoices = courses;
    }

    public void addSemesterCourses(int semester, ArrayList<Course> courses) {
        if (semester >= 1 && semester <= 8) {
            this.semesters.get(semester - 1).addAll(courses);
        } else {
            System.err.println("Invalid semester number: " + semester);
        }
    }

    public void setApplicationAreaCourses(ArrayList<Course> courses) {
        this.applicationArea = courses;
    }

    public void setElectiveCourses(ArrayList<Course> courses) {
        this.electiveChoices = courses;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Semester-wise Courses:\n");
        for (int i = 0; i < 8; i++) {
            stringBuilder.append("Semester ").append(i + 1).append(": ").append(semesters.get(i)).append("\n");
        }
        stringBuilder.append("Application Area Courses: ").append(applicationArea).append("\n");
        stringBuilder.append("Elective Choices: ").append(electiveChoices).append("\n");
        //stringBuilder.append("Major Progress: ").append(majorProgress).append("\n");

        return stringBuilder.toString();
    }
}
