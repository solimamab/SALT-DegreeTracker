import java.util.ArrayList;

public class MajorList {
    private static MajorList majorList;
    private ArrayList<Major> availableMajors;

    private MajorList() {
        this.availableMajors = new ArrayList<>();
    }

    public MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;    
    }
}
