import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;



public class Student extends User{
    private Classification classification;
    private UUID id;
    private long completedCreditHours;
    private long remainingCreditHours;
    private Flag flag;
    private double overallGPA;
    private Major major;
    private String minor;
    private Boolean FERPA;
    private Advisor advisor;
    private ArrayList<CompletedCourse> completedCourses;
    private EightSemesterPlan eightSemesterPlan;
    private ArrayList<Course> currentCourses;
    private HashMap<UUID, Course> coursesMap;
    private String AdvisorNote;
    
    /**
    * Constructor for Student
    * @param username
    * @param password
    * @param firstname
    * @param lastname
    * @param classification
    * @param completedCreditHours
    * @param remainingCreditHours
    * @param flag
    * @param overallGPA
    * @param major
    * @param minor
    * @param FEPRA
    * @param advisor
    * @param eightSemesterPlan
    * @param currentCourses
    * @param coursesMap
    */
    public Student(UUID id, String username, String password, String firstname, String lastname, 
    Classification classification, long completedCreditHours, long remainingCreditHours,
    String flag, double overallGPA, UUID majorId, String minor, 
    boolean FERPA, UUID advisorId, EightSemesterPlan eightSemesterPlan,
    ArrayList<Course> currentCourses, ArrayList<CompletedCourse> completedCourses, HashMap<UUID, Course> coursesMap) {
        super(username, password, firstname, lastname);
        this.id = id;
        this.classification = classification;
        this.completedCreditHours = completedCreditHours;
        this.remainingCreditHours = remainingCreditHours;
        this.flag = Flag.valueOf(flag);
        this.overallGPA = overallGPA;
        this.major = MajorList.getInstance().findMajor(majorId);
        this.minor = minor;
        this.FERPA = FERPA;
        this.advisor = UserList.getInstance().findAdvisor(advisorId);
        this.eightSemesterPlan = eightSemesterPlan;
        this.currentCourses = new ArrayList<>();
        this.completedCourses = completedCourses;
        this.AdvisorNote = " ";
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
    
    public long getRemainingCreditHours()
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
        return this.FERPA;
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

    public String getNote()
    {
        return this.AdvisorNote;
    }
    
    /**
    * A setter that uses the number of completed credit hours to determine the classification of the student 
    * based on the USC requirements
    */
    public void setClassifcation()
    {
        if (completedCreditHours < 30 )
        this.classification = Classification.FRESHMAN;
        else if (completedCreditHours >= 30 && completedCreditHours < 60)
        this.classification = Classification.SOPHOMORE;
        else if (completedCreditHours >= 60 && completedCreditHours < 90)
        this.classification = Classification.JUNIOR;
        else
        this.classification = Classification.SENIOR;
    }
    
    public Major setMajor(UUID majorUuid)
    {
        this.major = MajorList.getInstance().findMajor(majorUuid);
        return this.major;
    }

    public Advisor setAdvisor(UUID advisorUuid)
    {
        this.advisor = UserList.getInstance().findAdvisor(advisorUuid);
        return this.advisor;
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
    
    public void setAdvisorNote(String note)
    {
        this.AdvisorNote = note;
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
        if (completedCourses.isEmpty()) {
            System.out.println("No completed courses.");
            return;
        }
        System.out.println("Completed Courses:");
        for (Course course : completedCourses) {
            System.out.println(course.toString());
        }    }
    
    
    public void viewEightSemesterPlan(EightSemesterPlan eightSemesterPlan) {
        if (eightSemesterPlan == null) {
            System.out.println("Eight Semester Plan is not available.");
            return;
        }
        System.out.println("Eight Semester Plan:");
        System.out.println(eightSemesterPlan);
    }
    
    public void viewCurrentCourses(ArrayList<Course> currentCourses) {
        if (currentCourses.isEmpty()) {
            System.out.println("No current courses.");
            return;
        }
        System.out.println("Current Courses:");
        for (Course course : currentCourses) {
            System.out.println(course);
        }
    }
    
    public void viewAvailableCourses(ArrayList<Course> availableCourses) {
        if (availableCourses.isEmpty()) {
            System.out.println("No available courses.");
            return;
        }
        System.out.println("Available Courses:");
        for (Course course : availableCourses) {
            System.out.println(course);
        }
    }
    
    public void chooseApplicationArea(ArrayList<Course> applicationArea) {
        System.out.println(applicationArea); 
    }
    
    // need to implement logic here?
    public Course courseSearch(String department, String number) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(id).append("\n");
        sb.append("Username: ").append(getUsername()).append("\n");
        sb.append("Password: ").append(getPassword()).append("\n");
        sb.append("First Name: ").append(getFirstName()).append("\n");
        sb.append("Last Name: ").append(getLastName()).append("\n");
        sb.append("Classification: ").append(classification).append("\n");
        sb.append("Completed Credit Hours: ").append(completedCreditHours).append("\n");
        sb.append("Remaining Credit Hours: ").append(remainingCreditHours).append("\n");
        sb.append("Flag: ").append(flag).append("\n");
        sb.append("Overall GPA: ").append(overallGPA).append("\n");
        sb.append("Major ID: ").append(getMajor()).append("\n");
        sb.append("Minor: ").append(minor).append("\n");
        sb.append("FERPA: ").append(FERPA).append("\n");
        sb.append("Advisor ID: ").append(getAdvisor()).append("\n");
        sb.append("Advisor Note:").append(AdvisorNote).append("\n");
        
        return sb.toString();
    }
    
}
