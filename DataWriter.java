import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

public class DataWriter extends DataConstants {

    public static void saveAdvisors() {
        UserList userList = UserList.getInstance();
        ArrayList<Advisor> advisors = userList.getAdvisors();
        JSONArray jsonAdvisors = new JSONArray();
        for (Advisor advisor : advisors) {
            JSONObject advisorJSON = getAdvisorJSON(advisor);
            jsonAdvisors.add(advisorJSON);
        }

        
        try (FileWriter file = new FileWriter("tester_advisor.json")) {
            file.write(jsonAdvisors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject jsonAdvisor = new JSONObject();
        jsonAdvisor.put(ADVISOR_ID, advisor.getAdvisorID().toString());
        jsonAdvisor.put(ADVISOR_USERNAME, advisor.getUsername());
        jsonAdvisor.put(ADVISOR_PASSWORD, advisor.getPassword());
        jsonAdvisor.put(ADVISOR_FIRST_NAME, advisor.getFirstName());
        jsonAdvisor.put(ADVISOR_LAST_NAME, advisor.getLastName());

        //Creating the studentIDs JSON array
        JSONArray studentIDs = new JSONArray();
        for (UUID studentId : advisor.getStudents()) { 
            studentIDs.add(studentId.toString());
        }
        jsonAdvisor.put(ADVISOR_STUDENT_IDS, studentIDs);

        return jsonAdvisor;
    }

    // Save Courses to a JSON file
    public static void saveCourses() {
        CourseList courseList = CourseList.getInstance();
        HashMap<UUID, Course> courses = courseList.getAllCourses();
        JSONArray jsonCourses = new JSONArray();
        
        // Iterate through the HashMap values and convert each course to a JSONObject
        for (Course course : courses.values()) {
            jsonCourses.add(getCourseJSON(course));
        }

        // Writing the JSON array to file
        try (FileWriter file = new FileWriter("tester_course.json")) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getCourseJSON(Course course) {
        JSONObject jsonCourse = new JSONObject();
        jsonCourse.put(COURSE_ID, course.getId().toString());
        jsonCourse.put(COURSE_NAME, course.getName());
        jsonCourse.put(COURSE_DEPARTMENT, course.getDepartment());
        jsonCourse.put(COURSE_NUMBER, course.getNumber());
        jsonCourse.put(COURSE_DESCRIPTION, course.getDescription());
        jsonCourse.put(COURSE_CREDIT_HOURS, String.valueOf(course.getCreditHours())); // Ensuring creditHours is a String
        
        // Convert availability from ArrayList to JSONArray
        JSONArray availability = new JSONArray();
        for (Availablity avail : course.getAvailablity()) {
            availability.add(avail.toString());
        }
        jsonCourse.put(COURSE_AVAILABILITY, availability);

        // Prerequisites and corequisites are ignored as per the current requirement
        
        return jsonCourse;
    }

    private static JSONArray getPrerequisiteJSON(HashMap<UUID, String> prerequisites) {
        JSONArray prerequisitesJSON = new JSONArray();
        for (Entry<UUID, String> entry : prerequisites.entrySet()) {
            JSONArray prereqPair = new JSONArray(); // Each prerequisite is an array [UUID, gradeRequirement]
            prereqPair.add(entry.getKey().toString()); // Convert UUID to String
            prereqPair.add(entry.getValue()); // Grade requirement
            prerequisitesJSON.add(prereqPair);
        }
        return prerequisitesJSON;
    }

    private static JSONArray getCorequisiteJSON(ArrayList<UUID> corequisites) {
        JSONArray corequisitesJSON = new JSONArray();
        for (UUID coreq : corequisites) {
            corequisitesJSON.add(coreq.toString()); // Convert UUID to String for each corequisite
        }
        return corequisitesJSON;
    }

    // Save Students to a JSON file
    public static void saveStudents() {
        UserList userList = UserList.getInstance();
        ArrayList<Student> students = userList.getStudents();
        JSONArray jsonStudents = new JSONArray();
        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }

        try (FileWriter file = new FileWriter("tester_students.json")) { //DataConstants.STUDENT_FILE_NAME
            file.write(jsonStudents.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getStudentJSON(Student student) {
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put(STUDENT_ID, student.getUUID().toString());
        jsonStudent.put(STUDENT_USERNAME, student.getUsername());
        jsonStudent.put(STUDENT_PASSWORD, student.getPassword());
        jsonStudent.put(STUDENT_FIRSTNAME, student.getFirstName());
        jsonStudent.put(STUDENT_LASTNAME, student.getLastName());
        jsonStudent.put(STUDENT_CLASSIFICATION, student.getClassification().toString());
        jsonStudent.put(STUDENT_COMPLETED_CREDIT_HOURS, student.getCompletedCreditHours());
        jsonStudent.put(STUDENT_REMAINING_CREDIT_HOURS, student.getRemainingCreditHours());
        jsonStudent.put(STUDENT_FLAG, student.getFlag().toString());
        jsonStudent.put(STUDENT_OVERALL_GPA, student.getOverallGPA());
        jsonStudent.put(STUDENT_MAJOR_ID, student.getMajorID().toString());
        jsonStudent.put(STUDENT_MINOR, student.getMinor());
        jsonStudent.put(STUDENT_FERPA, student.getFEPRA());
        jsonStudent.put(STUDENT_ADVISOR_ID, student.getAdvisor().getAdvisorID().toString());

        JSONArray completedCoursesArray = new JSONArray();
        for (CompletedCourse cc : student.getCompletedCourses()) {
            JSONObject completedCourseJSON = new JSONObject();
            completedCourseJSON.put(STUDENT_COURSE_ID, cc.getId().toString());
            completedCourseJSON.put(STUDENT_LETTER_GRADE, cc.getLetterGrade().toString());
            completedCourseJSON.put("qualityPoints", cc.getqualityPoints());
            completedCoursesArray.add(completedCourseJSON);
        }
        jsonStudent.put(STUDENT_COMPLETED_COURSES, completedCoursesArray);

        // Assuming EightSemesterPlan and currentCourses serialization methods are similar and implemented
        //jsonStudent.put("eightSemesterPlan", getEightSemesterPlanJSON(student.getEightSemesterPlan()));
        //jsonStudent.put("currentCourses", getCurrentCoursesIDsJSON(student.getCurrentCourses()));

        return jsonStudent;
    }

    // this method needs to be reworked bc we changed the structure of the ESM
    private static JSONObject getEightSemesterPlanJSON(EightSemesterPlan eightSemesterPlan) {
        JSONObject planJSON = new JSONObject();
        JSONArray classesInPlanArray = new JSONArray();
        for (Course course : eightSemesterPlan.getAllCoursesInPlan()) {
            JSONObject courseJSON = new JSONObject();
            courseJSON.put("id", course.getId().toString());
            courseJSON.put("name", course.getName());
            classesInPlanArray.add(courseJSON);
        }
        planJSON.put("classesInPlan", classesInPlanArray);
        planJSON.put("majorProgress", eightSemesterPlan.getMajorProgress());
    
        JSONArray electiveChoicesArray = new JSONArray();
        for (Course choice : eightSemesterPlan.getElectiveChoices()) {
            electiveChoicesArray.add(choice.toString()); 
        }
        planJSON.put("electiveChoice", electiveChoicesArray);
    
        return planJSON;
    }

    private static JSONArray getCurrentCoursesIDsJSON(ArrayList<Course> currentCourses) {
        JSONArray coursesArray = new JSONArray();
        for (Course course : currentCourses) {
            coursesArray.add(course.getId().toString());
        }
        return coursesArray;
    }

    public static void saveMajor() {
        MajorList majorList = MajorList.getInstance();
        ArrayList<Major> majors = majorList.get();
        JSONArray jsonStudents = new JSONArray();
        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }

        try (FileWriter file = new FileWriter("tester_students.json")) { //DataConstants.STUDENT_FILE_NAME
            file.write(jsonStudents.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getMajorJSON(Major major) {
        JSONObject jsonMajor = new JSONObject();
        jsonMajor.put(MAJOR_ID, major.getId().toString());
        jsonMajor.put(MAJOR_NAME, major.getMajorName());

        JSONArray requiredCourses = new JSONArray();
        for (Course course : major.getRequiredCourses()) {
            JSONObject requiredCoursesJSON = new JSONObject();
            requiredCoursesJSON.put(COURSE_ID, course.getId().toString());
            requiredCoursesJSON.put(COURSE_ID, course.getId().toString());
            requiredCoursesJSON.put(COURSE_NAME, course.getName());
            requiredCoursesJSON.put(COURSE_DEPARTMENT, course.getDepartment());
            requiredCoursesJSON.put(COURSE_NUMBER, course.getNumber());
            requiredCoursesJSON.put(COURSE_DESCRIPTION, course.getDescription());
            requiredCoursesJSON.put(COURSE_CREDIT_HOURS, String.valueOf(course.getCreditHours())); // Ensuring creditHours is a String
            
            // Convert availability from ArrayList to JSONArray
            JSONArray availability = new JSONArray();
            for (Availablity avail : course.getAvailablity()) {
                availability.add(avail.toString());
            }
            requiredCoursesJSON.put(COURSE_AVAILABILITY, availability);
        }
        jsonMajor.put(MAJOR_REQUIRED_COURSES, requiredCourses);
        
        
        return jsonMajor;
    }

    public static void main(String args[]) {
        // Instantiate UserList, CourseList, and MajorList
        //ArrayList<Student> students = userList.getStudents();
        //saveStudents(students);

        saveStudents();

    }

}