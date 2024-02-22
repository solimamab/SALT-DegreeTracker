public class Course {
    private UUID id;
    private String name;
    private String department;
    private String number;
    private String description;
    private int cerditHours;
    private Availablity availablity;
    private ArrayList<Course> prerequisite;
    private ArrayList<Course> corequisite;

    public Course(UUID id, String name, String department, String number, String description, int cerditHours,
    Availablity availablity, ArrayList<Course> prerequisite, ArrayList<Course> corequisite)
    {
        this.id = id;
        this.name = name;
        this.department = department;
        this.number = number;
        this.department = description;
        this.cerditHours =cerditHours;
        this.availablity = availablity;
        this.prerequisite = prerequisite;
        this.corequisite= corequisite;
    }

    public ArrayList<String> viewCourseDetails(Course course)
    {
        return new ArrayList<Sting>;
    }
    
}
