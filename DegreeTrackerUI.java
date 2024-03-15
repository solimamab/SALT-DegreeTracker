import java.util.Scanner;
import java.util.UUID;
/**
* 
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
        
        // code for choosing an application area and printing out the schedule
    }
    
    public void scenario2() {
        // Create an advisor account
        Advisor advisor = new Advisor(UUID.randomUUID(), "OOdden", "12345", "Obsert", "Odden", null);
        gradeSystemFACADE.createAdvisorAccount(advisor);
        System.out.println("New Advisor Account made for Obsert Odden");
        
        // Display advisor details
        String advisorDetails = gradeSystemFACADE.viewAdvisorDetails(advisor);
        System.out.println("Advisor Details:\n" + advisorDetails);
        
        // Look up a student by their ID
        UUID studentID = UUID.randomUUID(); // UPDATE THIS WHEN WE IMPORT STUDENT'S DATA IN JSON FILE
        Student student = gradeSystemFACADE.findStudent(studentID);
        
        if (student != null) {
            // Add the student to the advisor's list of students
            // advisor.addStudent(student); <--- WILL IMPLEMENT THIS TMRW
            
            // View the student's eight semester plan
            EightSemesterPlan studentEightSemesterPlan = gradeSystemFACADE.viewStudentsEightSemesterPlan(student);
            System.out.println("Student's Eight Semester Plan:\n" + studentEightSemesterPlan);
            
            // Add a note for the student (pending implementation)
            // advisor.addNoteForStudent(student, "Note content");
        } else {
            System.out.println("Student not found.");
        }
    }
    
    public static void main(String args[]) {
        DegreeTrackerUI UI = new DegreeTrackerUI();
        UI.run();
    }
}
