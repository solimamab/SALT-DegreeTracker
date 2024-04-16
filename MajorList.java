import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class MajorList {
    private static MajorList majorList;
    private ArrayList<Major> availableMajors;
    private HashMap<UUID, Major> majorMap;
    private static HashMap<UUID, Course> courseMap;

    private MajorList() {
        courseMap = CourseList.getInstance().getAllCourses();  // Use CourseList to maintain a single source of courses
        this.availableMajors = DataLoader.loadMajors(courseMap);
        this.majorMap = new HashMap<>();
        populateMajorMap();
    }

    private void populateMajorMap() {
        for (Major major : availableMajors) {
            majorMap.put(major.getId(), major);
        }
    }

    public static MajorList getInstance() {
        if (majorList == null) {
            majorList = new MajorList();
        }
        return majorList;
    }

    public ArrayList<Major> getAvailableMajors() {
        return availableMajors;
    }

    public HashMap<UUID, Major> getMajorMap() {
        return majorMap;
    }

    public Major findMajor(UUID majorId) {
        return majorMap.get(majorId);  // Directly use HashMap for efficient lookup
    }
}