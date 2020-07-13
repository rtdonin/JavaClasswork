/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringStateDaoImplTest {
    
    private FlooringStateDao testDao;
    
    public FlooringStateDaoImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        testDao = ctx.getBean("stateDao", FlooringStateDao.class);
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void getAllStatesTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getStateTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void addStateTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void editStateTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void removeStateTest() {
        // fail("The test case is a prototype.");
    }
}
