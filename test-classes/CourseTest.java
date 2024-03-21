import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/*
 * Tested by Lee Moorman
 */

public class CourseTest {
    private UUID id;
    private String name;
    private String department;
    private String number;
    private String description;
    private long creditHours;
    private ArrayList<Availablity> availablity;
    private HashMap<UUID, String> prerequisite;
    private ArrayList<UUID> corequisite; 

    @Test
    public void testConstructor(){

    }

    @Test
    public void testViewCouseDetails(){

    }

    public void testToString(){

    }
}
