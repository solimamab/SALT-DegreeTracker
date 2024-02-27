import java.util.Scanner;
/**
 * 
 */
public class DegreeTrackerUI
{
    private GradeSystemFACADE gradeSystemFACADE;

    DegreeTrackerUI() {
       gradeSystemFACADE = new GradeSystemFACADE();

    }

    public void run() {
        scenerio1();
        
    }

    public void scenerio1() {

        if(!gradeSystemFACADE.login("asmith", "12345"))
        {
            System.out.println("Sorry we couldn't login");
            return;
        }

        System.out.println("Amy Smith is now logged in");
    }

    public static void main(String args[]) {
        DegreeTrackerUI UI = new DegreeTrackerUI();
        UI.run();
    }
}
