/*
Created by: Margaret Donin
Date created: 05/26/20
Date revised:

THIS IS M3 and is therefore in a new branch
There is no point to copy and paste a bunch
of code so I branched this off to work on M3.
*/

package M2.Summary.classroster.service;

import M2.Summary.classroster.dao.ClassRosterAuditDao;
import M2.Summary.classroster.dao.ClassRosterDao;
import M2.Summary.classroster.dao.ClassRosterPersistenceException;
import M2.Summary.classroster.dto.Student;
import java.util.List;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer{
    
    private ClassRosterDao dao;
    private ClassRosterAuditDao auditDao;
    
    public ClassRosterServiceLayerImpl(ClassRosterDao dao, ClassRosterAuditDao audtiDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }
    
    @Override
    public void createStudent(Student student) throws
            ClassRosterDuplicateIdException,
            ClassRosterDataValidationException,
            ClassRosterPersistenceException {
        // First check if there is already a student
        // associated with the given student's id
        // If so, we're done here -
        // throw a ClassRosterDuplicationsIdException
        if (dao.getStudent(student.getStudentId()) != null) {
            throw new ClassRosterDuplicateIdException(
            "ERROR: Could not create student. StudentId "
            + student.getStudentId()
            + " already exists.");
        }
        
        // Now validate all the fields on the given Student object.
        // This method will throw an
        // exception if any of the validatio nrules are violated.
        validateStudentData(student);
        
        // We passed all out bussiness rules check so go ahead
        // and persist with Student object
        dao.addStudent(student.getStudentId(), student);
        
        // The student was successfully created, now write to the audit log
        auditDao.writeAuditEntry("Student " + student.getStudentId() + " CREATED.");
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterPersistenceException {
        return dao.getAllStudents();
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterPersistenceException {
        return dao.getStudent(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
        Student removedStudent = dao.removeStudent(studentId);
        // Write to audti log
        auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
        return removedStudent;
    }
    
    private void validateStudentData(Student student) throws ClassRosterDataValidationException {
        if (student.getFirstName() == null
                || student.getFirstName().trim().length() == 0
                || student.getLastName() == null
                || student.getLastName().trim().length() == 0
                || student.getCohort() == null
                || student.getCohort().trim().length() == 0) {
                
            throw new ClassRosterDataValidationException(
                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
        }
    }
    
}
