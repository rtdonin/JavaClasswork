/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.dao;

import java.io.FileWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringOrderDaoImplTest {
    
    private FlooringOrderDao testDao;
    
    public FlooringOrderDaoImplTest() {

    }
    
    @BeforeEach
    public void setUp() {
        
                String testFile = "testroster.txt";
        // Uses the FileWrite to quickly blank the file
        new FileWriter(testFile);
        testDao = new ClassRosterDaoFileImpl(testFile);
        
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        testDao = ctx.getBean("orderDao", FlooringOrderDao.class);
    }

    @Test
    public void getAllOrdersFromDateTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void addOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void editOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void removeOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getAllOrdersTest() {
        // fail("The test case is a prototype.");
    }
    
}
