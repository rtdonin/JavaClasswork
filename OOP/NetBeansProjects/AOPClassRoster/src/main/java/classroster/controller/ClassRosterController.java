/*
Created by: Margaret Donin
Date created: 05/10/20
Date revised: 05/26/20 For M3
 */

package classroster.controller;
import classroster.dto.Student;
import classroster.service.ClassRosterDataValidationException;
import classroster.service.ClassRosterDuplicateIdException;
import classroster.service.ClassRosterServiceLayer;
import classroster.ui.ClassRosterView;
import classroster.dao.ClassRosterPersistenceException;
import classroster.ui.UserIO;
import classroster.ui.UserIOConsoleImpl;

import java.util.List;

public class ClassRosterController {
    private UserIO io = new UserIOConsoleImpl();
    private ClassRosterView view;
    private ClassRosterServiceLayer service;
    
    public ClassRosterController(ClassRosterServiceLayer service, ClassRosterView view){
        this.service = service;
        this.view = view;
    }
    
    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        
        try {
            while(keepGoing) {

                menuSelection = getMenuSelection();

                switch(menuSelection) {
                    case 1: listStudents();
                        break;
                    case 2: createStudent();
                        break;
                    case 3: viewStudent();
                        break;
                    case 4: removeStudent();
                        break;
                    case 5: keepGoing = false;
                        break;
                    default: unknownCommand();
                }
            }
            exitMessage();
        } catch (ClassRosterPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }
    
    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }
    
    private void createStudent() throws ClassRosterPersistenceException {
        view.displayCreateStudentBanner();
        boolean hasErrors = false;
        do {
            Student currentStudent = view.getNewStudentInfo();
            try {
                service.createStudent(currentStudent);
                view.displayCreateSuccessBanner();
                hasErrors = false;
            } catch (ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
                hasErrors = true;
                view.displayErrorMessage(e.getMessage());
            }
        } while (hasErrors);
    }
    
    private void listStudents() throws ClassRosterPersistenceException {
        view.displayDisplayAllBanner();
        List<Student> studentList = service.getAllStudents();
        view.displayStudentList(studentList);
    }
    
    private void viewStudent() throws ClassRosterPersistenceException {
        //FIX THIS LATER
        view.displayDisplayAllBanner();
        String studentId = view.getStudentIdChoice();
        Student student = service.getStudent(studentId);
        view.displayStudent(student);
    }
    
    private void removeStudent() throws ClassRosterPersistenceException {
        view.displayRemoveStudentBanner();
        String studentId = view.getStudentIdChoice();
        Student removedStudent = service.removeStudent(studentId);
        view.displayRemoveResult(removedStudent);
        // In the M3 code along they chose to no longer display the removed Student.
        // However I think this was a mistake becasue they then used a view method we didn't create
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }
    
    private void exitMessage() {
        view.displayExitBanner();
    }
}
