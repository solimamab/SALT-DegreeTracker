import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * User list of all users in the system
 * @author abhinavk
 */
public class UserList {
    private static volatile UserList userList = null;
    private static ArrayList<Student> listOfStudents;
    private static ArrayList<Advisor> listOfAdvisors;
    private static HashMap<UUID, Course> courseMap;

    /**
     * Constructor to create an Instance of the UserList
     */
    private UserList() {
        try {
            courseMap = DataLoader.loadCourses();
            listOfStudents = DataLoader.loadStudents(courseMap);
            listOfAdvisors = DataLoader.loadAdvisors();
        } catch (Exception e) {
            // Handle exception gracefully
            e.printStackTrace();
            listOfStudents = new ArrayList<>();
            listOfAdvisors = new ArrayList<>();
            courseMap = new HashMap<>();
        }
    }

    /**
     * Singleton Instance of UserList
     * @return the userList
     */
    public static UserList getInstance() {
        if (userList == null) {
            synchronized (UserList.class) {
                if (userList == null) {
                    userList = new UserList();
                }
            }
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

    /**
     * Adds an advisor to the list of advisors 
     * @param advisor the advisor to be added
     */
    public void addAdvisor(Advisor advisor)
    {
        listOfAdvisors.add(advisor);
    }

    /**
     * Adds a student to the list of students
     * @param student the student to be added
     */
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
            if (advisor.getAdvisorID().equals(advisorId)) {
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
    
    /**
     * Find a student by their first name and last name.
     * @param firstName The first name of the student.
     * @param lastName The last name of the student.
     * @return The Student object if found, or null if not found.
     */
    public Student findStudentByName(String firstName, String lastName) {
        for (Student student : listOfStudents) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null; // Student not found
    }
}


