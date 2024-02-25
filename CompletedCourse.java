public class CompletedCourse extends Course {
    private String letterGrade;
    private double quialityPoints;

    public CompletedCourse(String letterGrade, double quialityPoints) {
        super(null, "name", "department", "number", "description", 0, null, null, null);
        this.letterGrade = letterGrade;
        this.quialityPoints = quialityPoints;
    }
}
