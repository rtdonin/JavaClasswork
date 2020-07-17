/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.dao;

import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
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
        // I want to delete all the files in the folder
        // I have to get the folder name used in testDao from the xml somehow... probably not an option
        
        String testDirectory = "TestFile//Orders";
        
        File folder = new File(testDirectory);
        File[] listOfFiles = folder.listFiles();
        
        for(File f : listOfFiles){
            f.delete();
        }
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        testDao = ctx.getBean("orderDao", FlooringOrderDao.class);
    }

    @Test
    public void getAllOrdersTest() throws Exception {
        LocalDate dateOne = LocalDate.of(2020, 5, 8);
        Order orderOne = new Order(1);
        orderOne.setName("Rachel Carson");
        orderOne.setDate(dateOne);
        orderOne.setArea(new BigDecimal("250"));
        orderOne.setProduct(new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.00")));
        orderOne.setState(new State("LA", new BigDecimal("4.45")));
        orderOne.setMaterialCost(new BigDecimal("875"));
        orderOne.setLaborCost(new BigDecimal("1000"));
        orderOne.setTax(new BigDecimal("83.44"));
        orderOne.setTotal(new BigDecimal("1958.43"));

        LocalDate dateTwo = LocalDate.of(2020, 5, 9);
        Order orderTwo = new Order(2);
        orderTwo.setName("Gertrude B. Elion");
        orderTwo.setDate(dateTwo);
        orderTwo.setArea(new BigDecimal("150"));
        orderTwo.setProduct(new Product("Wood", new BigDecimal("1.00"), new BigDecimal("2.00")));
        orderTwo.setState(new State("ND", new BigDecimal("5.00")));
        orderTwo.setMaterialCost(new BigDecimal("150"));
        orderTwo.setLaborCost(new BigDecimal("300"));
        orderTwo.setTax(new BigDecimal("22.5"));
        orderTwo.setTotal(new BigDecimal("472.50"));
        
        testDao.addOrder(orderOne);
        testDao.addOrder(orderTwo);
        
        List<Order> receivedList = testDao.getAllOrders(dateOne);
        
        assertNotNull(receivedList, "List should not be null.");
        assertEquals(receivedList.size(), 1, "There should only be one order on this list.");
        assertTrue(receivedList.contains(orderOne), "Order 1 from Rachel Carson should be on this list.");
    }
    
    @Test
    public void getOrderTest() throws Exception {
        LocalDate dateOne = LocalDate.of(2020, 5, 8);
        Order orderOne = new Order(1);
        orderOne.setName("Rachel Carson");
        orderOne.setDate(dateOne);
        orderOne.setArea(new BigDecimal("250"));
        orderOne.setProduct(new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.00")));
        orderOne.setState(new State("LA", new BigDecimal("4.45")));
        orderOne.setMaterialCost(new BigDecimal("875"));
        orderOne.setLaborCost(new BigDecimal("1000"));
        orderOne.setTax(new BigDecimal("83.44"));
        orderOne.setTotal(new BigDecimal("1958.43"));
        
        LocalDate dateTwo = LocalDate.of(2020, 5, 9);
        Order orderTwo = new Order(2);
        orderTwo.setName("Gertrude B. Elion");
        orderTwo.setDate(dateTwo);
        orderTwo.setArea(new BigDecimal("150"));
        orderTwo.setProduct(new Product("Wood", new BigDecimal("1.00"), new BigDecimal("2.00")));
        orderTwo.setState(new State("ND", new BigDecimal("5.00")));
        orderTwo.setMaterialCost(new BigDecimal("150"));
        orderTwo.setLaborCost(new BigDecimal("300"));
        orderTwo.setTax(new BigDecimal("22.5"));
        orderTwo.setTotal(new BigDecimal("472.50"));
        
        testDao.addOrder(orderOne);
        
        Order received = testDao.getOrder(dateOne, 1);
        
        assertEquals(received, orderOne, "The orders should be the same.");
        assertEquals(received.getName(), orderOne.getName(), "Checking names.");
        assertEquals(received.getDate(), orderOne.getDate(), "Checking dates.");
        assertEquals(received.getArea(), orderOne.getArea(), "Checking area.");
        assertEquals(received.getProduct(), orderOne.getProduct(), "Checking Product.");
        assertEquals(received.getState(), orderOne.getState(), "Checking State.");
        assertEquals(received.getMaterialCost(), orderOne.getMaterialCost(), "Checking material cost.");
        assertEquals(received.getLaborCost(), orderOne.getLaborCost(), "Checking labor cost.");
        assertEquals(received.getTax(), orderOne.getTax(), "Checking tax.");
        assertEquals(received.getTotal(), orderOne.getTotal(), "Checking total.");
        
        received = testDao.getOrder(dateTwo, 2);
        
        assertNull(received, "The order should be null.");
        
    }
    
    @Test
    public void addOrderTest() throws Exception {
        LocalDate dateOne = LocalDate.of(2020, 5, 8);
        Integer idOne = 1;
        Order orderOne = new Order(idOne);
        orderOne.setName("Rachel Carson");
        orderOne.setDate(dateOne);
        orderOne.setArea(new BigDecimal("250"));
        orderOne.setProduct(new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.00")));
        orderOne.setState(new State("LA", new BigDecimal("4.45")));
        orderOne.setMaterialCost(new BigDecimal("875"));
        orderOne.setLaborCost(new BigDecimal("1000"));
        orderOne.setTax(new BigDecimal("83.44"));
        orderOne.setTotal(new BigDecimal("1958.43"));
        
        Order received = testDao.getOrder(dateOne, idOne);
        
        assertNull(received, "Should be null.");
        
        received = testDao.addOrder(orderOne);
        
        assertEquals(received, orderOne, "The order should be the same.");
        assertEquals(received.getName(), orderOne.getName(), "Checking names.");
        assertEquals(received.getDate(), orderOne.getDate(), "Checking dates.");
        assertEquals(received.getArea(), orderOne.getArea(), "Checking area.");
        assertEquals(received.getProduct(), orderOne.getProduct(), "Checking Product.");
        assertEquals(received.getState(), orderOne.getState(), "Checking State.");
        assertEquals(received.getMaterialCost(), orderOne.getMaterialCost(), "Checking material cost.");
        assertEquals(received.getLaborCost(), orderOne.getLaborCost(), "Checking labor cost.");
        assertEquals(received.getTax(), orderOne.getTax(), "Checking tax.");
        assertEquals(received.getTotal(), orderOne.getTotal(), "Checking total.");
        
        received = testDao.getOrder(dateOne, idOne);
        
        assertEquals(received, orderOne, "The get order should be the same.");
        assertEquals(received.getName(), orderOne.getName(), "Checking names.");
        assertEquals(received.getDate(), orderOne.getDate(), "Checking dates.");
        assertEquals(received.getArea(), orderOne.getArea(), "Checking area.");
        assertEquals(received.getProduct(), orderOne.getProduct(), "Checking Product.");
        assertEquals(received.getState(), orderOne.getState(), "Checking State.");
        assertEquals(received.getMaterialCost(), orderOne.getMaterialCost(), "Checking material cost.");
        assertEquals(received.getLaborCost(), orderOne.getLaborCost(), "Checking labor cost.");
        assertEquals(received.getTax(), orderOne.getTax(), "Checking tax.");
        assertEquals(received.getTotal(), orderOne.getTotal(), "Checking total.");
        
    }
    
    @Test
    public void editOrderTest() throws Exception {
        LocalDate dateOne = LocalDate.of(2020, 5, 8);
        Integer idOne = 1;
        Order orderOne = new Order(idOne);
        orderOne.setName("Rachel Carson");
        orderOne.setDate(dateOne);
        orderOne.setArea(new BigDecimal("250"));
        orderOne.setProduct(new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.00")));
        orderOne.setState(new State("LA", new BigDecimal("4.45")));
        orderOne.setMaterialCost(new BigDecimal("875"));
        orderOne.setLaborCost(new BigDecimal("1000"));
        orderOne.setTax(new BigDecimal("83.44"));
        orderOne.setTotal(new BigDecimal("1958.43"));
        
        testDao.addOrder(orderOne);
        
        Order received = testDao.getOrder(dateOne, idOne);
        
        assertEquals(received, orderOne, "Both orders should be the same.");
        
        orderOne.setArea(new BigDecimal("150"));
        
        received = testDao.editOrder(orderOne);
        
        assertEquals(received, orderOne, "The orders should be the same.");
        assertEquals(received.getArea(), orderOne.getArea(), "Checking area.");
    }
    
    @Test
    public void removeOrderTest() throws Exception {
        LocalDate dateOne = LocalDate.of(2020, 5, 8);
        Order orderOne = new Order(1);
        orderOne.setName("Rachel Carson");
        orderOne.setDate(dateOne);
        orderOne.setArea(new BigDecimal("250"));
        orderOne.setProduct(new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.00")));
        orderOne.setState(new State("LA", new BigDecimal("4.45")));
        orderOne.setMaterialCost(new BigDecimal("875"));
        orderOne.setLaborCost(new BigDecimal("1000"));
        orderOne.setTax(new BigDecimal("83.44"));
        orderOne.setTotal(new BigDecimal("1958.43"));
        
        Order orderTwo = new Order(2);
        orderTwo.setName("Gertrude B. Elion");
        orderTwo.setDate(dateOne);
        orderTwo.setArea(new BigDecimal("150"));
        orderTwo.setProduct(new Product("Wood", new BigDecimal("1.00"), new BigDecimal("2.00")));
        orderTwo.setState(new State("ND", new BigDecimal("5.00")));
        orderTwo.setMaterialCost(new BigDecimal("150"));
        orderTwo.setLaborCost(new BigDecimal("300"));
        orderTwo.setTax(new BigDecimal("22.5"));
        orderTwo.setTotal(new BigDecimal("472.50"));
        
        testDao.addOrder(orderOne);
        testDao.addOrder(orderTwo);
        
        List<Order> receivedList = testDao.getAllOrders(dateOne);
        
        assertEquals(receivedList.size(), 2, "There should be two orders on the list.");
        assertTrue(receivedList.contains(orderOne), "List should contain Rachel Carson order.");
        assertTrue(receivedList.contains(orderOne), "List should contain Gertrude B. Elion order.");

        Order received = testDao.removeOrder(orderOne);
        
        assertEquals(received, orderOne, "The orders should be the same.");
        assertEquals(received.getName(), orderOne.getName(), "Checking names.");
        assertEquals(received.getDate(), orderOne.getDate(), "Checking dates.");
        assertEquals(received.getArea(), orderOne.getArea(), "Checking area.");
        assertEquals(received.getProduct(), orderOne.getProduct(), "Checking Product.");
        assertEquals(received.getState(), orderOne.getState(), "Checking State.");
        assertEquals(received.getMaterialCost(), orderOne.getMaterialCost(), "Checking material cost.");
        assertEquals(received.getLaborCost(), orderOne.getLaborCost(), "Checking labor cost.");
        assertEquals(received.getTax(), orderOne.getTax(), "Checking tax.");
        assertEquals(received.getTotal(), orderOne.getTotal(), "Checking total.");
        
        receivedList = testDao.getAllOrders(dateOne);
        
        assertEquals(receivedList.size(), 1, "There should be one order on the list.");
        assertFalse(receivedList.contains(orderOne), "List should not contain Rachel Carson order.");
        assertTrue(receivedList.contains(orderTwo), "List should contain Gertrude B. Elion order.");

        // STILL NEED TO CHECK I DELETE THE EMPTY FILE
    }
    
    @Test
    public void exportAllTest() throws Exception {
        LocalDate dateOne = LocalDate.of(2020, 5, 8);
        Order orderOne = new Order(1);
        orderOne.setName("Rachel Carson");
        orderOne.setDate(dateOne);
        orderOne.setArea(new BigDecimal("250"));
        orderOne.setProduct(new Product("Tile", new BigDecimal("3.50"), new BigDecimal("4.00")));
        orderOne.setState(new State("LA", new BigDecimal("4.45")));
        orderOne.setMaterialCost(new BigDecimal("875"));
        orderOne.setLaborCost(new BigDecimal("1000"));
        orderOne.setTax(new BigDecimal("83.44"));
        orderOne.setTotal(new BigDecimal("1958.43"));
        
        LocalDate dateTwo = LocalDate.of(2020, 5, 9);
        Order orderTwo = new Order(2);
        orderTwo.setName("Gertrude B. Elion");
        orderTwo.setDate(dateTwo);
        orderTwo.setArea(new BigDecimal("150"));
        orderTwo.setProduct(new Product("Wood", new BigDecimal("1.00"), new BigDecimal("2.00")));
        orderTwo.setState(new State("ND", new BigDecimal("5.00")));
        orderTwo.setMaterialCost(new BigDecimal("150"));
        orderTwo.setLaborCost(new BigDecimal("300"));
        orderTwo.setTax(new BigDecimal("22.5"));
        orderTwo.setTotal(new BigDecimal("472.50"));
        
        testDao.addOrder(orderOne);
        testDao.addOrder(orderTwo);
        
        List<Order> receivedList = testDao.exportAll();
        
        assertEquals(2, receivedList.size(), "Should have two orders.");
        assertTrue(receivedList.contains(orderOne), "Should contain Rachel Carson order.");
        assertTrue(receivedList.contains(orderTwo), "Should contain Gertrude B. Elion order.");
    }
    
}
