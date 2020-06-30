/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringServiceLayerImplTest {
    FlooringServiceLayer service;
    
    public FlooringServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        service = ctx.getBean("service", FlooringServiceLayer.class);
    }
    
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void getDateOrdersTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getNewIdTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void addOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void validateOrderTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getAllProductsTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void getProductTest() {
        // fail("The test case is a prototype.");
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
    public void changeEditOrderTest() {
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
    public void exportTest() {
        // fail("The test case is a prototype.");
    }
    
}
