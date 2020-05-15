/*
Created by: Margaret Donin
Date created:05/14/20 
Date reviaSsed:
*/

package M2.ListsAndMaps.StudentQuizGrades;

import M2.ListsAndMaps.UserIOClassLab.UserIO;
import M2.ListsAndMaps.UserIOClassLab.UserIOImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOImpl();
        StudentQuizGradesUI ui = new StudentQuizGradesUI(io);
        StudentQuizGradesDao dao = new StudentQuizGradesDao();        
        Controller controller = new Controller(dao, ui);
        
        controller.run();
    }
}
