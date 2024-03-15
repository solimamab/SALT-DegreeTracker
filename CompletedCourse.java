/**
 * The class for the completed courses a student has taken and the class is able to hold the class information along 
 * with the grade that the student had recieved in the course
 */
public class CompletedCourse extends Course {
    private Grade letterGrade;
    private double qualityPoints;
    
    /**
     * The constructor for the completed course
     * @param course the course that the student completed
     * @param letterGrade the letter grade the student recieved in the course
     */
    public CompletedCourse(Course course, Grade letterGrade) {
        super(course.getId(),course.getName(),course.getDepartment(),course.getNumber(),course.getDescription(),
        course.getCreditHours(),course.getAvailablity(),course.getPrerequisite(),course.getCorequisite());
        this.letterGrade = letterGrade;
        this.qualityPoints = setQualityPoints(course, letterGrade);
    }
    
    /**
    * helper method for quality points based on the USC GPA scale
     * @return the double that represents the amount of quailty points based on grade recieved
    */
    private double setQualityPoints(Course course, Grade grade) {
        double points = 0;
        if (grade.equals(Grade.A))
            points = 4;
        else if (grade.equals(Grade.B_PLUS))
            points = 3.5;
        else if (grade.equals(Grade.B))
            points = 3;
        else if (grade.equals(Grade.C_PLUS))
            points = 2.5;
        else if (grade.equals(Grade.C))
            points = 2;
        else if (grade.equals(Grade.D_PLUS))
            points = 1.5;
        else if (grade.equals(Grade.D))
            points = 1;
        else
            points = 0;
        
        return points * course.getCreditHours();
    }

    /**
     * getter for quality points
     * @return the double that represents the quality points for the course
     */
    public double getqualityPoints()
    {
        return this.qualityPoints;
    }

    /**
     * the getter for the letter grade
     * @return the grade that the student recieved in the course
     */
    public Grade getLetterGrade()
    {
        return this.letterGrade;
    }


}
