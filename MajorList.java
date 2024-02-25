import java.util.ArrayList;

public class MajorList {
    private static MajorList majorList;
    private Course courseTest;  // filler
    private ArrayList<Major> availableMajors;

    private MajorList()
    {
        majorList = this;
        this.availableMajors = null;
    }

    public MajorList getInstance()
    {
        return this.majorList;
    }
}
