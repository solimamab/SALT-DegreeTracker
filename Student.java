import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Student extends User{
    private Classification classification;
    private UUID id;
    private long completedCreditHours;
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
            long completedCreditHours2, long remainingCreditHours2, String flag2, double overallGPA2, UUID majorId,
            String minor2, boolean fERPA, UUID advisorId, EightSemesterPlan eightSemesterPlan2, UUID currentCoursesIDs,
            List<CompletedCourse> completedCourses2) {
                super(username, password, firstname, lastname);
    }

    /**
     * The getters for the attributes of the student class
     */
    public Classification getClassification()
    {
        return this.classification;
    }

    public UUID getUUID()
    {
        return this.id;
    }

    public long getCompletedCreditHours()
    {
        return this.completedCreditHours;
    }

    public int getRemainingCreditHours()
    {
        return this.remainingCreditHours;
    }

    public Flag getFlag()
    {
        return this.flag;
    }

    public double getOverallGPA()
    {
        return this.overallGPA;
    }

    public Major getMajor()
    {
        return this.major;
    }

    public String getMinor()
    {
        return this.minor;
    }

    public Boolean getFEPRA()
    {
        return this.FEPRA;
    }

    public Advisor getAdvisor()
    {
        return this.advisor;
    }

    public ArrayList<CompletedCourse> getCompletedCourses()
    {
        return this.completedCourses;
    }

    public EightSemesterPlan getEightSemesterPlan()
    {
        return this.eightSemesterPlan;
    }

    public ArrayList<Course> getCurrentCourses()
    {
        return this.currentCourses;
    }

    /**
     * A setter that uses the number of completed credit hours to determine the classification of the student 
     * based on the USC requirements
     */
    public void setClassifcation()
    {
        if (completedCreditHours < 30 )
            this.classification = Classification.Freshmen;
        else if (completedCreditHours >= 30 && completedCreditHours < 60)
            this.classification = Classification.Sophomore;
        else if (completedCreditHours >= 60 && completedCreditHours < 90)
            this.classification = Classification.Junior;
        else
            this.classification = Classification.Senior;
    }


    /**
     * This method loops through the list of completed courses to calculate the number of completed cerdit hours
     * and sets the completed cerdit hours to the number calculated
     * @param courses the arrayList of completed courses
     */
    public void setCompletedHours(ArrayList<CompletedCourse> courses) {
       long completedCredits = 0;
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
    public void setOverallGPA(ArrayList<CompletedCourse> completedCourses) {
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

    // need to implement logic here?
    public Course courseSearch(String department, String number) {
        return null;
    }

}
