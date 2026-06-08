package Models;


import static Utils.Manager.IdGenerator;
import java.util.*;

public class Course {

    private String courseId;
    private String courseCode;
    private int credit;
    private String name;
    private String description = "";
    private ArrayList<Student> students;

    public Course(String code, String name, int credit){
        this.courseId = IdGenerator(name, 5);
        this.courseCode = code;
        this.credit = credit;
        setName(name);
        this.students = new ArrayList<Student>();

    }

    public void RegisterStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
        }else{
            System.out.println("The Current Student is already register to the course");
        }
    }

    public void DisplayCourse(){
        System.out.println("+--------------------------------------------------+");
        System.out.printf("| %-15s | %-28s |\n", "Field", "Value");
        System.out.println("+--------------------------------------------------+");
        System.out.printf("| %-15s | %-28s |\n", "Course ID", courseId);
        System.out.printf("| %-15s | %-28s |\n", "Course Code", courseCode);
        System.out.printf("| %-15s | %-28s |\n", "Name", name);
        System.out.printf("| %-15s | %-28s |\n", "Credit", credit);
        System.out.printf("| %-15s | %-28s |\n", "Description", description);
        System.out.printf("| %-15s | %-28d |\n", "Students", students.size());
        System.out.println("+--------------------------------------------------+");
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

    public String getDescription(){
        return description;
    }
    public void setDescription(String text){
        if(!description.equals(text)){
            description = text;
        }
    }

    public String getCourseId(){
        return courseId;
    }
    public String getCourseCode(){
        return courseCode;
    }
    public int getCredit(){
        return credit;
    }

    public ArrayList<Student> getStudents(){
        return students;
    }
}
