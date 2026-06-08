import Models.*;

public class Main {
    public static void main(String[] args){


        // Creating courses
        Course javaProgramming = new Course(
                "JAV101",
                "Introduction to Java Programming",
                3
        );

        Course webDevelopment = new Course(
                "WEB201",
                "Web Development Fundamentals",
                4
        );

        Course databaseSystems = new Course(
                "DBS301",
                "Database Systems",
                3
        );

        Course dataStructures = new Course(
                "CST202",
                "Data Structures and Algorithms",
                4
        );

        Course softwareEngineering = new Course(
                "SWE401",
                "Software Engineering",
                3
        );

        // Students' Data
        Student student1 = new Student("John Smith");
        Student student2 = new Student("Emma Johnson");
        Student student3 = new Student("Michael Brown");
        Student student4 = new Student("Sophia Davis");
        Student student5 = new Student("William Wilson");
        Student student6 = new Student("Olivia Taylor");
        Student student7 = new Student("James Anderson");
        Student student8 = new Student("Ava Martinez");
        Student student9 = new Student("Benjamin Thomas");
        Student student10 = new Student("Charlotte Moore");

        // setting courses description
        javaProgramming.setDescription(
                "Introduction to object-oriented programming using Java."
        );

        webDevelopment.setDescription(
                "Learn HTML, CSS, JavaScript and responsive web design."
        );

        databaseSystems.setDescription(
                "Design and implementation of relational databases using SQL."
        );

        dataStructures.setDescription(
                "Study of arrays, linked lists, stacks, queues, trees and graphs."
        );

        softwareEngineering.setDescription(
                "Software development lifecycle, design patterns and team collaboration."
        );

        // Registering students to courses

        javaProgramming.RegisterStudent(student1);
        javaProgramming.RegisterStudent(student2);
        javaProgramming.RegisterStudent(student3);

        webDevelopment.RegisterStudent(student2);
        webDevelopment.RegisterStudent(student4);
        webDevelopment.RegisterStudent(student5);

        databaseSystems.RegisterStudent(student1);
        databaseSystems.RegisterStudent(student6);
        databaseSystems.RegisterStudent(student7);

        dataStructures.RegisterStudent(student3);
        dataStructures.RegisterStudent(student8);
        dataStructures.RegisterStudent(student9);

        softwareEngineering.RegisterStudent(student5);
        softwareEngineering.RegisterStudent(student7);
        softwareEngineering.RegisterStudent(student10);

        dataStructures.DisplayCourse();
        student9.DisplayStudent();
    }
}
