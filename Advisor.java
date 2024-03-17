import java.util.ArrayList;
import java.util.UUID;
/**
 * The class that has the advisor methods and logic
 */
public class Advisor extends User{
    private UUID id;
    private ArrayList<UUID> students;
    private int NumberofStudents;
    private static UserList users = UserList.getInstance();
    private ArrayList<Student> listOfALLStudents;
    
    /**
     * The Constructor used for the JSON files to enter advisors
     * @param id - The adviors id
     * @param username - the advisors username
     * @param password - the advisors password
     * @param firstname - the adviors firstname
     * @param lastname - the advisors last name
     * @param studentIDs - the ids of the students that the advisor is responsible
     */
    public Advisor(UUID Advisorid, String username, String password, String firstname, String lastname, ArrayList<UUID> studentIDs) {
            super(username, password, firstname, lastname);
            this.id = Advisorid;
            this.students = studentIDs;
            NumberofStudents = setNumofStudents(studentIDs);
            listOfALLStudents = users.getStudents();
            // if (users == null) {
            //     users = UserList.getInstance();
            // }
    }

    public UUID getAdvisorID()
    {
        return this.id;
    }
    /** 
     * Search for student by the id number of the student
     * @param idNumber the idnumber to be looked for
     * @return the student that matches that id number
     */ 
    public Student searchForStudent(UUID idNumber){
        return users.findStudentById(idNumber);
        // for(int i = 0; i < listOfALLStudents.size(); i++){
        //      if(listOfALLStudents.get(i).getUUID().equals(idNumber)){
        //          return listOfALLStudents.get(i);
        //      }
        // }
        // return null;
     }
 

    /**
     * Search for a student by the first name and the last name
     * @param firstName the first name to be looked for 
     * @param lastName the last name to be looked for
     * @return the student that matches that id number
     */
    public Student searchForStudent(String firstName, String lastName){
        return users.findStudentByName(firstName, lastName);
        // for(int i = 0; i < listOfALLStudents.size(); i++){
        //     if(listOfALLStudents.get(i).getFirstName().equals(firstName) && listOfALLStudents.get(i).getLastName().equals(lastName)){
        //         return listOfALLStudents.get(i);
        //     }
        // }
        // return null;
    }

    /**
     * Setting the student flags 
     * @param flag - the flag to be added to the students account
     * @param student the student for the flag to be added
     */
    public void setStudentsFlag(Flag flag, Student student){
        student.setFlag(flag);
    }

    public int setNumofStudents(ArrayList<UUID> students)
    {
        if (students == null)
            return 0;
        else
            return students.size();
    }

    /**
     * To view the list of students that advisor is responsible for advising
     * @return the list of students that they are advising
     */
    public ArrayList<Student> viewAdvisingStudents() {
        ArrayList<Student> advisingStudents = new ArrayList<>();
        if (students !=null)
        {
        for (UUID studentId : students) {
            Student student = searchForStudent(studentId);
            if (student != null) {
                advisingStudents.add(student);
            }
        }
        }
        return advisingStudents;
    }

    /**
     * Add student to list of students advisor is responsible for advising
     * @param student - The student to be added to the list
     */
    public void addAdvisingStudent(UUID student){
        if(students == null)
        {
            students = new ArrayList<UUID>();
            students.add(student);
            NumberofStudents++;
        }
        else
        {
            students.add(student);
            NumberofStudents++;
        }

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Advisor ID: ").append(getAdvisorID()).append("\n");
        sb.append("Username: ").append(getUsername()).append("\n");
        sb.append("Password: ").append(getPassword()).append("\n");
        sb.append("First Name: ").append(getFirstName()).append("\n");
        sb.append("Last Name: ").append(getLastName()).append("\n");
        sb.append("Number of Students Advised: ").append(NumberofStudents).append("\n");
        sb.append("Students Advised:\n");
        ArrayList<Student> advisedStudents = viewAdvisingStudents();
        for (Student student : advisedStudents) {
            sb.append(student.getFirstName().toString());
            sb.append(student.getLastName().toString()).append("\n");
        }
        return sb.toString();
    }
}
