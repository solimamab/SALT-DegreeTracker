import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
/**
 * Tested by Libaan
 */
public class ApplicationAreaTest {
    private ApplicationArea applicationArea;

    @BeforeEach
    public void setUp() {
        applicationArea = new ApplicationArea();
    }

    @Test
    public void testSetTypeScienceCoursesNotEmpty() {
        applicationArea.setType("Science");
        applicationArea.setCoursesNeeded();
        assertFalse(applicationArea.getApplicationArea().isEmpty());
    }

    @Test
    public void testSetTypeMathCoursesNotEmpty() {
        applicationArea.setType("Math");
        applicationArea.setCoursesNeeded();
        assertFalse(applicationArea.getApplicationArea().isEmpty());
    }

    @Test
    public void testInvalidApplicationArea() {
        applicationArea.setType("InvalidType");
        applicationArea.setCoursesNeeded();
        assertTrue(applicationArea.getApplicationArea().isEmpty());
    }

    @Test
    public void testGetListOfAppAreasContainsScience() {
        String appAreas = applicationArea.getListofAppAreas();
        assertTrue(appAreas.contains("Science"));
    }

    @Test
    public void testGetListOfAppAreasContainsMath() {
        String appAreas = applicationArea.getListofAppAreas();
        assertTrue(appAreas.contains("Math"));
    }
}
