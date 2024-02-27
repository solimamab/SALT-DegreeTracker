import java.util.ArrayList;

public class GradeSystemFACADE {

    private UserList userList;
    private CourseList courseList;
    private Major majorList;
    private User user;
    private Course course;

    public GradeSystemFACADE() {
        this.userList = userList;
        this.courseList = courseList;
        this.majorList = majorList;
        this.user = user;
        this.course = course;
    }

    public Course findCourse(String number) {
        return course;
    }

    public ArrayList<Course> findCourse() {
        return new ArrayList<Course>();
    }

    public User login(String userName, String password) {
        return user;
    }

    public boolean addCourse(Course course) {
        return true;
    }

    public User findUser(String username) {
        return user;
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