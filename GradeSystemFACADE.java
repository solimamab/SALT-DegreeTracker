import java.util.ArrayList;
public class GradeSystemFACADE {

    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;
    private User user;
    private Course course;

public GradeSystemFACADE(){
    this.userList = userList.getInstance();
    this.courseList = courseList.getInstance();
    this.majorList = majorList.getInstance();
    this.user = user;
}

    public Course findCourse(String number) {
        return course;
    }

    public ArrayList<Course> findCourse() {
        return new ArrayList<Course>();
    }

    public boolean login(String userName, String password) {
        return true;
    }

    public boolean addCourse(Course course) {
        return true;
    }

    public User findUser(String username) {
        return user.getUser();
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