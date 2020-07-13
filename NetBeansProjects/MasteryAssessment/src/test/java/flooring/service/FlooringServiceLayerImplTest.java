/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.service;

import flooring.dao.FlooringPersistenceException;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringServiceLayerImplTest {
    FlooringServiceLayer service;
    
    public FlooringServiceLayerImplTest() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        service = ctx.getBean("service", FlooringServiceLayer.class);
    }

    @Test
    public void getDateOrdersTest() throws Exception {
        Order testOrder = new Order(1);
        testOrder.setName("Acme Inc.");
        testOrder.setArea(new BigDecimal("200"));
        LocalDate ld = LocalDate.of(2020, 7, 10);
        testOrder.setDate(ld);
        testOrder.setState(new State("NY", "New York", new BigDecimal("4.00")));
        testOrder.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));
        
        List<Order> testList = new ArrayList<>();
        testList.add(testOrder);
        
        List receivedList = service.getDateOrders(ld);
        
        assertEquals(receivedList.size(), 1, "List should have only one order.");
        assertNotNull(receivedList, "List should not be empty.");
        assertArrayEquals(receivedList.toArray(), testList.toArray(), "Lists shold be the same.");
        assertTrue(receivedList.contains(testOrder), "Should contain testOrder.");
        
    }
    
    @Test
    public void getOrderTest() throws Exception {
        LocalDate ld = LocalDate.of(2020, 7, 10);
        Integer id = 1;
        
        Order testOrder = new Order(id);
        testOrder.setName("Acme Inc.");
        testOrder.setArea(new BigDecimal("200"));
        testOrder.setDate(ld);
        testOrder.setState(new State("NY", "New York", new BigDecimal("4.00")));
        testOrder.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));
        
        Order receivedOrder = service.getOrder(ld, id);
        
        assertNotNull(receivedOrder, "Value should not be null.");
        assertEquals(receivedOrder, testOrder, "Orders should be the same.");
        assertEquals(receivedOrder.getId(), testOrder.getId(), "Should be the same.");
        assertEquals(receivedOrder.getName(), testOrder.getName(), "Should be the same.");
        assertEquals(receivedOrder.getArea(), testOrder.getArea(), "Should be the same.");
        assertEquals(receivedOrder.getDate(), testOrder.getDate(), "Should be the same.");
        assertEquals(receivedOrder.getState(), testOrder.getState(), "Should be the same.");
        assertEquals(receivedOrder.getProduct(), testOrder.getProduct(), "Should be the same.");
        
        receivedOrder = service.getOrder(ld, id + 1);
        assertNull(receivedOrder, "Should be null.");
        
        try {
            service.getOrder(ld.plusDays(1), id);
            fail("Should thrown exception. No such \"file\" exists");            
        } catch (FlooringPersistenceException ex) {
            // do nothing, passed!
        }
        
    }
    
    @Test
    public void getNewIdTest() throws Exception {
        Integer testId = 2;
        Integer receivedId = service.getNewId();
        
        assertNotNull(receivedId, "Should be a value.");
        assertEquals(receivedId, testId, "There is only one order, next order ID should be 2.");

    }
    
    @Test
    public void addOrderTest() {
        //public Order addOrder(Order newOrder) throws FlooringPersistenceException;
        
    }
    
    @Test
    public void validateOrderTest() {
       //public Order validateOrder(Order order) throws InvalidAreaException, InvalidDateException, InvalidNameException;

    }
    
    @Test
    public void getAllProductsTest() throws Exception {
        String type = "Stone";
        BigDecimal materials = new BigDecimal("3.50");
        BigDecimal labor = new BigDecimal("4.00");
        
        Product testProduct = new Product(type, materials, labor);
        
        Map<String, Product> testMap = new HashMap<>();
        testMap.put(type, testProduct);
        
        Map<String, Product> receivedMap = service.getAllProducts();
        
        assertNotNull(receivedMap, "Map of products should not be null.");
        assertEquals(receivedMap.size(), 1, "Size of map should be 1.");
        assertTrue(receivedMap.containsValue(testProduct), "Should have the product.");
        assertEquals(receivedMap.get(type), testMap.get(type), "Both products should be the same.");
        
    }
    
    @Test
    public void getAllStatesTest() throws Exception {
        String abbreviation = "NY";
        String name = "New York";
        BigDecimal tax = new BigDecimal("4.00");
        
        State testState = new State(abbreviation, name, tax);
        
        Map<String, State> testMap = new HashMap<>();
        testMap.put(testState.getStateAbbreviation(), testState);
        
        Map<String, State> receivedMap = service.getAllStates();
        
        assertNotNull(receivedMap, "Map of products should not be null.");
        assertEquals(receivedMap.size(), 1, "Size of map should be 1.");
        assertTrue(receivedMap.containsValue(testState), "Should have the state.");
        assertEquals(receivedMap.get(abbreviation), testMap.get(abbreviation), "Both states should be the same.");
        
    }
    
    @Test
    public void checkNewOrderTest() {
        // public Order checkNewOrder(Order oldOrder, Order newOrder) throws InvalidAreaException, InvalidDateException, InvalidNameException;
        
    }
    
    @Test
    public void editOrderTest() {
        // public Order editOrder(Order editedOrder) throws FlooringPersistenceException;
        
    }
    
    @Test
    public void removeOrderTest() {
        // public Order removeOrder(Order removeOrder) throws FlooringPersistenceException;
        
    }
    
    @Test
    public void exportTest() {
        // public void export() throws FlooringPersistenceException;
    }

    
    @Test
    public void compConfirmationTest() throws Exception {
        
        boolean received = service.compConfirmation("y");
        assertTrue(received, "\"y\" should be TRUE");
        
        received = service.compConfirmation("Y");
        assertTrue(received, "\"Y\" should be TRUE");
        
        received = service.compConfirmation("yes");
        assertTrue(received, "\"yes\" should be TRUE");
        
        received = service.compConfirmation("Yes");
        assertTrue(received, "\"Yes\" should be TRUE");
        
        received = service.compConfirmation("n");
        assertFalse(received, "\"n\" should be FALSE");
        
        received = service.compConfirmation("N");
        assertFalse(received, "\"N\" should be FALSE");
        
        received = service.compConfirmation("no");
        assertFalse(received, "\"no\" should be FALSE");
        
        received = service.compConfirmation("NO");
        assertFalse(received, "\"NO\" should be False");
        
        try {
            service.compConfirmation("es");
            
            fail("Should throw exception.");
        } catch (NotYesOrNoException ex) {
            // do nothing, it passed!
        }
        
    }
    
}
