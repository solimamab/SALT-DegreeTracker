import java.util.ArrayList;

/**
 * User list of all users in the system
 * @author abhinavk
 */
public class UserList {
    private static UserList userList;
    private ArrayList<Student> listOfStudents;
    private ArrayList<Advisor> listOfAdvisors;

    /**
     * Constructor to initialize students and advisors list
     */
    private UserList() {
        listOfStudents = (DataLoader.loadStudents() != null ? DataLoader.loadStudents() : new ArrayList<>());
        listOfAdvisors = (DataLoader.loadAdvisors() != null ? DataLoader.loadAdvisors() : new ArrayList<>());
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
    public static synchronized UserList getInstance() {
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

    public void saveStudents() {
        DataWriter.saveStudentList(listOfStudents);
    }

    public void saveAdvisors() {
        DataWriter.saveAdvisorList(listOfAdvisors);  // waiting on datawriter method for this
    }
}


