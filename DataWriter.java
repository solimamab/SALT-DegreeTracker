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

        
        try (FileWriter file = new FileWriter("json/advisor.json")) {
            file.write(jsonAdvisors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getAdvisorJSON(Advisor advisor) {
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
        try (FileWriter file = new FileWriter("json/course.json")) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCourseJSON(Course course) {
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

        HashMap<UUID, String> prereq_map = course.getPrerequisite();
        JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
        jsonCourse.put(COURSE_PREREQUISITES, prerequisitesJSON);
        ArrayList<UUID> coreq_list = course.getCorequisite();
        JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
        jsonCourse.put(COURSE_COREQUISITES, corequisiteJSON);

        return jsonCourse;
    }

    public static JSONArray getPrerequisiteJSON(HashMap<UUID, String> prerequisites) {
        JSONArray prerequisitesJSON = new JSONArray();
        if (prerequisites != null) {
            for (Entry<UUID, String> entry : prerequisites.entrySet()) {
                JSONArray prereqPair = new JSONArray(); // Each prerequisite is an array [UUID, gradeRequirement]
                prereqPair.add(entry.getKey().toString()); // Convert UUID to String
                prereqPair.add(entry.getValue()); // Grade requirement
                prerequisitesJSON.add(prereqPair);
            }
        }
        return prerequisitesJSON;
    }

    public static JSONArray getCorequisiteJSON(ArrayList<UUID> corequisites) {
        JSONArray corequisitesJSON = new JSONArray();
        if (corequisites != null) { // Check if corequisites is not null
            for (UUID coreq : corequisites) {
                corequisitesJSON.add(coreq.toString()); // Convert UUID to String and add it to JSONArray
            }
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

        try (FileWriter file = new FileWriter("json/students.json")) { //DataConstants.STUDENT_FILE_NAME
            file.write(jsonStudents.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getStudentJSON(Student student) {
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
        jsonStudent.put(STUDENT_MAJOR_PROGRESS, student.getMajorProgress());

        // Handling completedCourses
        JSONArray completedCoursesArray = new JSONArray();
        for (CompletedCourse course : student.getCompletedCourses()) {
            JSONObject completedCourseJSON = new JSONObject();
            completedCourseJSON.put(COURSE_ID, course.getId().toString());
            completedCourseJSON.put(COURSE_NAME, course.getName());
            completedCourseJSON.put(COURSE_DEPARTMENT, course.getDepartment());
            completedCourseJSON.put(COURSE_NUMBER, course.getNumber());
            completedCourseJSON.put(COURSE_DESCRIPTION, course.getDescription());
            completedCourseJSON.put(COURSE_CREDIT_HOURS, String.valueOf(course.getCreditHours())); // Ensuring creditHours is a String
            HashMap<UUID, String> prereq_map = course.getPrerequisite();
            JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
            completedCourseJSON.put(COURSE_PREREQUISITES, prerequisitesJSON);
            ArrayList<UUID> coreq_list = course.getCorequisite();
            JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
            completedCourseJSON.put(COURSE_COREQUISITES, corequisiteJSON);

            // Convert availability from ArrayList to JSONArray
            JSONArray availability = new JSONArray();
            for (Availablity avail : course.getAvailablity()) {
                availability.add(avail.toString());
            }
            completedCourseJSON.put(COURSE_AVAILABILITY, availability);

            
            // Assuming letterGrade is a property of CompletedCourse
            completedCourseJSON.put("letterGrade", course.getLetterGrade().toString());
            completedCoursesArray.add(completedCourseJSON);
            }
        jsonStudent.put("completedCourses", completedCoursesArray);

        // Handling currentCourses similar to completedCourses...
        JSONArray currentCoursesArray = new JSONArray();

        for (Course course : student.getCurrentCourses()) {
            JSONObject courseJSON = new JSONObject();
            courseJSON.put(COURSE_ID, course.getId().toString());
            courseJSON.put(COURSE_NAME, course.getName());
            courseJSON.put(COURSE_DEPARTMENT, course.getDepartment());
            courseJSON.put(COURSE_NUMBER, course.getNumber());
            courseJSON.put(COURSE_DESCRIPTION, course.getDescription());
            courseJSON.put(COURSE_CREDIT_HOURS, String.valueOf(course.getCreditHours())); // Ensuring creditHours is a String
            HashMap<UUID, String> prereq_map = course.getPrerequisite();
            JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
            courseJSON.put(COURSE_PREREQUISITES, prerequisitesJSON);
            ArrayList<UUID> coreq_list = course.getCorequisite();
            JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
            courseJSON.put(COURSE_COREQUISITES, corequisiteJSON);

            JSONArray availability = new JSONArray();
            for (Availablity avail : course.getAvailablity()) {
                availability.add(avail.toString());
            }
            courseJSON.put(COURSE_AVAILABILITY, availability);
            currentCoursesArray.add(courseJSON);
        }
        jsonStudent.put("currentCourses", currentCoursesArray);

        JSONObject eightSemesterPlanJSON = getEightSemesterPlanJSON(student.getEightSemesterPlan());
        jsonStudent.put(STUDENT_EIGHT_SEMESTER_PLAN, eightSemesterPlanJSON);

        return jsonStudent;
    }

    public static JSONObject getEightSemesterPlanJSON(EightSemesterPlan eightSemesterPlan) {
        JSONObject eightSemesterPlanJSON = new JSONObject();
        for (int i = 0; i < eightSemesterPlan.getSemesters().size(); i++) {
            JSONArray semesterCoursesArray = new JSONArray();
            for (Course course : eightSemesterPlan.getSemesters().get(i)) {
                JSONObject courseJSON = new JSONObject();
                courseJSON.put(COURSE_ID, course.getId().toString());
                courseJSON.put(COURSE_NAME, course.getName());
                courseJSON.put(COURSE_DEPARTMENT, course.getDepartment());
                courseJSON.put(COURSE_NUMBER, course.getNumber());
                courseJSON.put(COURSE_DESCRIPTION, course.getDescription());
                courseJSON.put(COURSE_CREDIT_HOURS, String.valueOf(course.getCreditHours())); // Ensuring creditHours is a String
                HashMap<UUID, String> prereq_map = course.getPrerequisite();
                JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
                courseJSON.put(COURSE_PREREQUISITES, prerequisitesJSON);
                ArrayList<UUID> coreq_list = course.getCorequisite();
                JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
                courseJSON.put(COURSE_COREQUISITES, corequisiteJSON);
                
                JSONArray availability = new JSONArray();
                for (Availablity avail : course.getAvailablity()) {
                    availability.add(avail.toString());
                }
                courseJSON.put(COURSE_AVAILABILITY, availability);
                semesterCoursesArray.add(courseJSON);
            }
            eightSemesterPlanJSON.put("semester" + (i + 1), semesterCoursesArray);
        }
        // Handling applicationArea
        JSONArray applicationAreaArray = new JSONArray();
        for (Course course : eightSemesterPlan.getApplicationArea()) {
            JSONObject courseJSON = new JSONObject();
            courseJSON.put("id", course.getId().toString());
            courseJSON.put("name", course.getName());
            courseJSON.put("department", course.getDepartment());
            courseJSON.put("number", course.getNumber());
            courseJSON.put("description", course.getDescription());
            courseJSON.put("creditHours", course.getCreditHours());
            HashMap<UUID, String> prereq_map = course.getPrerequisite();
            JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
            courseJSON.put(COURSE_PREREQUISITES, prerequisitesJSON);
            ArrayList<UUID> coreq_list = course.getCorequisite();
            JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
            courseJSON.put(COURSE_COREQUISITES, corequisiteJSON);
            
            JSONArray availabilityArray = new JSONArray();
            for (Availablity avail : course.getAvailablity()) {
                availabilityArray.add(avail.toString());
            }
            courseJSON.put("availability", availabilityArray);

            // Add prerequisites and corequisites if needed
            // Skipping for simplicity as per the initial setup
            
            applicationAreaArray.add(courseJSON);
        }
        eightSemesterPlanJSON.put("applicationArea", applicationAreaArray);

        // Handling electiveChoices
        JSONArray electiveChoicesArray = new JSONArray();
        for (Course course : eightSemesterPlan.getElectiveChoices()) {
            JSONObject courseJSON = new JSONObject();
            courseJSON.put("id", course.getId().toString());
            courseJSON.put("name", course.getName());
            courseJSON.put("department", course.getDepartment());
            courseJSON.put("number", course.getNumber());
            courseJSON.put("description", course.getDescription());
            courseJSON.put("creditHours", course.getCreditHours());
            HashMap<UUID, String> prereq_map = course.getPrerequisite();
            JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
            courseJSON.put(COURSE_PREREQUISITES, prerequisitesJSON);
            ArrayList<UUID> coreq_list = course.getCorequisite();
            JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
            courseJSON.put(COURSE_COREQUISITES, corequisiteJSON);
            
            JSONArray availabilityArray = new JSONArray();
            for (Availablity avail : course.getAvailablity()) {
                availabilityArray.add(avail.toString());
            }
            courseJSON.put("availability", availabilityArray);

            
            electiveChoicesArray.add(courseJSON);
        }
        eightSemesterPlanJSON.put("electiveChoices", electiveChoicesArray);
    
        return eightSemesterPlanJSON;
    }

    public static void saveMajor() {
        HashMap<UUID, Course> coursesMap = DataLoader.loadCourses();
        ArrayList<Major> majors = DataLoader.loadMajors(coursesMap);
        JSONArray jsonMajors = new JSONArray();
        for (Major major : majors) {
            jsonMajors.add(getMajorJSON(major));
        }

        try (FileWriter file = new FileWriter("tester_major.json")) { //DataConstants.STUDENT_FILE_NAME
            file.write(jsonMajors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getMajorJSON(Major major) {
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
            HashMap<UUID, String> prereq_map = course.getPrerequisite();
            JSONArray prerequisitesJSON = getPrerequisiteJSON(prereq_map);
            requiredCoursesJSON.put(COURSE_PREREQUISITES, prerequisitesJSON);
            ArrayList<UUID> coreq_list = course.getCorequisite();
            JSONArray corequisiteJSON = getCorequisiteJSON(coreq_list);
            requiredCoursesJSON.put(COURSE_COREQUISITES, corequisiteJSON);

            // Convert availability from ArrayList to JSONArray
            JSONArray availability = new JSONArray();
            for (Availablity avail : course.getAvailablity()) {
                availability.add(avail.toString());
            }
            requiredCoursesJSON.put(COURSE_AVAILABILITY, availability);
        }
        jsonMajor.put(MAJOR_REQUIRED_COURSES, requiredCourses);

        EightSemesterPlan defaultPlan = major.getDefaultPlan();
        JSONObject defaultPlanJSON = getEightSemesterPlanJSON(defaultPlan);
        jsonMajor.put(MAJOR_DEFAULT_PLAN, defaultPlanJSON); 
        
        
        return jsonMajor;
    }

    public static void main(String[] args) {
        saveStudents();
    }

}