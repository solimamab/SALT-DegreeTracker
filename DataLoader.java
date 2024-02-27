import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Loads data from JSON files
 * @author abhinavk
 */
public class DataLoader extends DataConstants {
    private static final String STUDENT_FILE_NAME = "json/students.json";
    private static final String COURSE_FILE_NAME = "json/courses.json";
    private static final String MAJOR_FILE_NAME = "json/majors.json";
    private static final String ADVISOR_FILE_NAME = "json/advisors.json";

    /**
     * Loads students from a JSON file.
     * @return A list of Student objects.
     */
    public static ArrayList<Student> loadStudents() {
        ArrayList<Student> students = new ArrayList<>();

        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);

            for (Object studentObj : studentsJSON) {
                JSONObject studentJSON = (JSONObject) studentObj;
                UUID id = UUID.fromString((String) studentJSON.get(STUDENT_ID));
                String username = (String) studentJSON.get(STUDENT_USERNAME);
                String password = (String) studentJSON.get(STUDENT_PASSWORD);
                String firstname = (String) studentJSON.get(STUDENT_FIRSTNAME);
                String lastname = (String) studentJSON.get(STUDENT_LASTNAME);
                String classification = (String) studentJSON.get(STUDENT_CLASSIFICATION);
                long completedCreditHours = (long) studentJSON.get(STUDENT_COMPLETED_CREDIT_HOURS);
                long remainingCreditHours = (long) studentJSON.get(STUDENT_REMAINING_CREDIT_HOURS);
                boolean flag = (boolean) studentJSON.get(STUDENT_FLAG);
                double overallGPA = (double) studentJSON.get(STUDENT_OVERALL_GPA);
                UUID majorId = UUID.fromString((String) studentJSON.get(STUDENT_MAJOR_ID));
                String minor = (String) studentJSON.get(STUDENT_MINOR);
                boolean FERPA = (boolean) studentJSON.get(STUDENT_FERPA);
                UUID advisorId = UUID.fromString((String) studentJSON.get(STUDENT_ADVISOR_ID));
                // completed courses

                UUID courseId = UUID.fromString((String) studentJSON.get(STUDENT_COURSE_ID));
                String letterGrade = (String) studentJSON.get(STUDENT_LETTER_GRADE);
                long qualityPoints = (long) studentJSON.get(STUDENT_QUALITY_POINTS);
                // eight semester !!!!

                UUID classesInPlanIDs = UUID.fromString((String) studentJSON.get(STUDENT_CLASSES_IN_PLAN_IDS));
                UUID applicationAreaIDs = UUID.fromString((String) studentJSON.get(STUDENT_APPLICATION_AREA_IDS));
                UUID electiveChoiceIDs = UUID.fromString((String) studentJSON.get(STUDENT_ELECTIVE_CHOICE_IDS));
                long majorProgress = (long) studentJSON.get(STUDENT_MAJOR_PROGRESS);
                UUID currentCoursesIDs = UUID.fromString((String) studentJSON.get(STUDENT_CURRENT_COURSES_IDS));

                // Student constructor need Student class to not be red
                Student student = new Student (username, password, firstname, lastname, classification, completedCreditHours, remainingCreditHours, flag, overallGPA, majorId, minor, FERPA, advisorId, eightSemesterPlan, currentCoursesIDs);
                students.add(student);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

     /**
     * Loads courses from a JSON file.
     * @return A list of Course objects.
     */
    public static ArrayList<Course> loadCourses() {
        ArrayList<Course> courses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONArray coursesJSON = (JSONArray) new JSONParser().parse(reader);

            for (Object courseObj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) courseObj;
                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                String name = (String) courseJSON.get(COURSE_NAME);
                String department = (String) courseJSON.get(COURSE_DEPARTMENT);
                long number = (long) courseJSON.get(COURSE_NUMBER);
                String description = (String) courseJSON.get(COURSE_DESCRIPTION);
                long creditHours = (long) courseJSON.get(COURSE_CREDIT_HOURS);
                // availability !!
                UUID prerequisiteID = UUID.fromString((String) courseJSON.get(COURSE_PREREQUISITES_ID));
                UUID corequisiteID = UUID.fromString((String) courseJSON.get(COURSE_COREQUISITE_ID));

                Course course = new Course(id, name, department, number, description, creditHours,
                 availablity, prerequisiteID, corequisiteID);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }

    /**
     * Loads majors from a JSON file.
     * @return A list of Major objects.
     */
    public static ArrayList<Major> loadMajors() {
        ArrayList<Major> majors = new ArrayList<>();

        
        return majors;
    }

    /**
     * Loads advisors from a JSON file.
     * @return A list of Advisor objects.
     */
    public static ArrayList<Advisor> loadAdvisors() {
        ArrayList<Advisor> advisors = new ArrayList<>();
        return advisors;
    }
}
