import java.util.UUID;
/**
* The UI for the scenerios provided 
* @author Team SALT
*/
public class DegreeTrackerUI
{
    private GradeSystemFACADE gradeSystemFACADE;
    
    public DegreeTrackerUI() {
        gradeSystemFACADE = GradeSystemFACADE.getFacadeInstance();
        
    }
    
    public void run() {
        scenerio1();
        scenario2();
        //testingCourses();
    }
    
    public void scenerio1() {
        // Attempt to login as the student
        if (!gradeSystemFACADE.login("BWEST", "12345")) {
            System.out.println("Sorry, we couldn't log in.");
            return;
        }
        
        // Display login success message
        System.out.println("Brax West is now logged in.");
        
        // Find the logged-in student
        Student loggedInStudent = gradeSystemFACADE.findStudent("BWEST");
        
        // Display student details
        String studentDetails = gradeSystemFACADE.viewStudentDetails(loggedInStudent);
        System.out.println("Student Details:\n" + studentDetails);
        
        // View the student's eight semester plan
        EightSemesterPlan eightSemesterPlan = gradeSystemFACADE.viewEightSemesterPlan(loggedInStudent.getEightSemesterPlan());
        System.out.println("Eight Semester Plan:\n" + eightSemesterPlan);
        
        // code for looking at elective requirements and picking a class to staify


        // code for choosing an application area 

        // code for printing schedule to a text file 

        
    }
    
    public void scenario2() {
        // Create an advisor account
        Advisor advisor = new Advisor("OOdden", "12345", "Obsert", "Odden");
        gradeSystemFACADE.createAdvisorAccount(advisor);
        System.out.println("New Advisor Account made for Obsert Odden");
        
        // Display advisor details
        String advisorDetails = gradeSystemFACADE.viewAdvisorDetails(advisor);
        System.out.println("Advisor Details:\n" + advisorDetails);
        
        // Look up a student by their ID
        // UUID studentID = gradeSystemFACADE.findStudent("HTawnie"); // UPDATE THIS WHEN WE IMPORT STUDENT'S DATA IN JSON FILE
        Student student = gradeSystemFACADE.findStudent("HTawnie");
        
        if (student != null) {
            // Add the student to the advisor's list of students
            // advisor.addStudent(student); <--- WILL IMPLEMENT THIS TMRW
            
            // View the student's eight semester plan
            EightSemesterPlan studentEightSemesterPlan = gradeSystemFACADE.viewStudentsEightSemesterPlan(student);
            System.out.println("Student's Eight Semester Plan:\n" + studentEightSemesterPlan);
            
            // Add a note for the student 
            advisor.setStudentNote(student, "advise to take the underwater basketweaving class");
        } else {
            System.out.println("Student not found.");
        }
    }

    // Method for testing courses
    public void testingCourses() {
        Course course = gradeSystemFACADE.findCourse("CSCE", "240");
        System.out.println(course.toString());
    }
    
    public static void main(String args[]) {
        DegreeTrackerUI UI = new DegreeTrackerUI();
        UI.run();
    }
}
