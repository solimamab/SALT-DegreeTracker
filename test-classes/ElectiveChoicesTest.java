import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ElectiveChoicesTest {
    
    private ElectiveChoices electiveChoices;

    @BeforeEach
    public void setUp() {
        ArrayList<String> requirementsDone = new ArrayList<>();
        requirementsDone.add("GFL");
        electiveChoices = new ElectiveChoices(requirementsDone);
    }

    @Test
    public void testSetRequirementsToDO() {
        assertFalse(electiveChoices.getRequirementsTODO().contains("GFL"), "GFL should not be in the TODO list");
        assertTrue(electiveChoices.getRequirementsTODO().contains("AUI"), "AUI should be in the TODO list");
    }

    @Test
    public void testListClassesForRequirement() {
        ArrayList<Course> gflCourses = electiveChoices.listClassesForRequirement("GFL");
        assertNotNull(gflCourses, "GFL courses should not be null");
        assertEquals(3, gflCourses.size(), "There should be 3 courses for GFL requirement");
        }

    @Test
    public void testFulfilledRequirement() {
        String requirement = "GFL";
        electiveChoices.fulfilledRequirement(requirement);
        assertFalse(electiveChoices.getRequirementsTODO().contains(requirement), "GFL should not be in the TODO list after being fulfilled");
    }


}
