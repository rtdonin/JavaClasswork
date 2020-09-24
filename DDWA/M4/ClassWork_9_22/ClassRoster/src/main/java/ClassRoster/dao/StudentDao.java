/*
Created by: Margaret Donin
Date created: 09/22/20
Date revised:
*/

package ClassRoster.dao;

import ClassRoster.dto.Student;
import java.util.List;

public interface StudentDao {
    Student getStudentById(int id);
    List<Student> getAllStudents();
    Student addStudent(Student student);
    void updateStudent(Student student);
    void deleteStudentById(int id);
}
