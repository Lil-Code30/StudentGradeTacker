package Models;

import static Utils.Manager.IdGenerator;

public class StudentCourse {
    private String id;
    private String studentId;
    private String courseId;
    private double grade;

    public StudentCourse(String studentId, String courseId, double grade){
       this.id = IdGenerator("STD_Course", 10);
       this.studentId = studentId;
       this.courseId = courseId;
       this.grade = grade;
    }

    // setters and getters
    public String  getStudentId(){
        return studentId;
    }
    public String getId(){
        return id;
    }

    public String getCourseId(){
        return courseId;
    }

    public double getGrade(){
        return grade;
    }

    public void setGrade(double newGrade){
        if(newGrade >= 0){
            grade = newGrade;
        }
    }
}
