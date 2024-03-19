import java.util.Scanner;
import java.util.UUID;

/**
* The UI for the scenerios provided 
* @author Team SALT
*/
public class DegreeTrackerUI
{
    private static GradeSystemFACADE gradeSystemFACADE;
    private static Scanner scanner = new Scanner(System.in);

    public DegreeTrackerUI(GradeSystemFACADE gradeSystemFACADE) {
        this.gradeSystemFACADE = gradeSystemFACADE;
        
    }
    
    public void run() {
        scenerio1();
        //scenario2();
        //testingCourses();
    }
    
    public static void scenerio1() {
        while (true) {
            System.out.println("Please choose an option:\n1. Login\n2. Create Account\n3. Exit");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    login();
                    break;
                case "2":
                    // Leave this for account creation implementation
                    break;
                case "3":
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        } 
    }
    
    public void scenario2() {
        // Create an advisor account
        Advisor advisor = new Advisor(UUID.randomUUID(),"OOdden","12345","Obsert","Odden",null);
        gradeSystemFACADE.createAdvisorAccount(advisor);
        System.out.println("New Advisor Account made for Obsert Odden");
        
        // Display advisor details
        String advisorDetails = gradeSystemFACADE.viewAdvisorDetails(advisor);
        System.out.println("Before Adding student\n Advisor Details:\n" + advisorDetails);
        
        // Look up a student by username
        Student student = gradeSystemFACADE.findStudent("HTawnie");
        
        if (student != null) {
            // // Add the student to the advisor's list of students
            advisor.addAdvisingStudent(student.getUUID());
            // Display advisor details
            String Details = gradeSystemFACADE.viewAdvisorDetails(advisor);
            System.out.println("After Adding student\n Advisor Details:\n" + Details);
            
            // View the student's details
            String studentDetails = gradeSystemFACADE.viewStudentDetails(student);
            System.out.println("Student's Details:\n" + studentDetails);
            
            // Add a note for the student 
            advisor.setStudentNote(student, "advise to declare STATS as student's application area");
            System.out.println("Added note to students account to take this ultra spefic class that will not help them at all");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method for testing courses
    public void testingCourses() {
        Course course = gradeSystemFACADE.findCourse("SPCH", "140");
        System.out.println(course.toString());
    }

    private static void login() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();

        if (!gradeSystemFACADE.login(username, password)) {
            System.out.println("Sorry, we couldn't log in.");
            return;
        }

        System.out.println(username + " is now logged in.");
        Student loggedInStudent = gradeSystemFACADE.findStudent(username);
        homeOptions(loggedInStudent);
    }

    private static void homeOptions(Student loggedInStudent) {
        while (true) {
            System.out.println("\nHome Options:\n1. Display Student Information\n2. View Eight Semester Plan\n3. Print Eight Semester Plan\n4. Logout");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    displayStudentDetails(loggedInStudent);
                    break;
                case "2":
                    viewEightSemesterPlan(loggedInStudent);
                    break;
                case "3":
                    printEightSemesterPlan(loggedInStudent);
                    break;
                case "4":
                    scenerio1();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void displayStudentDetails(Student student) {
        String studentDetails = gradeSystemFACADE.viewStudentDetails(student);
        System.out.println("Student Details:\n" + studentDetails);
    }

    private static void viewEightSemesterPlan(Student student) {
        EightSemesterPlan eightSemesterPlan = gradeSystemFACADE.viewEightSemesterPlan(student.getEightSemesterPlan());
        System.out.println("Eight Semester Plan:\n" + eightSemesterPlan);
    }

    private static void printEightSemesterPlan(Student student) {
        gradeSystemFACADE.writePlantoTextFile(student);
        System.out.println("Eight Semester Plan printed to text file.");
    }

    
    public static void main(String args[]) {
        // Instantiate UserList, CourseList, and MajorList
        UserList userList = UserList.getInstance();
        CourseList courseList = CourseList.getInstance();
        MajorList majorList = MajorList.getInstance();

        // Create GradeSystemFACADE instance using constructor injection
        GradeSystemFACADE gradeSystemFACADE = GradeSystemFACADE.getFacadeInstance(userList, courseList, majorList);

        // Pass GradeSystemFACADE instance to DegreeTrackerUI constructor
        DegreeTrackerUI UI = new DegreeTrackerUI(gradeSystemFACADE);
        UI.run();
    }
}
