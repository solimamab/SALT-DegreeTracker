import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class DataWriter {

    public static void saveCourses(ArrayList<Course> courses) {
        JSONArray jsonCourses = new JSONArray();
        for (Course course : courses) {
            JSONObject jsonCourse = new JSONObject();
            jsonCourse.put(DataConstants.COURSE_ID, course.getId().toString());
            jsonCourse.put(DataConstants.COURSE_NAME, course.getName());
            jsonCourse.put(DataConstants.COURSE_DEPARTMENT, course.getDepartment());
            jsonCourse.put(DataConstants.COURSE_NUMBER, course.getNumber());
            jsonCourse.put(DataConstants.COURSE_DESCRIPTION, course.getDescription());
            jsonCourse.put(DataConstants.COURSE_CREDIT_HOURS, course.getCreditHours());

            JSONArray prereqIDs = new JSONArray();
            for (UUID prereqID : course.getPrerequisite().keySet()) {
                JSONObject prereqObj = new JSONObject();
                prereqObj.put("id", prereqID.toString());
                prereqObj.put("gradeReq", course.getPrerequisite().get(prereqID));
                prereqIDs.add(prereqObj);
            }
            jsonCourse.put(DataConstants.COURSE_PREREQUISITES_ID, prereqIDs);

            JSONArray coreqIDs = new JSONArray();
            for (UUID coreq : course.getCorequisite()) {
                coreqIDs.add(coreqIDs.toString());
            }
            jsonCourse.put(DataConstants.COURSE_COREQUISITE_ID, coreqIDs);

            jsonCourses.add(jsonCourse);
        }

        try (FileWriter file = new FileWriter(DataConstants.COURSE_FILE_NAME)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveStudentList(ArrayList<Student> students) {
        JSONArray jsonUsers = new JSONArray();
        for (User user : students) {
            JSONObject jsonUser = new JSONObject();
            jsonUser.put(DataConstants.STUDENT_ID, user.getId().toString());
            jsonUser.put(DataConstants.STUDENT_USERNAME, user.getUsername());
            jsonUser.put(DataConstants.STUDENT_PASSWORD, user.getPassword());
            jsonUser.put(DataConstants.STUDENT_FIRSTNAME, user.getFirstName());
            jsonUser.put(DataConstants.STUDENT_LASTNAME, user.getLastName());
            // for future fields

            jsonUsers.add(jsonUser);
        }

        try (FileWriter file = new FileWriter(DataConstants.STUDENT_FILE_NAME)) { // Adjust filename accordingly
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAdvisorList(ArrayList<Advisor> advisors) {
        JSONArray jsonUsers = new JSONArray();
        for (Advisor advisor : advisors) {
            JSONObject jsonAdvisor = new JSONObject();
            jsonAdvisor.put(DataConstants.ADVISOR_ID, advisor.getId().toString());
            jsonAdvisor.put(DataConstants.ADVISOR_USERNAME, advisor.getUsername());
            jsonAdvisor.put(DataConstants.ADVISOR_PASSWORD, advisor.getPassword());
            jsonAdvisor.put(DataConstants.ADVISOR_FIRST_NAME, advisor.getFirstName());
            jsonAdvisor.put(DataConstants.ADVISOR_LAST_NAME, advisor.getLastName());

            jsonUsers.add(jsonAdvisor);
        }

        try (FileWriter file = new FileWriter(DataConstants.ADVISOR_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveCompletedCourses(ArrayList<CompletedCourse> completedCourses) {
        JSONArray jsonCompletedCourses = new JSONArray();
        for (CompletedCourse completedCourse : completedCourses) {
            JSONObject jsonCompletedCourse = new JSONObject();
            jsonCompletedCourse.put(DataConstants.STUDENT_COURSE_ID, completedCourse.getId().toString());
            jsonCompletedCourse.put(DataConstants.STUDENT_LETTER_GRADE, completedCourse.getLetterGrade());
            jsonCompletedCourse.put(DataConstants.STUDENT_QUALITY_POINTS, completedCourse.getqualityPoints());

            jsonCompletedCourses.add(jsonCompletedCourse);
        }

        try (FileWriter file = new FileWriter(DataConstants.STUDENT_FILE_NAME)) {
            file.write(jsonCompletedCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}