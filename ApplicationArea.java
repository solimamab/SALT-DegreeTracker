import java.util.ArrayList;

public class ApplicationArea {
    private CourseList courseList = CourseList.getInstance();
    private ArrayList<Course> applicationArea;
    private String typeofApplicationArea;
    private ArrayList<String> typeOfAppAreas;

    public ApplicationArea(){
        this.typeOfAppAreas = new ArrayList<String>();
        setPossibleAppAreas();
    }

    public void setCoursesNeeded()
    {
        if (typeofApplicationArea.equals("Science"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "105"));
            this.applicationArea.add(courseList.getCourseByNumber("CHEM", "111"));
            this.applicationArea.add(courseList.getCourseByNumber("BIOL", "102"));
        }
        else if (typeofApplicationArea.equals("Math"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("MATH", "111"));
            this.applicationArea.add(courseList.getCourseByNumber("MATH", "174"));
            this.applicationArea.add(courseList.getCourseByNumber("MATH", "141"));
        }
        else if (typeofApplicationArea.equals("Criminal Justice"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("CRJU", "202"));
            this.applicationArea.add(courseList.getCourseByNumber("CRJU", "311"));
            this.applicationArea.add(courseList.getCourseByNumber("CRJU", "212"));
        }
        else if (typeofApplicationArea.equals("Speech"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("SPCH", "140"));
            this.applicationArea.add(courseList.getCourseByNumber("SPCH", "201"));
            this.applicationArea.add(courseList.getCourseByNumber("SPCH", "260"));
        }
        else if (typeofApplicationArea.equals("Robitics"))
        {
            this.applicationArea = new ArrayList<Course>();
            this.applicationArea.add(courseList.getCourseByNumber("EMCH", "535"));
            this.applicationArea.add(courseList.getCourseByNumber("ELCT", "331"));
            this.applicationArea.add(courseList.getCourseByNumber("ELCT", "531"));
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
        this.typeOfAppAreas.add("Criminal Justice");
        this.typeOfAppAreas.add("Speech");
        this.typeOfAppAreas.add("Robitics");

    }

    public void setType(String type)
    {
        this.typeofApplicationArea = type;
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
