import java.util.ArrayList;

/**
 *  This class holds all of the information for the EightSemesterPlan 
 * @author Team SALT
 */

public class EightSemesterPlan {
    private ArrayList<ArrayList<Course>> semesters;
    private CourseList courseList = CourseList.getInstance();
    private ArrayList<Course> applicationArea;
    private ArrayList<Course> electiveChoices;
    private double majorProgress;

    public EightSemesterPlan() {
        this.semesters = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            this.semesters.add(new ArrayList<>());
        }
        this.applicationArea = new ArrayList<>();
        this.electiveChoices = new ArrayList<>();
        this.majorProgress = 0.0;
    }
    // private ArrayList<Course> classesInPlan;
    // //private ArrayList<Course> majorRequirements; Should something like this be help to include
    // private ArrayList<Course> applicationArea;
    // private ArrayList<Course> electiveChoices;
    // private ArrayList<Course> semester1;
    // private ArrayList<Course> semester2;
    // private ArrayList<Course> semester3;
    // private ArrayList<Course> semester4;
    // private ArrayList<Course> semester5;
    // private ArrayList<Course> semester6;
    // private ArrayList<Course> semester7;
    // private ArrayList<Course> semester8;
    // private ArrayList<Course> currentSemester;
    // private double majorProgress;
    // private int NumberofClassesinPlan;

    // public EightSemesterPlan(ArrayList<Course> classesInPlan, ArrayList<Course> applicationArea,ArrayList<Course> electiveChoices, double majorProgress) {
    //     this.classesInPlan = classesInPlan;
    //     this.applicationArea = applicationArea;
    //     this.electiveChoices = electiveChoices;
    //     this.majorProgress = majorProgress;
    //     this.NumberofClassesinPlan = classesInPlan.size();
    // }

    // public EightSemesterPlan() {
    //     this.classesInPlan = new ArrayList<>();
    //     this.applicationArea = new ArrayList<Course>();
    //     this.electiveChoices = new ArrayList<>();
    //     this.majorProgress = 0.0;
    // }

    public void addCourseToSemester(int semester, Course course) {
        if (semester >= 1 && semester <= 8) {
            this.semesters.get(semester - 1).add(course);
        } else {
            System.err.println("Invalid semester number: " + semester);
        }
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

    // /*does this need to be broken down by semester
    // like semester 1: list classes to take 
    // semester two : and so one
    // */
    // public void viewPlan() {
    //     System.out.println("Classes in Plan:");
    //     for (Course course : classesInPlan) {
    //         System.out.println(course.toString());
    //     }
    //     System.out.println("Application Area Courses:");
    //     for (Course course : applicationArea) {
    //         System.out.println(course.toString());
    //     }
    //     System.out.println("Elective Choices:");
    //     for (Course course : electiveChoices) {
    //         System.out.println(course.toString());
    //     }
    // }

    // public void viewSemesterlayout()
    // {
    //     System.out.println("Semester One:\n" +
    //     semester1 + "Semester 2:\n" + semester2 +
    //     "Semester 3: \n " + semester3 + "Semester 4: \n"
    //     + semester4 + "Semester Five:\n" +
    //     semester5 + "Semester Six:\n" + semester6 +
    //     "Semester Seven: \n " + semester7 + "Semester Eigth: \n"
    //     + semester8);
    // }

    // public void setCurrentSemester(int semesterNum)
    // {
    //     switch(semesterNum)
    //     {
    //         case 1:
    //             currentSemester = semester1;
    //             System.out.println("current semester set to semester 1");
    //             break;
    //         case 2:
    //             currentSemester = semester2;
    //             System.out.println("current semester set to semester 2");
    //             break;
    //         case 3:
    //             currentSemester = semester3;
    //             System.out.println("current semester set to semester 3");
    //             break;
    //         case 4:
    //             currentSemester = semester4;
    //             System.out.println("current semester set to semester 4");
    //             break;
    //         case 5:
    //             currentSemester = semester5;
    //             System.out.println("current semester set to semester 5");
    //             break;
    //         case 6:
    //             currentSemester = semester6;
    //             System.out.println("current semester set to semester 6");
    //             break;
    //         case 7:
    //             currentSemester = semester7;
    //             System.out.println("Current semester set to semester 7");
    //         case 8:
    //             currentSemester = semester8;
    //             System.out.println("Current semester set to semester 8");
    //             break;
    //         default:
    //             System.out.println("There is not a semester " + semesterNum);
    //             break;
    //     }
    // }


    public ArrayList<ArrayList<Course>> getSemesters() {
        return semesters;
    }


    public double getMajorProgress() {
        return majorProgress;
    }

    // public ArrayList<Course> getClassesInPlan() {
    //     return classesInPlan;
    // }

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
            this.semesters.set(semester - 1, courses);
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


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Semester-wise Courses:\n");
        for (int i = 0; i < 8; i++) {
            stringBuilder.append("Semester ").append(i + 1).append(": ").append(semesters.get(i)).append("\n");
        }
        stringBuilder.append("Application Area Courses: ").append(applicationArea).append("\n");
        stringBuilder.append("Elective Choices: ").append(electiveChoices).append("\n");
        stringBuilder.append("Major Progress: ").append(majorProgress).append("\n");

        return stringBuilder.toString();
    }
}
