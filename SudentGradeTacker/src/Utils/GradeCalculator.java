package Utils;

import Models.Course;
import Models.StudentCourse;
import java.util.*;

public class GradeCalculator {

    public static double calculateAverage(ArrayList<StudentCourse> studentCourses, String studentId){
        double gradeSum = 0;
        int len = 0;

        for(StudentCourse stCourse: studentCourses){
            if(stCourse.getStudentId().equals(studentId)){
                gradeSum += stCourse.getGrade();
                len++;
            }
        }

        return (gradeSum/len);
    }

    /*
    * The U.S. commonly uses a 4.0 GPA scale with plus/minus distinctions.
        A+: 97–100% (4.3 GPA)
        A: 93–96% (4.0 GPA)
        A-: 90–92% (3.7 GPA)
        B+: 87–89% (3.3 GPA)
        B: 83–86% (3.0 GPA)
        B-: 80–82% (2.7 GPA)
        C+: 77–79% (2.3 GPA)
        C: 73–76% (2.0 GPA)
        C-: 70–72% (1.7 GPA)
        D+: 67–69% (1.3 GPA)
        D: 63–66% (1.0 GPA)
        D-: 60–62% (0.7 GPA)
    * */
    public static String calculateLetterGrade(double grade){
       if( grade >= 97){
           return "A+";
       }else if (grade >= 93 && grade <= 96){
           return "A";
       }else if (grade >= 90 && grade <= 92){
           return "A-";
       }else if (grade >= 87 && grade <= 89){
           return "B+";
       }else if (grade >= 83 && grade <= 86){
           return "B";
       }else if (grade >= 80 && grade <= 82){
           return "B-";
       }else if (grade >= 77 && grade <= 79){
           return "C+";
       }else if (grade >= 73 && grade <= 76){
           return "C";
       }else if (grade >= 70 && grade <= 72){
           return "C-";
       }else if (grade >= 67 && grade <= 69){
           return "D+";
       }else if (grade >= 63 && grade <= 66){
           return "D";
       }else if (grade >= 60 && grade <= 62){
           return "D-";
       }else{
           return "F";
       }
    }

    public double calculateGPA(ArrayList<StudentCourse> studentCourses, String studentId, ArrayList<Course> courses){
        // summation(Grade points * credit) / totalCredits

        /*
        A+: (4.3 GPA), A: (4.0 GPA), A-:(3.7 GPA), B+:(3.3 GPA)
        B: (3.0 GPA), B-:(2.7 GPA)
        C+: (2.3 GPA)
        C:(2.0 GPA)
        C-: (1.7 GPA)
        D+:(1.3 GPA)
        D: (1.0 GPA)
        D-: (0.7 GPA)
        */
        double totalCredits = 0;
        double sumGradePoints = 0;

        for(StudentCourse stCourse: studentCourses){
            if(stCourse.getStudentId().equals(studentId)){
                String letterGrade = calculateLetterGrade(stCourse.getGrade());
                Optional<Models.Course> currentCourse = courses.stream().filter(item -> item.getCourseId().equals(stCourse.getCourseId())).findFirst();
                int currentCredit = currentCourse.isPresent() ? currentCourse.get().getCredit() : 0;

                totalCredits += currentCredit;

                switch (letterGrade){
                    case "A+":
                        sumGradePoints += (4.3 * currentCredit);
                        break;
                    case "A":
                        sumGradePoints += (4.0 * currentCredit);
                        break;
                    case "A-":
                        sumGradePoints += (3.7 * currentCredit);
                        break;
                    case "B+":
                        sumGradePoints += (3.3 * currentCredit);
                        break;
                    case "B":
                        sumGradePoints += (3.0 * currentCredit);
                        break;
                    case "B-":
                        sumGradePoints += (2.7 * currentCredit);
                        break;
                    case "C+":
                        sumGradePoints += (2.3 * currentCredit);
                        break;
                    case "C":
                        sumGradePoints += (2.0 * currentCredit);
                        break;
                    case "C-":
                        sumGradePoints += (1.7 * currentCredit);
                        break;
                    case "D+":
                        sumGradePoints += (1.3 * currentCredit);
                        break;
                    case "D":
                        sumGradePoints += (1.0 * currentCredit);
                        break;
                    case "D-":
                        sumGradePoints += (0.7 * currentCredit);
                        break;
                    default:
                        sumGradePoints += (0.0 * currentCredit);
                }
            }
        }

        return sumGradePoints / totalCredits;
    }
}
