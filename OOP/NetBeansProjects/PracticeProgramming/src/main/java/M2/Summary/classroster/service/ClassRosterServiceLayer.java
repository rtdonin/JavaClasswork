/*
Created by: Margaret Donin
Date created: 05/26/20
Date revised:

THIS IS M3 and is therefore in a new branch
There is no point to copy and paste a bunch
of code so I branched this off to work on M3.
*/

package M2.Summary.classroster.service;

import M2.Summary.classroster.dao.ClassRosterPersistenceException;
import M2.Summary.classroster.dto.Student;
import java.util.List;

public interface ClassRosterServiceLayer {
    void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException;
    
    List<Student> getAllStudents() throws
            ClassRosterPersistenceException;
    
    Student getStudent(String studentId) throws
            ClassRosterPersistenceException;
    
    Student removeStudent(String studentId) throws 
            ClassRosterPersistenceException;
}
