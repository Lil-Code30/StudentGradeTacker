package Models;

import static Utils.Manager.IdGenerator;
import java.util.ArrayList;

public class Student {
    private String name;
    private String studentId;
    private ArrayList<Course> courses;

    public Student(String name){
        this.studentId = IdGenerator(name, 10);
        setName(name);
        this.courses = new ArrayList<Course>();
    }

    public void DisplayStudent(){
        System.out.println("==============================");
        System.out.println("StudentId: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("------------------------------\n");
        System.out.print("Courses: ");

        for(Course course: courses){
            System.out.print(course.getName() + ", ");
        }
        System.out.println("==============================");
    }

    // getters and setters
    public String getName(){
        return name;
    }

    public void setName(String newName){
        if(!newName.equals(name) && newName.length() > 5){
            name = newName;
        }
    }

    public String getStudentId(){
        return studentId;
    }
    public ArrayList<Course> getCourses(){
        return courses;
    }
}
