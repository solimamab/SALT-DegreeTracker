import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
* This is the student class that holds all the relevant information for each student
* @author Team SALT
*/
public class Student extends User{
    private Classification classification;
    private UUID id;
    private long completedCreditHours;
    private long remainingCreditHours;
    private Flag flag;
    private double overallGPA;
    private UUID major;
    private String minor;
    private Boolean FERPA;
    private UUID advisor;
    private ArrayList<CompletedCourse> completedCourses;
    private EightSemesterPlan eightSemesterPlan;
    private ArrayList<Course> currentCourses;
    private HashMap<UUID, Course> coursesMap; // this is here but not used anywhere??
    private String AdvisorNote;
    private double majorProgress;
    
    
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
    Flag flag, double overallGPA, UUID majorId, String minor, 
    boolean FERPA, UUID advisorId, EightSemesterPlan eightSemesterPlan,
    ArrayList<Course> currentCourses, ArrayList<CompletedCourse> completedCourses, double majorProgress, HashMap<UUID, Course> coursesMap) {
        super(username, password, firstname, lastname);
        this.id = id;
        this.classification = classification;
        this.completedCreditHours = completedCreditHours;
        this.remainingCreditHours = remainingCreditHours;
        this.flag = flag;
        this.overallGPA = overallGPA;
        this.major = majorId;
        this.minor = minor;
        this.FERPA = FERPA;
        this.advisor = advisorId;
        this.eightSemesterPlan = eightSemesterPlan;
        this.currentCourses = currentCourses;
        this.completedCourses = completedCourses;
        this.majorProgress = majorProgress;
        this.coursesMap = coursesMap;
        this.AdvisorNote = " ";
    }
    
    /**
     * basic constructor
     * @param Studentid
     * @param username
     * @param password
     * @param firstName
     * @param lastName
     */
    public Student(UUID Studentid, String username,String password,String firstName, String lastName)
    {
        super(username, password, firstName, lastName);
        this.id = Studentid;
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

    public double getMajorProgress(){
        return this.majorProgress;
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
        Major major = MajorList.getInstance().findMajor(this.major);
        return major;
    }

    public UUID getMajorID()
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
        Advisor advisor = UserList.getInstance().findAdvisor(this.advisor);
        return advisor;
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
    
    public void setCompletedHours(long completedCreditHours)
    {
        this.completedCreditHours = completedCreditHours;
    }
    /**
    * A setter that uses the number of completed credit hours to determine the classification of the student 
    * based on the USC requirements
    */
    public void setClassifcation(int completedCreditHours)
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
    
    public void setMajor(UUID majorUuid)
    {
        this.major = majorUuid;
    }
    
    public void setAdvisor(UUID advisorUuid)
    {
        this.advisor = advisorUuid;
    }
    /**
    * This method loops through the list of completed courses to calculate the number of completed cerdit hours
    * and sets the completed cerdit hours to the number calculated
    * @param courses the arrayList of completed courses
    */
    public long setCompletedHours(ArrayList<CompletedCourse> courses) {
        long completedCredits = 0;
        for (int i = 0;i < courses.size(); i++)
        {
            completedCredits = completedCredits + courses.get(i).getCreditHours();
        }
        return completedCredits;
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
    public double setOverallGPA(ArrayList<CompletedCourse> completedCourses) {
        double qualityPoints = 0;
        for ( int i = 0; i < completedCourses.size(); i++)
        {
            qualityPoints =  qualityPoints + completedCourses.get(i).getqualityPoints();
        }
        return qualityPoints/this.completedCreditHours;
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
        
        /** 
         * may or may not use this method 
        public void chooseApplicationArea(ArrayList<Course> applicationArea) {
            System.out.println(applicationArea); 
        }
        */
        
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
            sb.append("Major Progress: ").append(majorProgress).append("\n");
            sb.append("Advisor Note:").append(AdvisorNote).append("\n");
            
            // Including the Eight Semester Plan
            sb.append("Eight Semester Plan:\n");
            if (this.eightSemesterPlan != null) {
                sb.append(this.eightSemesterPlan.toString());
            } else {
                sb.append("No Eight Semester Plan available.\n");
            }
            
            // Including Current Courses
            sb.append("Current Courses:\n");
            if (!currentCourses.isEmpty()) {
                for (Course course : currentCourses) {
                    sb.append(course).append("\n");
                }
            } else {
                sb.append("No current courses.\n");
            }
            
            // Including Completed Courses with Letter Grades
            sb.append("Completed Courses:\n");
            if (!completedCourses.isEmpty()) {
                for (CompletedCourse course : completedCourses) {
                    sb.append(course).append(" (Grade: ").append(course.getLetterGrade()).append(")\n");
                }
            } else {
                sb.append("No completed courses.\n");
            }
            
            return sb.toString();
        }

        //This method writes the eight semester plan of a student to a text file
        public void writePlantoText(Student student)
        {
            try 
            {
                File myFile = new File("SemesterPlan.txt");
                if (myFile.createNewFile()) 
                {
                    FileWriter myWriter = new FileWriter("SemesterPlan.txt");
                    myWriter.write(student.getEightSemesterPlan().toString());
                    myWriter.close();
                } 
                else 
                {
                    System.out.println("File already exists.");
                }
            } 
            catch (IOException e) 
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        
    }
    