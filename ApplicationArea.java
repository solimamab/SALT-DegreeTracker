import java.util.ArrayList;

public class ApplicationArea {
    private ArrayList<Course> applicationArea;
    private String typeofApplicationArea;

    public ApplicationArea(String type){
        this.typeofApplicationArea = type;
        setCoursesNeeded();
    }

    public void setCoursesNeeded()
    {
        if (typeofApplicationArea.equals("Science"))
        {
            this.applicationArea = new ArrayList<Course>();
        }
        else if (typeofApplicationArea.equals("Math"))
        {
            this.applicationArea = new ArrayList<Course>();
        }
        else if (typeofApplicationArea.equals("Digital Design"))
        {
            this.applicationArea = new ArrayList<Course>();
        }
        else if (typeofApplicationArea.equals("Speech"))
        {
            this.applicationArea = new ArrayList<Course>();
        }
        else if (typeofApplicationArea.equals("Robitics"))
        {
            this.applicationArea = new ArrayList<Course>();
        }
        else 
        {
            System.out.println("The type of application is not offered at the time");
        }
    }

    public ArrayList<Course> getApplicationArea()
    {
        return this.applicationArea;
    }
}
