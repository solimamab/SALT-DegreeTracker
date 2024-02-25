import java.util.ArrayList;

public class UserList {
    private static UserList userList;
    private ArrayList<User> students;
    private ArrayList<User> advisors;

    private UserList()
    {
        this.students = new ArrayList<>();
        this.advisors = new ArrayList<>();
    }

    public UserList getInstance()
    {
        if (userList == null) {
            userList = new UserList();
        }
        return userList;    }

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
}
