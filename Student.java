import java.util.ArrayList;
import java.util.UUID;
import java.util.ArrayList;
import java.util.UUID;


public class Student extends User{
    private Classification classification;
    private UUID id;
    private int completedCreditHours;
    private int remainingCreditHours;
    private String flag;
    private double overallGPA;
    private Major major;
    private String minor;
    private Boolean FEPRA;
    private Advisor advisor;
    private ArrayList<CompletedCourse> completedCourses;
    private EightSemesterPlan eightSemesterPlan;
    private ArrayList<Course> currentCourses;

    public Student(String username, String password, String firstname, String lastname, Classification classification, int completedCreditHours, int remainingCreditHours, String flag, double overallGPA, Major major, String minor, Boolean FEPRA, Advisor advisor, EightSemesterPlan eightSemesterPlan, ArrayList<Course> currentCourses) {
        super(username, password, firstname, lastname); 
                        this.classification = classification;
                        this.completedCreditHours = 0;
                        this.remainingCreditHours = 0;
                        this.flag = "None"; // Instantiate the Flag class using the appropriate constructor
                        this.overallGPA = 0.0;
                        this.id = UUID.randomUUID();
                        this.major = new Major(id, minor, currentCourses, eightSemesterPlan);
                        this.minor = "";
                        this.FEPRA = false;
                        this.completedCourses = new ArrayList<>();
                        this.eightSemesterPlan = new EightSemesterPlan(currentCourses);
                        this.currentCourses = new ArrayList<>();
    }

    public void setCompletedHours(ArrayList<CompletedCourse> courses) {
        int coursesTotal = 1; 
        this.completedCreditHours = coursesTotal;
    }

    public void setRemainingHours(int completedHours) {
        this.remainingCreditHours = completedHours;
    }

    public void setFlag(Flag flag) {
        this.flag = "flag";
    }

    public void viewAvailableCourses(ArrayList<Course> availableCourses) {
        System.out.println(availableCourses); 
    }

    public void chooseApplicationArea(ArrayList<Course> applicationArea) {
        System.out.println(applicationArea); 
    }

    public void calculateOverallGPA(ArrayList<Course> completedCourses) {
        this.overallGPA = 4.0;
    }

    public void viewCompletedCourses(ArrayList<Course> completedCourses) {
        System.out.println(completedCourses);   
    }

    public void addCompletedCourse(Course course) {
        System.out.println("Course added: " + course);
    }

    public void viewEightSemesterPlan(EightSemesterPlan eightSemesterPlan) {
        System.out.println(eightSemesterPlan);       
    }

    public void viewCurrentCourses(ArrayList<Course> currentCourses) {
        System.out.println(currentCourses);
    }

    public double getOverallGPA() {
        return this.overallGPA;
    }

    public Course courseSearch(String department, String number) {
        return new Course(null, number, number, number, number, completedCreditHours, null, currentCourses, currentCourses);
    }

}
