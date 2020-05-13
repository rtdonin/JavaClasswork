/*
Created by: Margaret Donin
Date created: 05/10/20
Date revised:
*/

package M2.Summary.classroster.dao;

import M2.Summary.classroster.dto.Student;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ClassRosterDaoFileImpl implements ClassRosterDao {
    private Map<String, Student> students = new HashMap<>();
    public static final String ROSTER_FILE = "roster.txt";
    public static final String DELIMITER = "::";

    @Override
    public Student addStudent(String studentId, Student student) throws ClassRosterDaoException {
        loadRoster();
        Student newStudent = students.put(studentId, student);
        writeRoster();
        return newStudent;
    }

    @Override
    public List<Student> getAllStudents() throws ClassRosterDaoException {
        loadRoster();
        return new ArrayList<Student>(students.values());
    }

    @Override
    public Student getStudent(String studentId) throws ClassRosterDaoException {
        loadRoster();
        return students.get(studentId);
    }

    @Override
    public Student removeStudent(String studentId) throws ClassRosterDaoException {
        loadRoster();
        Student removedStudent = students.remove(studentId);
        writeRoster();
        return removedStudent;
    }
    
    private Student unmarshallStudent(String studentAsText) {
        // splits strings into an arrary of strings split at delimiter
        String[] studentTokens = studentAsText.split(DELIMITER);
        // first it the ID, next the first name, then last name and finally the cohort
        String studentId = studentTokens[0];
        Student studentFromFile = new Student(studentId);
        studentFromFile.setFirstName(studentTokens[1]);
        studentFromFile.setLastName(studentTokens[2]);
        studentFromFile.setCohort(studentTokens[3]);
        
        return studentFromFile;
    }
    
    private void loadRoster() throws ClassRosterDaoException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
        } catch(FileNotFoundException e) {
            throw new ClassRosterDaoException("-_- Could not load roster data into memory.", e);
        }
        
        String currentLine;
        Student currentStudent;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentStudent = unmarshallStudent(currentLine);
            students.put(currentStudent.getStudentId(), currentStudent);
        }
        // close scanner
        scanner.close();
    }
    
    private String marshallStudent(Student aStudent){
        String studentAsText = aStudent.getStudentId() + DELIMITER;
        studentAsText += aStudent.getFirstName() + DELIMITER;
        studentAsText += aStudent.getLastName() + DELIMITER;
        studentAsText += aStudent.getCohort();
        
        return studentAsText;
    }
    
    /*
    Writes all students in the roster out to a ROSTER_FILE.  See loadRoster for file format.
     
    @throws ClassRosterDaoException if an error occurs writing to the file
    */
    private void writeRoster() throws ClassRosterDaoException {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(ROSTER_FILE));
        } catch (IOException e) {
            throw new ClassRosterDaoException("Could not save student data.", e);
        }
        String studentAsText;
        List<Student> studentList = new ArrayList(students.values());
        
        for(Student currentStudent : studentList) {
            studentAsText = marshallStudent(currentStudent);
            out.println(studentAsText);
            out.flush();
        }
        
        out.close();
    }
}