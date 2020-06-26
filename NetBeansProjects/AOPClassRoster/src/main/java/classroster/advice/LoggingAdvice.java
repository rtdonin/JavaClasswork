/*
Created by: Margaret Donin
Date created: 06/22/20
Date revised:
*/

package classroster.advice;

import classroster.dao.ClassRosterAuditDao;
import classroster.dao.ClassRosterPersistenceException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
    ClassRosterAuditDao auditDao;
    
    public LoggingAdvice(ClassRosterAuditDao auditDao) {
        this.auditDao = auditDao;
    }
    
    public void createAuditEntry(JoinPoint jp) {
        Object[] args = jp.getArgs();
        String auditEntry = jp.getSignature().getName() + ": ";
        for (Object currentArg : args) {
            auditEntry += currentArg;
        }
        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (ClassRosterPersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}