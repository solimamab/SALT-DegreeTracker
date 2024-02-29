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
            for (Course prereq : course.getPrerequisite()) {
                prereqIDs.add(prereq.getId().toString());
            }
            jsonCourse.put(DataConstants.COURSE_PREREQUISITES_ID, prereqIDs);

            JSONArray coreqIDs = new JSONArray();
            for (Course coreq : course.getCorequisite()) {
                coreqIDs.add(coreq.getId().toString());
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


    public static void saveStudentList(ArrayList<User> users) {
        JSONArray jsonUsers = new JSONArray();
        for (User user : users) {
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

}