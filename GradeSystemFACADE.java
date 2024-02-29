import java.util.ArrayList;
public class GradeSystemFACADE {

    private static GradeSystemFACADE facade;
    private UserList userList = UserList.getInstance();
    private User currentUser;
    private CourseList courseList = CourseList.getInstance();
    private MajorList majorList = MajorList.getInstance();

    /**
     * Private constructor to prevent direct instantiation
     */
    private GradeSystemFACADE() {
        this.currentUser = new User("asmith", "12345", "Amy", "Smith");
    }

    /**
     * Get the singleton instance
     */
    public static GradeSystemFACADE getFacadeInstance() {
        if (facade == null) {
            facade = new GradeSystemFACADE();
        }
        return facade;
    }



    public Course findCourse(String number) {
        return null;
    }

    public ArrayList<Course> findCourse() {
        return new ArrayList<Course>();
    }

    public boolean login(String username, String password) {
        User user = userList.getUser(username);
        if (user == null || !user.getUsername().equals(username) || !user.getPassword().equals(password))
            return false;
        setCurrentUser(user);
        currentUser.facadeLogin(username, password);
        return true;    
    }

    private void setCurrentUser(User user) {
        this.currentUser = user;
    }

    public boolean addCourse(Course course) {
        return true;
    }

    public User findUser(String username) {
        return currentUser.getUser();
    }

    public ArrayList<Course> getCourseDetails(Course course) {
        return new ArrayList<Course>();
    }

    public boolean getUserDetails(User user) {
        return true;
    }

    public boolean notOfferCourse(Course course) {
        return false;
    }

    public boolean advisorReassignment(Student student) {
        return true;
    }

}