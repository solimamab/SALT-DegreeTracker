import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class DataWriter {

    // Save Advisors to a JSON file
    public static void saveAdvisors(ArrayList<Advisor> advisors) {
        JSONArray jsonAdvisors = new JSONArray();
        for (Advisor advisor : advisors) {
            jsonAdvisors.add(getAdvisorJSON(advisor));
        }

        try (FileWriter file = new FileWriter(DataConstants.ADVISOR_FILE_NAME)) {
            file.write(jsonAdvisors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject jsonAdvisor = new JSONObject();
        jsonAdvisor.put("id", advisor.getUserId().toString());
        jsonAdvisor.put("username", advisor.getUsername());
        jsonAdvisor.put("password", advisor.getPassword());
        jsonAdvisor.put("firstname", advisor.getFirstName());
        jsonAdvisor.put("lastname", advisor.getLastName());

        JSONArray studentIDs = new JSONArray();
        for (UUID studentID : advisor.getStudents()) {
            studentIDs.add(studentID.toString());
        }
        jsonAdvisor.put("studentIDs", studentIDs);

        return jsonAdvisor;
    }

    // Save Courses to a JSON file
    public static void saveCourses(ArrayList<Course> courses) {
        JSONArray jsonCourses = new JSONArray();
        for (Course course : courses) {
            jsonCourses.add(getCourseJSON(course));
        }

        try (FileWriter file = new FileWriter(DataConstants.COURSE_FILE_NAME)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getCourseJSON(Course course) {
        JSONObject jsonCourse = new JSONObject();
        jsonCourse.put("id", course.getId().toString());
        jsonCourse.put("name", course.getName());
        jsonCourse.put("department", course.getDepartment());
        jsonCourse.put("number", course.getNumber());
        jsonCourse.put("description", course.getDescription());
        jsonCourse.put("creditHours", course.getCreditHours());

        JSONArray availability = new JSONArray();
        for (Availablity avail : course.getAvailablity()) { // Corrected typo here
            availability.add(avail.toString());
        }
        jsonCourse.put("availability", availability);

        jsonCourse.put("prerequisiteID", getPrerequisiteJSON(course.getPrerequisite()));
        jsonCourse.put("corequisiteID", getCorequisiteJSON(course.getCorequisite()));

        return jsonCourse;
    }

    private static JSONArray getPrerequisiteJSON(HashMap<UUID, String> prerequisites) {
        JSONArray prereqArray = new JSONArray();
        prerequisites.forEach((key, value) -> {
            JSONObject prereq = new JSONObject();
            prereq.put("id", key.toString());
            prereq.put("gradeReq", value);
            prereqArray.add(prereq);
        });
        return prereqArray;
    }

    private static JSONArray getCorequisiteJSON(ArrayList<UUID> corequisites) {
        JSONArray coreqArray = new JSONArray();
        corequisites.forEach((uuid) -> coreqArray.add(uuid.toString()));
        return coreqArray;
    }

    // Save Students to a JSON file
    public static void saveStudents(ArrayList<Student> students) {
        JSONArray jsonStudents = new JSONArray();
        for (Student student : students) {
            jsonStudents.add(getStudentJSON(student));
        }

        try (FileWriter file = new FileWriter(DataConstants.STUDENT_FILE_NAME)) {
            file.write(jsonStudents.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject getStudentJSON(Student student) {
        JSONObject jsonStudent = new JSONObject();
        jsonStudent.put("id", student.getUserId().toString());
        jsonStudent.put("username", student.getUsername());
        jsonStudent.put("password", student.getPassword());
        jsonStudent.put("firstname", student.getFirstName());
        jsonStudent.put("lastname", student.getLastName());
        jsonStudent.put("classification", student.getClassification().toString());
        jsonStudent.put("completedCreditHours", student.getCompletedCreditHours());
        jsonStudent.put("remainingCreditHours", student.getRemainingCreditHours());
        jsonStudent.put("flag", student.getFlag().toString());
        jsonStudent.put("overallGPA", student.getOverallGPA());
        jsonStudent.put("majorId", student.getMajor().getId().toString());
        jsonStudent.put("minor", student.getMinor());
        jsonStudent.put("FERPA", student.getFEPRA());
        jsonStudent.put("advisorId", student.getAdvisor().getUserId().toString());

        JSONArray completedCoursesArray = new JSONArray();
        for (CompletedCourse cc : student.getCompletedCourses()) {
            JSONObject completedCourseJSON = new JSONObject();
            completedCourseJSON.put("courseId", cc.getId().toString());
            completedCourseJSON.put("letterGrade", cc.getLetterGrade().toString());
            completedCourseJSON.put("qualityPoints", cc.getqualityPoints());
            completedCoursesArray.add(completedCourseJSON);
        }
        jsonStudent.put("completedCourses", completedCoursesArray);

        // Assuming EightSemesterPlan and currentCourses serialization methods are similar and implemented
        jsonStudent.put("eightSemesterPlan", getEightSemesterPlanJSON(student.getEightSemesterPlan()));
        jsonStudent.put("currentCoursesIDs", getCurrentCoursesIDsJSON(student.getCurrentCourses()));

        return jsonStudent;
    }

    private static JSONObject getEightSemesterPlanJSON(EightSemesterPlan eightSemesterPlan) {
        JSONObject planJSON = new JSONObject();
        JSONArray classesInPlanArray = new JSONArray();
        for (Course course : eightSemesterPlan.getClassesInPlan()) {
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

}