/*
Created by: Margaret Donin
Date created: 09/22/20
Date revised:
*/

package ClassRoster.controller;

import ClassRoster.dao.CourseDao;
import ClassRoster.dao.StudentDao;
import ClassRoster.dao.TeacherDao;
import ClassRoster.dto.Student;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

   @Autowired
   TeacherDao teacherDao;

   @Autowired
   StudentDao studentDao;

   @Autowired
   CourseDao courseDao;
   
   @GetMapping("students")
    public String displayStudents(Model model) {
        List students = studentDao.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }
    
    @PostMapping("addStudent")
    public String addStudent(String firstName, String lastName) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        studentDao.addStudent(student);
        
        return "redirect:/students";
    }
    
    @GetMapping("deleteStudent")
    public String deleteStudent(Integer id) {
        studentDao.deleteStudentById(id);
        return "redirect:/students";
    }
    
    @GetMapping("editStudent")
    public String editStudent(Integer id, Model model) {
        Student student = studentDao.getStudentById(id);
        model.addAttribute("student", student);
        return "editStudent";
    }
    
    @PostMapping("editStudent")
    public String performEditStudent(@Valid Student student, BindingResult result) {
        if(result.hasErrors()) {
            return "editStudent";
        }
        studentDao.updateStudent(student);
        return "redirect:/students";
    }
    
}