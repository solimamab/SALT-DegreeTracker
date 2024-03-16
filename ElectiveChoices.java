import java.util.ArrayList;

public class ElectiveChoices {
    private ArrayList<Course> electiveChoices;
    private ArrayList<Course> elecetivesChoosen;
    private int numCredits;
    private ArrayList<String> RequirementsNeeded;
    private ArrayList<String> ReguirementsDone;
    private ArrayList<String> RequirementsToDo;
    

    public ElectiveChoices(ArrayList<String> requirementsDone) {
        this.ReguirementsDone = requirementsDone;
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
        this.RequirementsNeeded.add("ARP");
        this.RequirementsNeeded.add("SCI");
        this.RequirementsNeeded.add("VSR");
        this.RequirementsNeeded.add("CMS");
    }

    public void setRequirementsToDO()
    {
        this.RequirementsToDo = this.RequirementsNeeded;
        for (int i = 0; i < this.ReguirementsDone.size(); i++)
        {
            RequirementsToDo.remove(ReguirementsDone.get(i));
        }
    }

  
    
}