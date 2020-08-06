/*
Created by: Margaret Donin
Date created: 05/11/20
Date revised: 05/26/20 For M3
*/


package classroster.dao;

public class ClassRosterPersistenceException extends Exception{
    public ClassRosterPersistenceException(String message) {
        super(message);
    }
    
    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

}
