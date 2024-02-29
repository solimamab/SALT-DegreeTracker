/**
 * Data constants class that defines data constants from json files
 * @author abhinavk
 */
public class DataConstants {

    /**
     * Student data constants
     */
    protected static final String STUDENT_ID = "id";
    protected static final String STUDENT_USERNAME = "username";
    protected static final String STUDENT_PASSWORD = "password";
    protected static final String STUDENT_FIRSTNAME = "firstname";
    protected static final String STUDENT_LASTNAME = "lastname";
    protected static final String STUDENT_CLASSIFICATION = "classification";
    protected static final String STUDENT_COMPLETED_CREDIT_HOURS = "completedCreditHours";
    protected static final String STUDENT_REMAINING_CREDIT_HOURS = "remainingCreditHours";
    protected static final String STUDENT_FLAG = "flag";
    protected static final String STUDENT_OVERALL_GPA = "overallGPA";
    protected static final String STUDENT_MAJOR_ID = "majorId";
    protected static final String STUDENT_MINOR = "minor";
    protected static final String STUDENT_FERPA = "FERPA";
    protected static final String STUDENT_ADVISOR_ID = "advisorId";
    protected static final String STUDENT_COMPLETED_COURSES = "completedCourses";
    protected static final String STUDENT_COURSE_ID = "courseId";
    protected static final String STUDENT_LETTER_GRADE = "letterGrade";
    protected static final String STUDENT_QUALITY_POINTS = "quialityPoints";
    protected static final String STUDENT_EIGHT_SEMESTER_PLAN = "eightSemesterPlan";
    protected static final String STUDENT_CLASSES_IN_PLAN_IDS = "classesInPlanIDs";
    protected static final String STUDENT_APPLICATION_AREA_IDS = "applicationAreaIDs";
    protected static final String STUDENT_ELECTIVE_CHOICE_IDS = "electiveChoiceIDs";
    protected static final String STUDENT_MAJOR_PROGRESS = "majorProgress";
    protected static final String STUDENT_CURRENT_COURSES_IDS = "currentCoursesIDs";

    /**
     * Course data constants
     */
    protected static final String COURSE_ID = "id";
    protected static final String COURSE_NAME = "name";
    protected static final String COURSE_DEPARTMENT = "department";
    protected static final String COURSE_NUMBER = "number";
    protected static final String COURSE_DESCRIPTION = "description";
    protected static final String COURSE_CREDIT_HOURS = "creditHours";
    protected static final String COURSE_AVAILABILITY = "availability";
    protected static final String COURSE_PREREQUISITES_ID = "prerequisiteID";
    protected static final String COURSE_COREQUISITE_ID = "corequisiteID";

    /**
     * Major data constants
     */
    protected static final String MAJOR_ID = "id";
    protected static final String MAJOR_NAME = "majorName";
    protected static final String MAJOR_REQUIRED_COURSE_IDS = "requiredCoursesIDs";
    protected static final String MAJOR_DEFAULT_PLAN = "DefaultPlan";
    protected static final String MAJOR_CLASSES_IN_PLAN_IDS = "classesInPlanIDs";
    protected static final String MAJOR_APPLICATION_AREAS_IDS = "applicationAreaIDs";
    protected static final String MAJOR_ELECTIVE_CHOICE_IDS = "electiveChoiceIDs";

    /**
     * Advisor data constants
     */
    protected static final String ADVISOR_ID = "id";
    protected static final String ADVISOR_USERNAME = "username";
    protected static final String ADVISOR_PASSWORD = "password";
    protected static final String ADVISOR_FIRST_NAME = "firstname";
    protected static final String ADVISOR_LAST_NAME = "lastname";
    protected static final String ADVISOR_STUDENT_IDS = "studentIDs";

    /**
     * File paths
     */
    protected static final String STUDENT_FILE_NAME = "json/students.json";
    protected static final String COURSE_FILE_NAME = "json/courses.json";
    protected static final String MAJOR_FILE_NAME = "json/majors.json";
    protected static final String ADVISOR_FILE_NAME = "json/advisors.json";
}
