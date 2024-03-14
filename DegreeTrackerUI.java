import java.util.Scanner;
/**
 * 
 */
public class DegreeTrackerUI
{
    private GradeSystemFACADE gradeSystemFACADE;

    public DegreeTrackerUI() {
       gradeSystemFACADE = GradeSystemFACADE.getFacadeInstance();

    }

    public void run() {
        scenerio1();
        
    }

    public void scenerio1() {

        if(!gradeSystemFACADE.login("BWEST", "12345"))
        {
            System.out.println("Sorry we couldn't login");
            return;
        }

        System.out.println("Brax West is now logged in");
        gradeSystemFACADE.setCurrentUser(gradeSystemFACADE.findUser("BWEST"));

    }

    public void scenario2()
    {
        Advisor Odden = new Advisor("OOdden","12345","Obsert","Odden");
        gradeSystemFACADE.createAdvisorAccount(Odden);
        System.out.println("New advisor account created for Obsert Odden");
        gradeSystemFACADE.setCurrentUser(Odden);
        
    }

    public static void main(String args[]) {
        DegreeTrackerUI UI = new DegreeTrackerUI();
        UI.run();
    }
}
