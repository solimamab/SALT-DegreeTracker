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
    protected static final String COURSE_PREREQUISITES = "prerequisites";
    protected static final String COURSE_COREQUISITES = "corequisites";

    /**
     * Major data constants
     */
    protected static final String MAJOR_ID = "id";
    protected static final String MAJOR_NAME = "majorName";
    protected static final String MAJOR_REQUIRED_COURSES = "requiredCourses";
    protected static final String MAJOR_DEFAULT_PLAN = "defaultPlan";
    protected static final String MAJOR_SEMESTER_1 = "semester1";
    protected static final String MAJOR_SEMESTER_2 = "semester2";
    protected static final String MAJOR_SEMESTER_3 = "semester3";
    protected static final String MAJOR_SEMESTER_4 = "semester4";
    protected static final String MAJOR_SEMESTER_5 = "semester5";
    protected static final String MAJOR_SEMESTER_6 = "semester6";
    protected static final String MAJOR_SEMESTER_7 = "semester7";
    protected static final String MAJOR_SEMESTER_8 = "semester8";
    protected static final String MAJOR_APPLICATION_AREA = "applicationArea";
    protected static final String MAJOR_ELECTIVE_CHOICES = "electiveChoices";

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
    protected static final String STUDENT_FILE_NAME = "json/Students.json";
    protected static final String COURSE_FILE_NAME = "json/Course.json";
    protected static final String MAJOR_FILE_NAME = "json/Majors.json";
    protected static final String ADVISOR_FILE_NAME = "json/Advisor.json";
}
