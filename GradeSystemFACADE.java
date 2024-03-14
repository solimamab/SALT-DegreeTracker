import java.util.ArrayList;
import java.util.Scanner;
public class GradeSystemFACADE {

    private static GradeSystemFACADE facade;
    private UserList userList = UserList.getInstance();
    private User currentUser;
    private CourseList courseList = CourseList.getInstance();
    private MajorList majorList = MajorList.getInstance();
    Scanner scanner = new Scanner(System.in);

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

    /**
     * 
     * @param number
     * @return
     */
    public Course findCourse(String department, String number) {
        return courseList.getCourseByNumber(department, number);
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
        return userList.getUser(username);
    }

    public ArrayList<Course> getCourseDetails(Course course) {
        return new ArrayList<Course>();
    }

    public String getUserDetails(String username) {
        return userList.toString();
    }

    public boolean notOfferCourse(Course course) {
        return false;
    }

    public boolean advisorReassignment(Student student) {
        return true;
    }


    public void StartingOptions()
    {
        System.out.println("Hello welcome to the Degree progress tracker \n What would you like to do today?"
        + "\n 1. Login in as existing user"
        + "\n 2. Create new student account"
        + "\n 3. Create new advisor account"
        + "\n 4. Exit the program");

        int userInput = scanner.nextInt();

        if (userInput == 1)
            {
                System.out.println("What is your username?");
                String username = scanner.nextLine();
                System.out.println("What is your password?");
                String password = scanner.nextLine();
                if (login(username, password) == true)
                    {
                        currentUser = findUser(username);
                    }
                else 
                {
                    System.out.println("Sorry, could not login in");
                }
            }
        else if (userInput == 2)
        {

        }
        else if (userInput == 3)
        {

        }
        else if (userInput == 4)
        {
            System.out.println("GoodBye!");
            System.exit(0);
        }
        else 
            System.out.println("Enter valid option");
    }

}