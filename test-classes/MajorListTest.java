import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.UUID;
import java.util.HashMap;

/**
 * Tested by Libaan
 */

public class MajorListTest {
    @Test
    public void testGetInstanceNotNull() {
        MajorList instance = MajorList.getInstance();
        assertNotNull(instance);
    }

    @Test
    public void testSingletonInstance() {
        MajorList firstInstance = MajorList.getInstance();
        MajorList secondInstance = MajorList.getInstance();
        assertSame(firstInstance, secondInstance);
    }

    @Test
    public void testFindMajorWithNullId() {
        MajorList instance = MajorList.getInstance();
        Major result = instance.findMajor(null);
        assertNull(result);
    }

    @Test
    public void testFindMajorWithNonexistentId() {
        MajorList instance = MajorList.getInstance();
        Major result = instance.findMajor(UUID.randomUUID());
        assertNull(result);
    }

    @Test
    public void testFindMajorValidId() {
        UUID validMajorId = UUID.fromString("8c9e49df-95a1-4b7a-a189-02d4d225f10e");
        MajorList instance = MajorList.getInstance();
        Major result = instance.findMajor(validMajorId);
        assertNotNull(result);
        assertEquals(validMajorId, result.getId());
    }
}
