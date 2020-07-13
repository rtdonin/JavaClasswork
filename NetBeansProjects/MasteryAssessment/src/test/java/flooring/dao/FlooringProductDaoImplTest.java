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

public class FlooringProductDaoImplTest {
    
    FlooringProductDao testDao;
    
    public FlooringProductDaoImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        testDao = ctx.getBean("productDao", FlooringProductDao.class);
    }
    
    @BeforeEach
    public void setUp() {
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
    public void addProductTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void editProductTest() {
        // fail("The test case is a prototype.");
    }
    
    @Test
    public void removeProductTest() {
        // fail("The test case is a prototype.");
    }
    
}
