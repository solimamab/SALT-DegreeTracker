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
        listOfStudents = (DataLoader.loadStudents() == null ? new ArrayList<>() : DataLoader.loadStudents());
        listOfAdvisors = (DataLoader.loadAdvisors() == null ? new ArrayList<>() : DataLoader.loadAdvisors());
    }

    private UserList(ArrayList<Student> students, ArrayList<Advisor> advisors) {
        listOfStudents = students;
        listOfAdvisors = advisors;
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
        for (User user : listOfStudents) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        // Search in advisors list
        for (User user : listOfAdvisors) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        // If user is not found in both lists
        return null;
    }

    public void saveStudents() {
        DataWriter.saveStudentList(listOfStudents);
    }

}


