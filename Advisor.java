import java.util.ArrayList;
import java.util.UUID;
/**
 * The class that has the advisor methods and logic
 */
public class Advisor extends User{
    private ArrayList<UUID> students;
    private int NumberofStudents;
    private UserList users;
    private ArrayList<Student> listOfALLStudents;

    /**
     * Constructor for advisor
     * @param students a list of students the advisor is responsible for
     */
    public Advisor(String username, String password, String firstName, String lastName){
        super(username, password, firstName, lastName);
        users = UserList.getInstance();
        listOfALLStudents = users.getStudents();  
    }
    
    /**
     * The Constructor used for the JSON files to enter advisors
     * @param id - The adviors id
     * @param username - the advisors username
     * @param password - the advisors password
     * @param firstname - the adviors firstname
     * @param lastname - the advisors last name
     * @param studentIDs - the ids of the students that the advisor is responsible
     */
    public Advisor(UUID id, String username, String password, String firstname, String lastname,
            ArrayList<UUID> studentIDs) {
            super(username, password, firstname, lastname);
            this.students = studentIDs;
            NumberofStudents = studentIDs.size();
            NumberofStudents = studentIDs.size();
            //users = UserList.getInstance();
            listOfALLStudents = users.getStudents();
    }
    /** 
     * Search for student by the id number of the student
     * @param idNumber the idnumber to be looked for
     * @return the student that matches that id number
     */ 
    public Student searchForStudent(UUID idNumber){
        for(int i = 0; i < listOfALLStudents.size(); i++){
             if(listOfALLStudents.get(i).getUUID().equals(idNumber)){
                 return listOfALLStudents.get(i);
             }
        }
        return null;
     }
 

    /**
     * Search for a student by the first name and the last name
     * @param firstName the first name to be looked for 
     * @param lastName the last name to be looked for
     * @return the student that matches that id number
     */
    public Student searchForStudent(String firstName, String lastName){
        for(int i = 0; i < listOfALLStudents.size(); i++){
            if(listOfALLStudents.get(i).getFirstName().equals(firstName) && listOfALLStudents.get(i).getLastName().equals(lastName)){
                return listOfALLStudents.get(i);
            }
        }
        return null;
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
    public ArrayList<Student> viewAdvisingStudents() {
        ArrayList<Student> student = new ArrayList<>();
        for (int i = 0; i < NumberofStudents; i++)
        {
            student.add(searchForStudent(students.get(i)));
        }
        return student;
        
    }

    /**
     * Add student to list of students advisor is responsible for advising
     * @param student - The student to be added to the list
     */
    public void addAdvisingStudent(UUID student){
        students.add(student);
        NumberofStudents++;
    }

    /**
     * Remove student from list of students advisor is responsible for advising
     * @param student - the student to be removed from the list 
     */
    public void removeAdvisingStudent(UUID student){
        for(UUID uuid : students){
            if(student.equals(uuid)){
                students.remove(uuid);
                NumberofStudents--;
            }
        }
    }

    public void setStudentNote(Student student, String note)
    {
        student.setAdvisorNote(note);
    }
}
