/*
Created by: Margaret Donin
Date created: 06/30/20
Date revised:
*/

package flooring.advice;

import flooring.dao.FlooringAuditDao;
import flooring.dao.FlooringPersistenceException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
    FlooringAuditDao auditDao;
    
    public LoggingAdvice(FlooringAuditDao auditDao) {
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
        } catch (FlooringPersistenceException ex) {
            System.out.println("AOP IS BROKEN!!!!! In logging advice.");
        }
    }
    
    public void createExceptionAuditEntry (Exception ex) {
        String auditEntry = "Exception thrown: " + ex.getMessage();

        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (FlooringPersistenceException e) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}
