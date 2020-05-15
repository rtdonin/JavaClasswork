/*
Created by: Margaret Donin
Date created: 05/14/20
Date revised:
*/

package M2.ListsAndMaps.StudentQuizGrades;

import static java.lang.Integer.parseInt;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StudentQuizGradesDao {
    Map<String, List> studentData = new HashMap<>();

    public void addStudent(String newStudentName, List newStudentGrades) {
        studentData.put(newStudentName, newStudentGrades);
    }

    public Map getAllStudents() {
        Set<String> students = studentData.keySet();
        Map<String, String> stringStudentData = new HashMap<>();
        
        for(String s : students) {
            stringStudentData.put(s, getStudentQuizGrades(s));
        }
        
        return stringStudentData;
    }
    
    public void removeStudent(String aStudent){
        studentData.remove(aStudent);
    }
    
    public String getStudentQuizGrades(String aStudent){
        List<Integer> gradesList = studentData.get(aStudent);
        String gradeString = "";

        Iterator iterator = gradesList.listIterator();

        while(iterator.hasNext()) {
            gradeString += iterator.next().toString();

            if(iterator.hasNext()) {
                gradeString += ", ";
            }
        }

        return gradeString;
    }

    public double getStudentQuizAverage(String aStudent) {
        List<Integer> gradesList = studentData.get(aStudent);
        double gradeTotal = 0;

        Iterator iterator = gradesList.listIterator();

        while (iterator.hasNext()) {
            gradeTotal += parseInt(iterator.next().toString());
        }

        return gradeTotal / gradesList.size();
    }
    
    public double getClassAverage() {
        Set<String> students = studentData.keySet();

        int gradeTotal = 0;
        int totalQuizes = 0;

        for (String s : students) {

            List<Integer> grades = studentData.get(s);
            totalQuizes += grades.size();
            Iterator iterator = grades.listIterator();

            while (iterator.hasNext()) {
                gradeTotal += parseInt(iterator.next().toString());
            }
        }
        return gradeTotal / totalQuizes;
    }
    
    public Set getStudentsWithHighestGrades() {
        int highestGrade = 0;
        
        Set<String> students = studentData.keySet();
        Set<String> studentsWithHighestGrades = new HashSet<>();
        Iterator iterator;
        
        for(String s : students) {
            iterator = studentData.get(s).listIterator();
        
            while(iterator.hasNext()) {
                int grade = parseInt(iterator.next().toString());
                
                if(grade == highestGrade) {
                    studentsWithHighestGrades.add(s);
                } else if(grade > highestGrade) {
                    studentsWithHighestGrades.clear();
                    studentsWithHighestGrades.add(s);
                }
            }
        }
        return studentsWithHighestGrades;
    }

    public Set getStudentsWithLowestGrades() {
        int lowestGrade = 0;
        
        Set<String> students = studentData.keySet();
        Set<String> studentsWithLowestGrades = new HashSet<>();
        Iterator iterator;
        
        for(String s : students) {
            iterator = studentData.get(s).listIterator();
        
            while(iterator.hasNext()) {
                int grade = parseInt(iterator.next().toString());
                
                if(studentsWithLowestGrades.isEmpty()) {
                    lowestGrade = grade;
                    studentsWithLowestGrades.add(s);
                } else if(grade == lowestGrade) {
                    studentsWithLowestGrades.add(s);
                } else if(grade < lowestGrade) {
                    studentsWithLowestGrades.clear();
                    studentsWithLowestGrades.add(s);
                }
            }
        }
        return studentsWithLowestGrades;
    }
}
 