import java.util.ArrayList;
import java.util.UUID;
/**
 * The class that has the advisor methods and logic
 */
public class Advisor extends User{
    private ArrayList<UUID> students;
    private int NumberofStudents;
    

    /**
     * Constructor for advisor
     * @param students a list of students the advisor is responsible for
     */
    public Advisor(String username, String password, String firstName, String lastName ){
        super(username, password, firstName, lastName);

        
    }

    public Advisor(UUID id, String username, String password, String firstname, String lastname,
            ArrayList<UUID> studentIDs) {
            super(username, password, firstname, lastname);
            this.students = studentIDs;
            NumberofStudents = studentIDs.size();
            

        
    }
    /** 
     * Search for student by the id number of the student
     * @param idNumber the idnumber to be looked for
     * @return the student that matches that id number
     */ 
    public Student searchForStudent(String idNumber){
        
        
        return new Student(idNumber, null, null, null, null, 0, 0, null, 0, null, null, null, null, null, null);
       
    }

    /**
     * Search for a student by the first name and the last name
     * @param firstName the first name to be looked for 
     * @param lastName the last name to be looked for
     * @return the student that matches that id number
     */
    public Student searchForStudent( String firstName, String lastName){
        return new Student(lastName, lastName, lastName, lastName, null, 0, 0, null, 0, null, lastName, null, null, null, null);
    }

    /**
     * Setting the student flags 
     * @param flag - the flag to be added to the students account
     * @param student the student for the flag to be added
     */
    public void setStudentsFlag(Flag flag, Student student){
        student.setFlag(flag);
    }

    /**
     * To view the list of students that advisor is responsible for advising
     * @return the list of students that they are advising
     */
    public ArrayList<UUID> viewAdvisingStudents(){
        return this.students;
        
    }
}
