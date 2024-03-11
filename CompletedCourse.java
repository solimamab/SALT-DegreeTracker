public class CompletedCourse extends Course {
    private String letterGrade;
    private double quialityPoints;

    public CompletedCourse(Course course, String letterGrade, double quialityPoints) {
        super(course.getId(),course.getName(),course.getDepartment(),course.getNumber(),course.getDescription(),
        course.getCreditHours(),course.getAvailablity(),course.getPrerequisite(),null);
        this.letterGrade = letterGrade;
        this.quialityPoints = quialityPoints;
    }
}
