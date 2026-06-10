import Models.*;
import Utils.Manager;

import java.util.*;

public class Main {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        boolean isRunning = true;

        // create the manager to manage the app
        Manager manager = new Manager();

        do{
            DisplayMenu();
            System.out.print("Enter your choice: ");
            String userInput = input.nextLine();

            switch(userInput){
                case "1":
                    System.out.print("Enter the Student name (The name must be more than 5 characters): ");
                    String studentName = input.nextLine();

                    Student newStudent = new Student(studentName);
                    manager.addStudent(newStudent);
                    newStudent.DisplayStudent();
                    System.out.println("Please Store your StudentId, it will be useful later.");
                    break;

                case "2":
                    System.out.print("Enter the Course code (Example; CS102, Math2000,...): ");
                    String courseCode = input.nextLine();

                    System.out.print("Enter the name of the course (The name must be more than 5 characters): ");
                    String courseName = input.nextLine();

                    System.out.print("Enter the number of credit for this course: ");
                    int courseCredit = input.nextInt();

                    Course newCourse = new Course(courseCode, courseName, courseCredit);
                    manager.addCourse(newCourse);

                    newCourse.DisplayCourse();
                    break;

                case "3":
                    if(manager.getStudents().isEmpty()){
                        System.out.println("No Student Found. Please Create Students (at option 1) before using this option.");
                        break;
                    }

                    manager.displayAllStudents();
                    System.out.println("______________________________________________");

                    System.out.print("Enter the StudentId: ");
                    String studentId = input.nextLine();

                   if( manager.findStudentById(studentId).isPresent()){
                       if(manager.getCourses().isEmpty()){
                           System.out.println("No Courses Found. Please Create courses (at option 2) before using this option");
                           break;
                       }
                       manager.displayAllCourses();

                       String id = "";

                       do{
                           System.out.print("Enter the course Id: ");
                           id = input.nextLine();

                       }while(manager.findCourseById(id).isEmpty());

                       Course targetCourse = manager.findCourseById(id).get();

                       targetCourse.RegisterStudent(manager.findStudentById(studentId).get());

                       System.out.println("Student successfully registered to the course " + targetCourse.getName());

                   }else{
                       System.out.println("Student doesn't exist in app.");
                   }
                    break;

                case "4":
                case "5":
                case "6":
                    System.out.println("This option is not yet implemented");
                    break;

                case "7":
                    if(manager.getStudents().isEmpty()){
                        System.out.println("0 Student Found");
                    }else{
                        manager.displayAllStudents();
                    }
                    break;

                case "8":
                    if(manager.getCourses().isEmpty()){
                       System.out.println("0 Course Found");
                    }else{
                        manager.displayAllCourses();
                    }
                    break;

                case "0":
                    isRunning = false;
                    System.out.println("Thanks for using the app, see you next time. Bye!!!");
                    break;
                default:
                    System.out.println("The option entered is not valid, please try again.");
            }

        }while(isRunning);
    }

    public static void DisplayMenu(){
        System.out.println("\n=================================");
        System.out.println("    STUDENT GRADE TRACKER");
        System.out.println("=================================");
        System.out.println("1. Add Student");
        System.out.println("2. Add Course");
        System.out.println("3. Register a student to a course");
        System.out.println("4. Add Grade");
        System.out.println("5. Calculate Average");
        System.out.println("6. View Student Report");
        System.out.println("7. Display All Students");
        System.out.println("8. Display All Courses");
        System.out.println("0. Exit");
        System.out.println("=================================");
    }
}
