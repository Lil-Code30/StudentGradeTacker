package Utils;

import Models.*;
import java.util.*;

public class Manager {

    private final ArrayList<Student> students;
    private final ArrayList<Course> courses;
    private final ArrayList<StudentCourse>  studentCourses;

    public Manager(){
        this.students = new ArrayList<Student>();
        this.courses = new ArrayList<Course>();
        this.studentCourses = new ArrayList<StudentCourse>();
    }

    public void addStudent(Student newStudent){
        students.add(newStudent);
    }

    public void addCourse(Course newCourse){
        courses.add(newCourse);
    }

    public static String IdGenerator(String name, int len){
        String suffix = "SDT_";
        StringBuilder genId = new StringBuilder(suffix + name.substring(0, 4) + "_");

        Random rand = new Random();

        for(int i = 0; i < len; i++){
            genId.append(rand.nextInt(10));
        }

        return genId.toString();
    }

    public void displayAllStudents() {
        System.out.printf(
                "%-10s %-12s %-10s%n",
                "studentId", "Name", "Courses"
        );

        System.out.println(
                "-----------------------------------------------------------------------------------"
        );

        for (Student student: this.students) {
            System.out.printf(
                    "%-10s %-12s %-10d%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getCourses().size()
            );
        }
    }

    public Optional<Student> findStudentById(String studentId){
        return students.stream().filter(st -> st.getStudentId().equals(studentId)).findFirst();
    }

    public Optional<Course>  findCourseById(String courseId){
        return courses.stream().filter(course -> course.getCourseId().equals(courseId)).findFirst();
    }

    public void displayAllCourses() {
        System.out.printf(
                "%-10s %-12s %-25s %-30s %-10s%n",
                "ID", "Code", "Name", "Description", "Students"
        );

        System.out.println(
                "-----------------------------------------------------------------------------------"
        );

        for (Course course : this.courses) {
            System.out.printf(
                    "%-10s %-12s %-25s %-30s %-10d%n",
                    course.getCourseId(),
                    course.getCourseCode(),
                    course.getName(),
                    course.getDescription(),
                    course.getStudents().size()
            );
        }
    }

    public void DisplayStudentReport(Student student){

    }

    // getters and setters
    public ArrayList<Student> getStudents(){
        return students;
    }

    public ArrayList<Course> getCourses(){
        return courses;
    }

    public ArrayList<StudentCourse> getStudentCourses(){
        return studentCourses;
    }
}
