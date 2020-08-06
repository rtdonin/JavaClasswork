/*
Created by: Margaret Donin
Date created: 05/14/20
Date revised:
*/

package M2.ListsAndMaps.StudentQuizGrades;

import M2.ListsAndMaps.UserIOClassLab.UserIO;
import java.util.Map;
import java.util.Set;

public class StudentQuizGradesUI {
    private UserIO io;
    
    public StudentQuizGradesUI (UserIO io) {
        this.io = io;
    }
   
    public int printAndGetMenuSelection(){
        io.print("=== Menu Options: ===");
        io.print("1. List all students");
        io.print("2. Add student");
        io.print("3. Remove student");
        io.print("4. View student's quiz scores");
        io.print("5. View student's quiz average");
        io.print("6. View classes's quiz average");
        io.print("7. View student with the highest quiz score.");
        io.print("8. View student with the lowest quiz score");
        io.print("9. Exit menu");
        io.print("");
        
        return io.readInt("Choose one of the above options.", 1, 9);
    }
    
    public void displayDisplayAllBanner() {
        io.print("=== Display All Students ===");
    }
    
    public void displayStudentList(Map<String, String> studentData) {
        Set<String> studentKey = studentData.keySet();
        
        for(String s : studentKey) {
            io.print(s + ": " + studentData.get(s));
        }
    }
    
    public void displayAddStudentBanner() {
        io.print("=== Add Student ===");
    }
    
    public String getNewStudentName() {
        return io.readString("Enter new student name:");
    }
    
    public Integer getNewStudentGrades() {
        return io.readInt("Enter new grade ");
    }
    
    public String getKeepAddingGrades() {
        return io.readString("Add another grade? (y/n)");
    }
    
    public void displayAddStudentBannerSuccess() {
        io.print("=== Add Student Success ===");
    }
    
    public void displayRemoveStudentBanner() {
        io.print("=== Remove Student ===");
    }
    
    public String getStudentName() {
        return io.readString("Please enter the student name.");
    }
    
    public void displayRemoveStudentBannerSuccess() {
        io.print("=== Remove Student Success ===");
    }
    
    public void displayViewStudentQuizGradesBanner() {
        io.print("=== View Student Grades ===");
    }

    public void displayStudentQuizGrades(String student, String grades) {
        io.print(student + " has grades: " + grades);
    }
    
    public void displayViewStudentQuizAverageBanner() {
        io.print("=== View Student Quiz Average ===");
    }

    public void displayStudentQuizAverage(String student, double grade) {
        io.print(student + " has a " + grade + " average.");
    }
    
    public void displayViewClassQuizAverageBanner() {
        io.print("=== View Class Quiz Average ===");
    }
    
    public void displayClassAverage(double classAverage) {
        io.print("The class has a " + classAverage + " average.");
    }

    public void displayStudentsWithHighestGradeBanner() {
        io.print("=== Students with Highest Grade ===");
    }

    public void displayStudentsWithHighestOrLowestGrade(Set studentsSet) {
        Set<String> students = studentsSet;
        // doesn't want to build or compile because it doesn't know that
        // studentsSet is a set of Strings. The alternative is to treat
        // the elements in the set as an Object and cast it to a String
        // and then print it.
        
        for(String s : students) {
            io.print(s);
        }
    }

    public void displayStudentsWithLowestGradeBanner() {
        io.print("=== Students with Lowest Grade ===");
    }

    public void hitEnter() {
        io.readString("Hit enter to continue.");
    }
    
    public void goodBye() {
        io.print("=== GoodBye! ===");
    }
      
    public void unknownCommandBanner() {
        io.print("=== Unknown Command ===");
    }
}