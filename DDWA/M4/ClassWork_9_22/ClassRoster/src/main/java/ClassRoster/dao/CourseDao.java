/*
Created by: Margaret Donin
Date created: 09/22/20
Date revised:
*/

package ClassRoster.dao;

import ClassRoster.dto.Course;
import ClassRoster.dto.Student;
import ClassRoster.dto.Teacher;
import java.util.List;

public interface CourseDao {
    Course getCourseById(int id);
    List<Course> getAllCourses();
    Course addCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(int id);
    
    List<Course> getCoursesForTeacher(Teacher teacher);
    List<Course> getCoursesForStudent(Student student);
}
