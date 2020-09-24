/*
Created by: Margaret Donin
Date created: 09/22/20
Date revised:
*/

package ClassRoster.dao;

import ClassRoster.dto.Teacher;
import java.util.List;

public interface TeacherDao {
    Teacher getTeacherById(int id);
    List<Teacher> getAllTeachers();
    Teacher addTeacher(Teacher teacher);
    void updateTeacher(Teacher teacher);
    void deleteTeacherById(int id);

}
