/*
Created by: Margaret Donin
Date created: 06/22/20
Date revised:
*/

package M4.AOP.vendingmachine.advice;

import M4.AOP.vendingmachine.dao.VendingMachineAuditDao;
import M4.AOP.vendingmachine.dao.VendingMachinePersistenceException;
import org.aspectj.lang.JoinPoint;

public class LoggingAdvice {
    VendingMachineAuditDao auditDao;
    
    public LoggingAdvice(VendingMachineAuditDao auditDao) {
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
        } catch (VendingMachinePersistenceException e) {
            System.err.println(
               "ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }
}