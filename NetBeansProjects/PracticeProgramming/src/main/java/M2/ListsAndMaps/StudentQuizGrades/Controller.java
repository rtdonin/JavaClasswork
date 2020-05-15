/*
Created by: Margaret Donin
Date created: 05/14/20
Date revised:
*/

package M2.ListsAndMaps.StudentQuizGrades;

import M2.ListsAndMaps.UserIOClassLab.UserIO;
import M2.ListsAndMaps.UserIOClassLab.UserIOImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Controller {
    private UserIO io = new UserIOImpl();
    private StudentQuizGradesUI ui;
    private StudentQuizGradesDao dao;
    
    public Controller(StudentQuizGradesDao dao, StudentQuizGradesUI ui){
        this.dao = dao;
        this.ui = ui;
    }

    public void run() {
        boolean keepGoing = true;
        
        while(keepGoing) {
            int menuSelection = getMenuSelection();
            switch(menuSelection) {
                case 1: listAllStudents();
                    break;
                case 2: addStudent();
                    break;
                case 3: removeStudent();
                    break;
                case 4: viewStudentQuizGrades();
                    break;
                case 5: viewStudentQuizAverage();
                    break;
                case 6: viewClassQuizAverage();
                    break;
                case 7: viewStudentsWithHighestGrade();
                    break;
                case 8: viewStudentWithLowestGrade();
                    break;
                case 9: keepGoing = false;
                    break;
                default: unknownCommand();   
            }
        }
        ui.goodBye();
    }
    
    private int getMenuSelection() {
        return ui.printAndGetMenuSelection();
    }
    
    private void listAllStudents() {
        ui.displayDisplayAllBanner();
        Map<String, String> studentData = dao.getAllStudents();
        ui.displayStudentList(studentData);
        ui.hitEnter();
    }
    
    private void addStudent() {
        ui.displayAddStudentBanner();
        String newStudentName = ui.getNewStudentName();
        List<Integer> newStudentGrades = new ArrayList<>();
        boolean keepGoing = true;
        
        while(keepGoing) {
            int newGrade = ui.getNewStudentGrades();
            newStudentGrades.add(newGrade);
            keepGoing = ui.getKeepAddingGrades().equals("y");
        }
        
        dao.addStudent(newStudentName, newStudentGrades);
        ui.displayAddStudentBannerSuccess();
        ui.hitEnter();
    }
    
    private void removeStudent() {
        ui.displayRemoveStudentBanner();
        String aStudent = ui.getStudentName();
        dao.removeStudent(aStudent);
        ui.displayRemoveStudentBannerSuccess();
        ui.hitEnter();
    }
    
    private void viewStudentQuizGrades() {
        ui.displayViewStudentQuizGradesBanner();
        String aStudent = ui.getStudentName();
        String grades = dao.getStudentQuizGrades(aStudent);
        ui.displayStudentQuizGrades(aStudent, grades);
        ui.hitEnter();
    }

    private void viewStudentQuizAverage() {
        ui.displayViewStudentQuizAverageBanner();
        String aStudent = ui.getStudentName();
        double grades = dao.getStudentQuizAverage(aStudent);
        ui.displayStudentQuizAverage(aStudent, grades);
        ui.hitEnter();
    }
    
    private void viewClassQuizAverage() {
        ui.displayViewClassQuizAverageBanner();
        double classAverage = dao.getClassAverage();
        ui.displayClassAverage(classAverage);
        ui.hitEnter();    
    }
    
    private void viewStudentsWithHighestGrade() {
        ui.displayStudentsWithHighestGradeBanner();
        Set<String> students = dao.getStudentsWithHighestGrades();
        ui.displayStudentsWithHighestOrLowestGrade(students);
        ui.hitEnter();
    }
    
    private void viewStudentWithLowestGrade() {
        ui.displayStudentsWithLowestGradeBanner();
        Set<String> students = dao.getStudentsWithLowestGrades();
        ui.displayStudentsWithHighestOrLowestGrade(students);
        ui.hitEnter();
    }

    private void unknownCommand() {
        ui.unknownCommandBanner();
    }
}
