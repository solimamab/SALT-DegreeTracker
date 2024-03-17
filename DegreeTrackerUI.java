import java.util.UUID;

/**
* The UI for the scenerios provided 
* @author Team SALT
*/
public class DegreeTrackerUI
{
    private GradeSystemFACADE gradeSystemFACADE;
    
    public DegreeTrackerUI(GradeSystemFACADE gradeSystemFACADE) {
        this.gradeSystemFACADE = gradeSystemFACADE;
        
    }
    
    public void run() {
        //scenerio1();
        scenario2();
        //testingCourses();
    }
    
    public void scenerio1() {
        // Attempt to login as the student
        if (!gradeSystemFACADE.login("BWest", "12345")) {
            System.out.println("Sorry, we couldn't log in.");
            return;
        }
        
        // Display login success message
        System.out.println("Brax West is now logged in.");
        
        // Find the logged-in student
        Student loggedInStudent = gradeSystemFACADE.findStudent("BWest");
        
        // Display student details
        String studentDetails = gradeSystemFACADE.viewStudentDetails(loggedInStudent);
        System.out.println("Student Details:\n" + studentDetails);
        
        // View the student's eight semester plan
        EightSemesterPlan eightSemesterPlan = gradeSystemFACADE.viewEightSemesterPlan(loggedInStudent.getEightSemesterPlan());
        System.out.println("Eight Semester Plan:\n" + eightSemesterPlan);
        
        // code for looking at elective requirements and picking a class to staify


        // code for choosing an application area 

        // code for printing schedule to a text file 
        gradeSystemFACADE.writePlantoTextFile(loggedInStudent);

        
    }
    
    public void scenario2() {
        // Create an advisor account
        Advisor advisor = new Advisor(UUID.randomUUID(),"OOdden","12345","Obsert","Odden",null);
        gradeSystemFACADE.createAdvisorAccount(advisor);
        System.out.println("New Advisor Account made for Obsert Odden");
        
        // Display advisor details
        String advisorDetails = gradeSystemFACADE.viewAdvisorDetails(advisor);
        System.out.println("Before Adding student\n Advisor Details:\n" + advisorDetails);
        
        // Look up a student by their ID
        // UUID studentID = gradeSystemFACADE.findStudent("HTawnie"); // UPDATE THIS WHEN WE IMPORT STUDENT'S DATA IN JSON FILE
        Student student = gradeSystemFACADE.findStudent("HTawnie");
        
        if (student != null) {
            // // Add the student to the advisor's list of students
            advisor.addAdvisingStudent(student.getUUID());/// <--- WILL IMPLEMENT THIS TMRW

            // Display advisor details
            String Details = gradeSystemFACADE.viewAdvisorDetails(advisor);
            System.out.println("After Adding student\n Advisor Details:\n" + Details);
            
            // View the student's eight semester plan
            EightSemesterPlan studentEightSemesterPlan = gradeSystemFACADE.viewStudentsEightSemesterPlan(student);
            System.out.println("Student's Eight Semester Plan:\n" + studentEightSemesterPlan);
            
            // Add a note for the student 
            advisor.setStudentNote(student, "advise to take the underwater basketweaving class");
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
