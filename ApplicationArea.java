import java.util.ArrayList;

public class ApplicationArea {
    private CourseList courseList = CourseList.getInstance();
    private ArrayList<Course> applicationArea;
    private String typeofApplicationArea;
    private ArrayList<String> typeOfAppAreas;

    public ApplicationArea(String type){
        this.typeofApplicationArea = type;
        this.typeOfAppAreas = new ArrayList<String>();
        setPossibleAppAreas();
        setCoursesNeeded();
    }

    public void setCoursesNeeded()
    {
        if (typeofApplicationArea.equals("Science"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "105"));
            this.applicationArea.add(courseList.getCourseByNumber(" ", " "));
            this.applicationArea.add(courseList.getCourseByNumber("", ""));
        }
        else if (typeofApplicationArea.equals("Math"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "105"));
            this.applicationArea.add(courseList.getCourseByNumber(" ", " "));
            this.applicationArea.add(courseList.getCourseByNumber("", ""));
        }
        else if (typeofApplicationArea.equals("Digital Design"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "105"));
            this.applicationArea.add(courseList.getCourseByNumber(" ", " "));
            this.applicationArea.add(courseList.getCourseByNumber("", ""));
        }
        else if (typeofApplicationArea.equals("Speech"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "105"));
            this.applicationArea.add(courseList.getCourseByNumber(" ", " "));
            this.applicationArea.add(courseList.getCourseByNumber("", ""));
        }
        else if (typeofApplicationArea.equals("Robitics"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "105"));
            this.applicationArea.add(courseList.getCourseByNumber(" ", " "));
            this.applicationArea.add(courseList.getCourseByNumber("", ""));
        }
        else 
        {
            System.out.println("The type of application is not offered at the time");
        }
    }

    private void setPossibleAppAreas()
    {
        this.typeOfAppAreas.add("Science");
        this.typeOfAppAreas.add("Math");
        this.typeOfAppAreas.add("Digital Design");
        this.typeOfAppAreas.add("Speech");
        this.typeOfAppAreas.add("Robitics");

    }
    public String getListofAppAreas()
    {
        return "Possible Applications Areas are:\n" + typeOfAppAreas.toString();
    }
    public ArrayList<Course> getApplicationArea()
    {
        return this.applicationArea;
    }
}
