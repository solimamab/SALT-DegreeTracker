/**
 * This class represents a course that has been completed and stores the grade received in that class
 */
public class CompletedCourse extends Course {
    private String letterGrade;
    private double qualityPoints;

    /**
     * Constructor for the completed course
     * @param course
     * @param letterGrade
     * @param qualityPoints
     */
    public CompletedCourse(Course course, String letterGrade, double qualityPoints) {
        super(course.getId(),course.getName(),course.getDepartment(),course.getNumber(),course.getDescription(),
        course.getCreditHours(),course.getAvailablity(),course.getPrerequisite(),null);
        this.letterGrade = letterGrade;
        this.qualityPoints = qualityPoints;
    }

    /**
     * Getter for letter Grade
     * @return the letter grade
     */
    public String getLetterGrade()
    {
        return this.letterGrade;
    }

    /**
     * getter for quality points
     * @return the number of quality points
     */
    public double getqualityPoints()
    {
        return this.qualityPoints;
    }
}
