import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Student extends User{
    private Classification classification;
    private UUID id;
    private int completedCreditHours;
    private int remainingCreditHours;
    private Flag flag;
    private double overallGPA;
    private Major major;
    private String minor;
    private Boolean FEPRA;
    private Advisor advisor;
    private ArrayList<CompletedCourse> completedCourses;
    private EightSemesterPlan eightSemesterPlan;
    private ArrayList<Course> currentCourses;

    public Student(String username, String password, String firstname, String lastname, Classification classification, 
    int completedCreditHours, int remainingCreditHours, String flag, double overallGPA, Major major, String minor, 
    Boolean FEPRA, Advisor advisor, EightSemesterPlan eightSemesterPlan, ArrayList<Course> currentCourses) {
        super(username, password, firstname, lastname); 
                        this.classification = classification;
                        this.completedCreditHours = 0;
                        this.remainingCreditHours = 0;
                        this.flag = Flag.None; // Instantiate the Flag class using the appropriate constructor
                        this.overallGPA = 0.0;
                        this.id = UUID.randomUUID();
                        this.major = new Major(id, minor, currentCourses, eightSemesterPlan);
                        this.minor = "";
                        this.FEPRA = false;
                        this.completedCourses = new ArrayList<>();
                        this.eightSemesterPlan = new EightSemesterPlan(currentCourses);
                        this.currentCourses = new ArrayList<>();
    }

    // why is there two constructors?
    public Student(String username, String password, String firstname, String lastname, String classification2,
            long completedCreditHours2, long remainingCreditHours2, boolean flag2, double overallGPA2, UUID majorId,
            String minor2, boolean fERPA, UUID advisorId, EightSemesterPlan eightSemesterPlan2, UUID currentCoursesIDs,
            List<CompletedCourse> completedCourses2) {
                super(username, password, firstname, lastname);
    }

    /**
     * This method loops through the list of completed courses to calculate the number of completed cerdit hours
     * and sets the completed cerdit hours to the number calculated
     * @param courses the arrayList of completed courses
     */
    public void setCompletedHours(ArrayList<CompletedCourse> courses) {
       int completedCredits = 0;
        for (int i = 0;i < courses.size(); i++)
       {
        completedCredits = completedCredits + courses.get(i).getCreditHours();
       }
       this.completedCreditHours = completedCredits;
    }

    /**
     * This method calculates and sets the number of remaining cerdit hours needed to complete the student's degree
     * @param completedHours the number of hours they have completed
     */
    public void setRemainingHours(int completedHours) {
        this.remainingCreditHours = 120 - completedHours;
    }

    /**
     * This method sets the flag for to be added to the students account
     * @param flag the flag to be added
     */
    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    /**
     * This method calsulates and sets the overall GPA
     * @param completedCourses The list of completed course 
     */
    public void calculateOverallGPA(ArrayList<CompletedCourse> completedCourses) {
        double qualityPoints = 0;
        for ( int i = 0; i < completedCourses.size(); i++)
        {
            qualityPoints =  qualityPoints + completedCourses.get(i).getqualityPoints();
        }
        this.overallGPA = qualityPoints/this.completedCreditHours;
    }

    /**
     * This method adds a course to the list of completed courses once the student finishes a class
     * and is assigned a final grade for the course
     * @param course the course the student finished
     * @param grade the grade they received
     */
    public void addCompletedCourse(Course course, Grade grade) {
        completedCourses.add(new CompletedCourse(course, grade));
    }

    /**
     * This method calculates and returns the overall GPA of the student
     * @return the GPA
     */
    public double getOverallGPA() {
        double overallQualityPoints = 0;
        for ( int i = 0; i < completedCourses.size(); i++)
        {
            overallQualityPoints = overallQualityPoints + completedCourses.get(i).getqualityPoints();
        }
        return overallQualityPoints / completedCreditHours;
    }

    public void viewCompletedCourses(ArrayList<Course> completedCourses) {
        System.out.println(completedCourses);   
    }


    public void viewEightSemesterPlan(EightSemesterPlan eightSemesterPlan) {
        System.out.println(eightSemesterPlan);       
    }

    public void viewCurrentCourses(ArrayList<Course> currentCourses) {
        System.out.println(currentCourses);
    }

    public void viewAvailableCourses(ArrayList<Course> availableCourses) {
        System.out.println(availableCourses); 
    }

    public void chooseApplicationArea(ArrayList<Course> applicationArea) {
        System.out.println(applicationArea); 
    }


    public Course courseSearch(String department, String number) {
        return new Course(null, number, number, number, number, completedCreditHours, null, null , currentCourses);
    }

}
