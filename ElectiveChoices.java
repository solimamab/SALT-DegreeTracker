import java.util.ArrayList;

public class ElectiveChoices {
    private CourseList electiveChoices = CourseList.getInstance();
    private ArrayList<Course> elecetivesChoosen;
    private int numCredits;
    private ArrayList<String> RequirementsNeeded;
    private ArrayList<String> RequirementsDone;
    private ArrayList<String> RequirementsToDo;
    

    public ElectiveChoices(ArrayList<String> requirementsDone) {
        this.RequirementsDone = requirementsDone;
        setRequirementsNeeded();
        setRequirementsToDO();
    }


    public ArrayList<Course> getElectiveChoosen()
    {
        return this.elecetivesChoosen;
    }

    public ArrayList<String> getRequirementsTODO()
    {
        return this.RequirementsToDo;
    }

    private void setRequirementsNeeded()
    {
        this.RequirementsNeeded = new ArrayList<String>();
        this.RequirementsNeeded.add("GFL");
        this.RequirementsNeeded.add("AUI");
        this.RequirementsNeeded.add("GSS");
        this.RequirementsNeeded.add("GHS");
        this.RequirementsNeeded.add("CMW");
        this.RequirementsNeeded.add("SCI");
        this.RequirementsNeeded.add("VSR");
        this.RequirementsNeeded.add("CMS");
    }

    public void setRequirementsToDO()
    {
        this.RequirementsToDo = this.RequirementsNeeded;
        for (int i = 0; i < this.RequirementsDone.size(); i++)
        {
            RequirementsToDo.remove(RequirementsDone.get(i));
        }
    }
  
    public ArrayList<Course> listClassesForRequirement(String requirement)
    {
        ArrayList<Course> List = new ArrayList<Course>();
        if (requirement.equals("GFL"))
        {
            List.add(electiveChoices.getCourseByNumber("SPAN", "110"));
            List.add(electiveChoices.getCourseByNumber("ARAB", "121"));
            List.add(electiveChoices.getCourseByNumber("FREN", "109"));
            return List;
            
        }
        else if (requirement.equals("AUI"))
        {
            List.add(electiveChoices.getCourseByNumber("ARTE", "101"));
            List.add(electiveChoices.getCourseByNumber("ARTS", "103"));
            List.add(electiveChoices.getCourseByNumber("ENGL", "200"));
            return List;
        }
        else if (requirement.equals("GSS"))
        {
            List.add(electiveChoices.getCourseByNumber("AFAM", "201"));
            List.add(electiveChoices.getCourseByNumber("CYBR", "101"));
            List.add(electiveChoices.getCourseByNumber("PSYC", "101"));
            return List;
        }
        else if (requirement.equals("GHS"))
        {
            List.add(electiveChoices.getCourseByNumber("HIST", "101"));
            List.add(electiveChoices.getCourseByNumber("HIST", "111"));
            List.add(electiveChoices.getCourseByNumber("HIST", "112"));
            return List;
        }
        else if (requirement.equals("CMW"))
        {
            List.add(electiveChoices.getCourseByNumber("ENGL", "101"));
            return List;
        }
        else if (requirement.equals("SCI"))
        {
            List.add(electiveChoices.getCourseByNumber("CHEM", "105"));
            List.add(electiveChoices.getCourseByNumber("CHEM", "107"));
            List.add(electiveChoices.getCourseByNumber("BIOL", "101"));
            return List;
        }
        else if (requirement.equals("VSR"))
        {
            List.add(electiveChoices.getCourseByNumber("ANTH", "212"));
            List.add(electiveChoices.getCourseByNumber("BIOL", "208"));
            List.add(electiveChoices.getCourseByNumber("WGST", "112"));
            return List;
        }
        else if (requirement.equals("CMS"))
        {
            List.add(electiveChoices.getCourseByNumber("PHIL", "325"));
            List.add(electiveChoices.getCourseByNumber("SPCH", "140"));
            List.add(electiveChoices.getCourseByNumber("PHIL", "213"));
            return List;
        }
        else 
        {
            //requirement not valid
            return null;
        }

        
    }

    public void chooseClass(Course course, String requirement)
    {
        this.elecetivesChoosen.add(course);
        this.RequirementsDone.add(requirement);
        
    }

    public void fulfilledRequirement(String requirement)
    {
        this.RequirementsToDo.remove(requirement);
    }
    
}