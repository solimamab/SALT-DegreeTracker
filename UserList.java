import java.util.ArrayList;

/**
 * User list of all users in the system
 */
public class UserList {
    private static UserList userList;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;

    /**
     * Constructor to initialize students and advisors list
     */
    private UserList() {
        students = (DataLoader.loadStudents() == null ? new ArrayList<>() : DataLoader.loadStudents());
        advisors = (DataLoader.loadAdvisors() == null ? new ArrayList<>() : DataLoader.loadAdvisors());
    }

    /**
     * Gets the instance to make the userlist static
     * @return the user list
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
        // Search in students list
        for (User user : students) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        // Search in advisors list
        for (User user : advisors) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        // If user is not found in both lists
        return null;
    }

    public void saveStudents() {
        DataWriter.saveStudentList(students);
    }

}


