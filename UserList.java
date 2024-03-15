import java.util.ArrayList;
import java.util.UUID;

/**
 * User list of all users in the system
 * @author abhinavk
 */
public class UserList {
    private static UserList userList;
    private static ArrayList<Student> listOfStudents;
    private static ArrayList<Advisor> listOfAdvisors;

    /**
     * Constructor to initialize students and advisors list
     */
    private UserList() {
        try {
            listOfStudents = (DataLoader.loadStudents(null) != null ? DataLoader.loadStudents(null) : new ArrayList<>());
            listOfAdvisors = (DataLoader.loadAdvisors() != null ? DataLoader.loadAdvisors() : new ArrayList<>());
        } catch (Exception e) {
            e.printStackTrace();
            listOfStudents = new ArrayList<>(); // Ensure the list is initialized even if error
            listOfAdvisors = new ArrayList<>();
        }
    }

    /**
     * 
     * @param students
     * @param advisors
     */
    private UserList(ArrayList<Student> students, ArrayList<Advisor> advisors) {
        listOfStudents = students;
        listOfAdvisors = advisors;
    }

    /**
     * Gets the instance to make the userlist static
     * @return the userlist
     */
    public static UserList getInstance() {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;
    }

    /**
     * Searches for the user from the user lists by username
     * @return the user
     */
    public User getUser(String username) {
        for (Student student : listOfStudents) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        for (Advisor advisor : listOfAdvisors) {
            if (advisor.getUsername().equals(username)) {
                return advisor;
            }
        }
        return null;
    }

    public void addAdvisor(Advisor advisor)
    {
        listOfAdvisors.add(advisor);
    }

    public void addStudent(Student student)
    {
        listOfStudents.add(student);
    }

    /*public void saveStudents() {
        DataWriter.saveStudents(listOfStudents);
    }

    public void saveAdvisors() {
        DataWriter.saveAdvisors(listOfAdvisors);  // waiting on datawriter method for this
    }
    */

    public ArrayList<Student> getStudents(){
        return listOfStudents;
    }

    public ArrayList<Advisor> getAdvisors(){
        return listOfAdvisors;
    }

    public Advisor findAdvisor(UUID advisorId) {
        for (Advisor advisor : listOfAdvisors) {
            if (advisor.getUserId().equals(advisorId)) {
                return advisor;
            }
        }
        return null; // Return null if no advisor is found with the given ID
    }

    /**
     * Find a student by their ID.
     * @param studentID The ID of the student to find.
     * @return The found student, or null if not found.
     */
    public Student findStudentById(UUID studentID) {
        for (Student student : listOfStudents) {
            if (student.getUUID().equals(studentID)) {
                return student;
            }
        }
        return null; // Student not found
    }
    
}


