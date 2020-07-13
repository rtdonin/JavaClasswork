/*
Created by: Margaret Donin
Date created: 06/30/20
Date revised:
*/

package flooring.advice;

import flooring.dao.FlooringAuditDao;
import flooring.dao.FlooringPersistenceException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            System.out.println("IT'S BROKEN!!!!!");
        }
    }
}
