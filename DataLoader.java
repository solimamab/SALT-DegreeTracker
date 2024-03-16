import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

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
    * Loads courses from a JSON file.
    * @return A list of Course objects.
    */
    public static HashMap<UUID, Course> loadCourses() {
        HashMap<UUID, Course> courseMap = new HashMap<>();
        
        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONArray coursesJSON = (JSONArray) new JSONParser().parse(reader);
            
            // Step 1: Load all courses first
            for (Object courseObj : coursesJSON) {
                JSONObject courseJSON = (JSONObject) courseObj;
                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                String name = (String) courseJSON.get(COURSE_NAME);
                String department = (String) courseJSON.get(COURSE_DEPARTMENT);
                String number = (String) courseJSON.get(COURSE_NUMBER);
                String description = (String) courseJSON.get(COURSE_DESCRIPTION);
                long creditHours = Long.parseLong((String) courseJSON.get(COURSE_CREDIT_HOURS));
                
                // Parse availability
                JSONArray availabilityJSON = (JSONArray) courseJSON.get(COURSE_AVAILABILITY);
                ArrayList<Availablity> availabilityList = new ArrayList<>();
                for (Object availabilityObj : availabilityJSON) {
                    String availabilityStr = (String) availabilityObj;
                    Availablity availability = Availablity.valueOf(availabilityStr); // Convert string to enum
                    availabilityList.add(availability);
                }                
                
                // Parse prerequisites
                JSONArray prereqArray = (JSONArray) courseJSON.get(COURSE_PREREQUISITES);
                HashMap<UUID, String> prerequisites = new HashMap<>();
                if (prereqArray != null) {
                    for (Object prereqObj : prereqArray) {
                        // Check if prereqObj is indeed an instance of JSONArray
                        if (prereqObj instanceof JSONArray) {
                            JSONArray prereqInnerArray = (JSONArray) prereqObj;
                            if (prereqInnerArray.size() == 2) { // Assuming each inner array has 2 elements
                                String prereqUuidStr = (String) prereqInnerArray.get(0);
                                String gradeReq = (String) prereqInnerArray.get(1);
                                UUID prereqId = UUID.fromString(prereqUuidStr);
                                prerequisites.put(prereqId, gradeReq);
                            }
                        } else {
                            // Log or handle the case where prereqObj is not a JSONArray as expected
                            //System.out.println("Unexpected data type in prerequisites: " + prereqObj.getClass().getName());
                        }
                    }
                }
                
                Course course = new Course(id, name, department, number, description, creditHours, availabilityList, prerequisites, null);
                courseMap.put(id, course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return courseMap;
    }
    
    
    /**
    * Loads students from a JSON file.
    *
    * @param coursesMap A HashMap containing Course objects mapped by their UUIDs.
    * @return A list of Student objects.
    */
    public static ArrayList<Student> loadStudents(HashMap<UUID, Course> coursesMap) {
        ArrayList<Student> students = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader(STUDENT_FILE_NAME);
            JSONArray studentsJSON = (JSONArray) new JSONParser().parse(reader);
            
            for (Object studentObj : studentsJSON) {
                JSONObject studentJSON = (JSONObject) studentObj;
                
                UUID id = UUID.fromString((String) studentJSON.get("id"));
                String username = (String) studentJSON.get("username");
                String password = (String) studentJSON.get("password");
                String firstname = (String) studentJSON.get("firstname");
                String lastname = (String) studentJSON.get("lastname");
                Classification classification = Classification.valueOf((String) studentJSON.get("classification"));
                long completedCreditHours = (long) studentJSON.get("completedCreditHours");
                long remainingCreditHours = (long) studentJSON.get("remainingCreditHours");
                String flag = (String) studentJSON.get("flag");
                double overallGPA = (double) studentJSON.get("overallGPA");
                UUID majorId = UUID.fromString((String) studentJSON.get("majorId"));
                String minor = (String) studentJSON.get("minor");
                boolean FERPA = (boolean) studentJSON.get("FERPA");
                UUID advisorId = UUID.fromString((String) studentJSON.get("advisorId"));
                
                JSONArray completedCoursesJSON = (JSONArray) studentJSON.get("completedCourses");
                ArrayList<CompletedCourse> completedCourses = parseCompletedCourses(completedCoursesJSON, coursesMap);
                
                JSONArray eightSemesterPlanJSON = (JSONArray) studentJSON.get("eightSemesterPlan");
                EightSemesterPlan eightSemesterPlan = parseEightSemesterPlan(eightSemesterPlanJSON, coursesMap);
                
                JSONArray currentCoursesJSON = (JSONArray) studentJSON.get("currentCourses");
                ArrayList<Course> currentCourses = parseCurrentCourses(currentCoursesJSON, coursesMap);
                
                Student student = new Student(id, username, password, firstname, lastname,
                classification, completedCreditHours, remainingCreditHours, flag,
                overallGPA, majorId, minor, FERPA, advisorId, eightSemesterPlan,
                currentCourses, completedCourses, coursesMap);
                students.add(student);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return students;
    }
    
    /**
    * Helper method to parse completedCourses
    * @param completedCoursesJSON
    * @param coursesMap
    * @return
    */
    private static ArrayList<CompletedCourse> parseCompletedCourses(JSONArray completedCoursesJSON, HashMap<UUID, Course> coursesMap) {
        ArrayList<CompletedCourse> completedCourses = new ArrayList<>();
        for (Object courseObj : completedCoursesJSON) {
            JSONObject courseJSON = (JSONObject) courseObj;
            UUID courseId = UUID.fromString((String) courseJSON.get("courseId"));
            Grade letterGrade = Grade.valueOf((String) courseJSON.get("letterGrade"));
            Course course = coursesMap.get(courseId);
            if (course != null) {
                completedCourses.add(new CompletedCourse(course, letterGrade));
            } else {
                System.err.println("Course with ID " + courseId + " not found.");
            }
        }
        return completedCourses;
    }
    
    /**
    * Helper method to parse currentCourses
    * @param currentCoursesJSON
    * @param coursesMap
    * @return
    */
    private static ArrayList<Course> parseCurrentCourses(JSONArray currentCoursesJSON, HashMap<UUID, Course> coursesMap) {
        ArrayList<Course> currentCourses = new ArrayList<>();
        for (Object courseObj : currentCoursesJSON) {
            JSONObject courseJSON = (JSONObject) courseObj;
            UUID courseId = UUID.fromString((String) courseJSON.get("id"));
            Course course = coursesMap.get(courseId);
            if (course != null) {
                currentCourses.add(course);
            } else {
                System.err.println("Course with ID " + courseId + " not found.");
            }
        }
        return currentCourses;
    }
    
    /**
    * Helper method to parse eightSemesterPlan
    * @param eightSemesterPlanJSON
    * @param coursesMap
    * @return
    */
    private static EightSemesterPlan parseEightSemesterPlan(JSONArray eightSemesterPlanJSON, HashMap<UUID, Course> courseMap) {
        EightSemesterPlan eightSemesterPlan = new EightSemesterPlan();
    
        // Assuming there's only one default plan
        JSONObject defaultPlanJSON = (JSONObject) eightSemesterPlanJSON.get(0);
    
        // Parse each semester
        for (int i = 1; i <= 8; i++) {
            JSONArray semesterJSON = (JSONArray) defaultPlanJSON.get("semester" + i);
            ArrayList<Course> semesterCourses = parseCoursesFromJSONArray(semesterJSON, courseMap);
            eightSemesterPlan.setSemesterCourses(i, semesterCourses);
        }
    
        // Parse application area and elective choices
        JSONArray applicationAreaJSON = (JSONArray) defaultPlanJSON.get("applicationArea");
        ArrayList<Course> applicationAreaCourses = parseCoursesFromJSONArray(applicationAreaJSON, courseMap);
        eightSemesterPlan.setApplicationArea(applicationAreaCourses);
    
        JSONArray electiveChoicesJSON = (JSONArray) defaultPlanJSON.get("electiveChoices");
        ArrayList<Course> electiveChoices = parseCoursesFromJSONArray(electiveChoicesJSON, courseMap);
        eightSemesterPlan.setElectiveChoices(electiveChoices);
    
        return eightSemesterPlan;
    }
    
    
    /**
    * Loads majors from a JSON file.
    * @return A list of Major objects.
    */
    public static ArrayList<Major> loadMajors(HashMap<UUID, Course> courseMap) {
        ArrayList<Major> majors = new ArrayList<>();
    
        try {
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONArray majorsJSON = (JSONArray) new JSONParser().parse(reader);
    
            for (Object majorObj : majorsJSON) {
                JSONObject majorJSON = (JSONObject) majorObj;
                UUID id = UUID.fromString((String) majorJSON.get("id"));
                String majorName = (String) majorJSON.get("majorName");
    
                // Parse required courses
                JSONArray requiredCoursesJSON = (JSONArray) majorJSON.get("requiredCourses");
                ArrayList<Course> requiredCourses = parseCoursesFromJSONArray(requiredCoursesJSON, courseMap);
    
                // Parse default plan
                JSONArray defaultPlanJSON = (JSONArray) majorJSON.get("defaultPlan");
                JSONObject defaultPlanObj = (JSONObject) defaultPlanJSON.get(0); // Assuming there's only one default plan
    
                EightSemesterPlan plan = parseDefaultPlan(defaultPlanObj, courseMap);
    
                Major major = new Major(id, majorName, requiredCourses, plan);
                majors.add(major);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return majors;
    }
    
    /**
     * Helper method to parse the default plan.
     */
    private static EightSemesterPlan parseDefaultPlan(JSONObject defaultPlanObj, HashMap<UUID, Course> courseMap) {
        EightSemesterPlan plan = new EightSemesterPlan();
    
        for (int i = 1; i <= 8; i++) {
            String semesterKey = "semester" + i;
            JSONArray semesterJSON = (JSONArray) defaultPlanObj.get(semesterKey);
    
            if (semesterJSON != null) {
                ArrayList<Course> semesterCourses = parseCoursesFromJSONArray(semesterJSON, courseMap);
                plan.setSemesterCourses(i - 1, semesterCourses);
            }
        }
    
        JSONArray applicationAreaJSON = (JSONArray) defaultPlanObj.get("applicationArea");
        JSONArray electiveChoicesJSON = (JSONArray) defaultPlanObj.get("electiveChoices");
    
        if (applicationAreaJSON != null && electiveChoicesJSON != null) {
            ArrayList<Course> applicationArea = parseCoursesFromJSONArray(applicationAreaJSON, courseMap);
            ArrayList<Course> electiveChoices = parseCoursesFromJSONArray(electiveChoicesJSON, courseMap);
    
            plan.setApplicationArea(applicationArea);
            plan.setElectiveChoices(electiveChoices);
        }
    
        return plan;
    }

    /**
     * Helper method to parse courses from JSONArray
     */
    private static ArrayList<Course> parseCoursesFromJSONArray(JSONArray coursesJSON, HashMap<UUID, Course> coursesMap) {
        ArrayList<Course> courses = new ArrayList<>();
        for (Object courseObj : coursesJSON) {
            JSONObject courseJSON = (JSONObject) courseObj;
            UUID courseId = UUID.fromString((String) courseJSON.get("id"));
            Course course = coursesMap.get(courseId);
            if (course != null) {
                courses.add(course);
            } else {
                System.err.println("Course with ID " + courseId + " not found.");
            }
        }
        return courses;
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
    
    public static void main(String[] args) {
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        ArrayList<Advisor> advisors = DataLoader.loadAdvisors();
        ArrayList<Major> majors = DataLoader.loadMajors(coursesMap);
        ArrayList<Student> students = DataLoader.loadStudents(coursesMap);
        
        // // Printing students
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        
        // // Printing courses
        // System.out.println("\nCourses:");
        // for (Course course : coursesMap.values()) {
        //             System.out.println(course.toString());
        // }
            
        // Printing advisors
        System.out.println("\nAdvisors:");
        for (Advisor advisor : advisors) {
            System.out.println(advisor);
        }
            
        // Printing majors
        System.out.println("\nMajors:");
        for (Major major : majors) {
            System.out.println(major);
        }
    }
}