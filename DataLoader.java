import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
* Loads data from JSON files
* @author abhinavk
*/
public class DataLoader extends DataConstants {
    
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
                
                // Parse completedCourses
                JSONArray completedCoursesJSON = (JSONArray) studentJSON.get(STUDENT_COMPLETED_COURSES);
                List<CompletedCourse> completedCourses = new ArrayList<>();
                for (Object courseObj : completedCoursesJSON) {
                    JSONObject courseJSON = (JSONObject) courseObj;
                    String courseId = (String) courseJSON.get(STUDENT_COURSE_ID);
                    Grade letterGrade = (Grade) courseJSON.get(STUDENT_LETTER_GRADE);
                    double qualityPoints = (double) courseJSON.get(STUDENT_QUALITY_POINTS);
                    
                    Course course = getCourseById(courseId);
                    completedCourses.add(new CompletedCourse(course, letterGrade));
                }
                
                // Parse eight-semester plan
                JSONObject eightSemesterPlanJSON = (JSONObject) studentJSON.get(STUDENT_EIGHT_SEMESTER_PLAN);
                JSONArray classesInPlanIDsJSON = (JSONArray) eightSemesterPlanJSON.get(STUDENT_CLASSES_IN_PLAN_IDS);
                ArrayList<Course> classesInPlan = new ArrayList<>();
                for (Object classIdObj : classesInPlanIDsJSON) {
                    String classId = (String) classIdObj;
                    Course course = getCourseById(classId);
                    classesInPlan.add(course);
                }
                
                ApplicationArea applicationArea = new ApplicationArea(classesInPlan); // Simplified assumption
                ArrayList<ElectiveChoices> electiveChoices = new ArrayList<>(); // Needs adjustments
                double majorProgress = (double) eightSemesterPlanJSON.get(STUDENT_MAJOR_PROGRESS);
                EightSemesterPlan eightSemesterPlan = new EightSemesterPlan(classesInPlan);
                UUID currentCoursesIDs = UUID.fromString((String) studentJSON.get(STUDENT_CURRENT_COURSES_IDS));
                
                // Student constructor need Student class to not be red
                Student student = new Student (username, password, firstname, lastname, classification, completedCreditHours, remainingCreditHours,
                flag, overallGPA, majorId, minor, FERPA, advisorId, eightSemesterPlan, currentCoursesIDs, completedCourses);
                students.add(student);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return students;
    }
    
    // Placeholder for getCourseById method
    private static Course getCourseById(String courseId) {
        return null; // Placeholder return
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
            
            // Temporary map to hold courses by their ID for easy lookup
            HashMap<UUID, Course> courseMap = new HashMap<>();
            
            // First pass: create all courses without prerequisites and corequisites
            for (Object courseObj : coursesJSON) {
                // Parse course information, excluding prerequisites and corequisites
                JSONObject courseJSON = (JSONObject) courseObj;
                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                String name = (String) courseJSON.get(COURSE_NAME);
                String department = (String) courseJSON.get(COURSE_DEPARTMENT);
                String number = (String) courseJSON.get(COURSE_NUMBER);
                String description = (String) courseJSON.get(COURSE_DESCRIPTION);
                long creditHours = (long) courseJSON.get(COURSE_CREDIT_HOURS);
                
                // Parse availability
                Availablity availabilityJSON = (Availablity) courseJSON.get(COURSE_AVAILABILITY);
                
                Course course = new Course(id, name, department, number, description, creditHours, availabilityJSON, null, null);
                courseMap.put(course.getId(), course);
            }
            
            // Second pass: update courses with prerequisites and corequisites
            for (Object courseObj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) courseObj;
                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                Course course = courseMap.get(id);
                
                // Handle prerequisites
                Object prereqObj = courseJSON.get(COURSE_PREREQUISITES_ID);
                if (prereqObj instanceof JSONArray) {
                    HashMap<UUID, String> prerequisites = new HashMap<>();
                    for (Object item : (JSONArray) prereqObj) {
                        // Assume format is ["UUID", "gradeReq"]
                        String uuidStr = (String) ((JSONArray) item).get(0);
                        String gradeReq = (String) ((JSONArray) item).get(1);
                        prerequisites.put(UUID.fromString(uuidStr), gradeReq);
                    }
                    course.setPrerequisite(prerequisites);
                }
                
                // Handle corequisites
                Object coreqObj = courseJSON.get(COURSE_COREQUISITE_ID);
                if (coreqObj instanceof JSONArray) {
                    ArrayList<UUID> corequisites = new ArrayList<>();
                    for (Object item : (JSONArray) coreqObj) {
                        String uuidStr = (String) item;
                        corequisites.add(UUID.fromString(uuidStr));
                    }
                    course.setCorequisite(corequisites); // need to handle/fix this still
                } else {
                    // No corequisites
                    course.setCorequisite(null);
                }
            }
            // Return the courses as a list
            return new ArrayList<>(courseMap.values());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courses;
    }
    
    // Helper method to parse UUID from JSON value
    private static UUID parseUUID(Object value) {
        if (value == null || value.toString().equals("None")) {
            return null;
        }
        return UUID.fromString(value.toString());
    }   
    
    /**
    * Loads majors from a JSON file.
    * @return A list of Major objects.
    */
    public static ArrayList<Major> loadMajors() {
        ArrayList<Major> majors = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONArray majorsJSON = (JSONArray) new JSONParser().parse(reader);
            
            for (Object majorObj : majorsJSON) {
                JSONObject majorJSON = (JSONObject) majorObj;
                UUID id = UUID.fromString((String) majorJSON.get(MAJOR_ID));
                String majorName = (String) majorJSON.get(MAJOR_NAME);
                
                // Parse requiredCoursesIDs
                JSONArray requiredCoursesIDsJSON = (JSONArray) majorJSON.get(MAJOR_REQUIRED_COURSE_IDS);
                ArrayList<UUID> requiredCoursesIDs = new ArrayList<>();
                for (Object courseIDObj : requiredCoursesIDsJSON) {
                    requiredCoursesIDs.add(UUID.fromString((String) courseIDObj));
                }
                
                // Parse DefaultPlan
                JSONArray defaultPlanJSON = (JSONArray) majorJSON.get(MAJOR_DEFAULT_PLAN);
                ArrayList<EightSemesterPlan> defaultPlan = new ArrayList<>();
                for (Object planObj : defaultPlanJSON) {
                    JSONObject planJSON = (JSONObject) planObj;
                    JSONArray classesInPlanIDsJSON = (JSONArray) planJSON.get(MAJOR_CLASSES_IN_PLAN_IDS);
                    JSONArray applicationAreaIDsJSON = (JSONArray) planJSON.get(MAJOR_APPLICATION_AREAS_IDS);
                    JSONArray electiveChoiceIDsJSON = (JSONArray) planJSON.get(MAJOR_ELECTIVE_CHOICE_IDS);
                    
                    ArrayList<UUID> classesInPlanIDs = new ArrayList<>();
                    for (Object classIDObj : classesInPlanIDsJSON) {
                        classesInPlanIDs.add(UUID.fromString((String) classIDObj));
                    }
                    
                    ArrayList<UUID> applicationAreaIDs = new ArrayList<>();
                    for (Object areaIDObj : applicationAreaIDsJSON) {
                        applicationAreaIDs.add(UUID.fromString((String) areaIDObj));
                    }
                    
                    ArrayList<UUID> electiveChoiceIDs = new ArrayList<>();
                    for (Object choiceIDObj : electiveChoiceIDsJSON) {
                        electiveChoiceIDs.add(UUID.fromString((String) choiceIDObj));
                    }
                    
                    EightSemesterPlan plan = new EightSemesterPlan(classesInPlanIDs, applicationAreaIDs, electiveChoiceIDs);
                    defaultPlan.add(plan);
                }
                
                // Create Major object
                Major major = new Major(id, majorName, requiredCoursesIDs, defaultPlan);
                majors.add(major);
            }
            
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return majors;
    }
    
    /**
    * Loads advisors from a JSON file.
    * @return A list of Advisor objects.
    */
    public static ArrayList<Advisor> loadAdvisors() {
        ArrayList<Advisor> advisors = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(ADVISOR_FILE_NAME);
            JSONArray advisorsJSON = (JSONArray) new JSONParser().parse(reader);
            
            for (Object advisorObj : advisorsJSON) {
                JSONObject advisorJSON = (JSONObject) advisorObj;
                UUID id = UUID.fromString((String) advisorJSON.get(ADVISOR_ID));
                String username = (String) advisorJSON.get(ADVISOR_USERNAME);
                String password = (String) advisorJSON.get(ADVISOR_PASSWORD);
                String firstname = (String) advisorJSON.get(ADVISOR_FIRST_NAME);
                String lastname = (String) advisorJSON.get(ADVISOR_LAST_NAME);
                
                // Parse student IDs
                JSONArray studentIDsJSON = (JSONArray) advisorJSON.get(ADVISOR_STUDENT_IDS);
                ArrayList<UUID> studentIDs = new ArrayList<>();
                for (Object studentIDObj : studentIDsJSON) {
                    studentIDs.add(UUID.fromString((String) studentIDObj));
                }
                
                // Create Advisor object
                Advisor advisor = new Advisor(id, username, password, firstname, lastname, studentIDs);
                advisors.add(advisor);
            }
            
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return advisors;
    }
}
