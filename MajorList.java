import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MajorList {
    private static MajorList majorList;
    private ArrayList<Major> availableMajors;
    private HashMap<UUID, Major> majorMap;

    private MajorList() {
        this.availableMajors = DataLoader.loadMajors(null);
        this.majorMap = new HashMap<>();
    }

    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;    
    }

    public Major findMajor(UUID majorId)
    {
        for( int i =0; i < availableMajors.size();i++)
        {
            if (availableMajors.get(i).getId().equals(majorId))
            {
                return availableMajors.get(i);
            }
        }
        return null;
    }
    
}
