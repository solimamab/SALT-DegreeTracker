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
    public CompletedCourse(Course course, String letterGrade) {
        super(course.getId(),course.getName(),course.getDepartment(),course.getNumber(),course.getDescription(),
        course.getCreditHours(),course.getAvailablity(),course.getPrerequisite(),null);
        this.letterGrade = letterGrade;
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

    /**
     * Setter for quality points based on the USC GPA scale
     */
    public void setQualityPoints()
    {
        double points = 0;
        if (letterGrade.equalsIgnoreCase("A"))
            points = 4;
        else if (letterGrade.equalsIgnoreCase("B+"))
            points = 3.5;
        else if (letterGrade.equalsIgnoreCase("B"))
            points = 3;
        else if (letterGrade.equalsIgnoreCase("C+"))
            points = 2.5;
        else if (letterGrade.equalsIgnoreCase("C"))
            points = 2;
        else if (letterGrade.equalsIgnoreCase("D+"))
            points = 1.5;
        else if (letterGrade.equalsIgnoreCase("D"))
            points = 1;
        else
            points = 0;
        
        this.qualityPoints = points * super.getCreditHours();
    }
}
