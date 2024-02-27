import java.util.ArrayList;

public class Advisor {
    private ArrayList<Student> students;

    public Advisor(User user, ArrayList<Student> students){

    }

    public Student searchForStudent(String idNumber){
        return new Student(idNumber, idNumber, idNumber, idNumber, null, 0, 0, null, 0, null, idNumber, null, null, null, null);
    }

    public Student searchForStudent(String idNumber, String firstName, String lastName){
        return new Student(lastName, lastName, lastName, lastName, null, 0, 0, null, 0, null, lastName, null, null, null, null);
    }

    public void setStudentsFlag(Flag flag, User student){

    }

    public void viewAdvisingStudents(ArrayList<Student> students){

    }
}
