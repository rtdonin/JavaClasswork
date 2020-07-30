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

        List receivedList = service.getDateOrders(ld);
        
        assertEquals(receivedList.size(), 1, "List should have only one order.");
        assertNotNull(receivedList, "List should not be empty.");
        assertTrue(receivedList.contains(testOrder), "Should contain testOrder.");
        
        ld = LocalDate.of(2020, 7, 20);

        receivedList = service.getDateOrders(ld);
        
        assertNull(receivedList, "The list should be null.");
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
    public void addOrderTest() throws Exception {
        Order order = new Order(1);
        order.setName("Acme Inc.");
        order.setArea(new BigDecimal("200"));
        order.setDate(LocalDate.of(2020, 7, 10));
        order.setState(new State("NY", "New York", new BigDecimal("4.00")));
        order.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));
        
        Order received = service.addOrder(order);
        
        assertEquals(received, order, "Should be the same. Order was added.");
    }
    
    @Test
    public void validateOrderTest() throws Exception{
        // I doubt anyone will be usign my code in 1000 years, therefore 3020
        LocalDate normalDate = LocalDate.of(3020, 7, 10);
        Integer id = 1;
        String normalName = "Acme Inc.";
        BigDecimal normalArea = new BigDecimal("200");
        State normalState = new State("NY", "New York", new BigDecimal("4.00"));
        Order normalOrder = new Order(id);
        Product normalProduct = new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00"));
        
        normalOrder.setName(normalName);
        normalOrder.setArea(normalArea);
        normalOrder.setDate(normalDate);
        normalOrder.setState(normalState);
        normalOrder.setProduct(normalProduct);
        
        // What the values should be.
        BigDecimal materials = new BigDecimal("700.00");
        BigDecimal labor = new BigDecimal("800.00");
        BigDecimal tax = new BigDecimal("60.00");
        BigDecimal total = new BigDecimal("1560.00");
        
        // test normal values.
        Order received = service.validateOrder(normalOrder);
        
        assertNotNull(received, "Order should not be null.");
        assertEquals(received.getMaterialCost().compareTo(materials), 0, "Checking cost of materials.");
        assertEquals(received.getLaborCost().compareTo(labor), 0, "Checking cost of labor.");
        assertEquals(received.getTax().compareTo(tax), 0, "Checking tax.");
        assertEquals(received.getTotal().compareTo(total), 0, "Checking total.");
        
        Order nameOrder = new Order(id++);
        nameOrder.setName("bad-name");
        nameOrder.setArea(normalArea);
        nameOrder.setDate(normalDate);
        nameOrder.setState(normalState);
        nameOrder.setProduct(normalProduct);
        
        try {
            service.validateOrder(nameOrder);
            fail("Should throw an invalid name exception.");
        } catch (InvalidNameException ex) {
            // do nothing
        }
        
        Order dateOrder = new Order(id++);
        dateOrder.setName(normalName);
        dateOrder.setArea(normalArea);
        dateOrder.setDate(LocalDate.of(2000, 01, 01));
        dateOrder.setState(normalState);
        dateOrder.setProduct(normalProduct);
        
        try {
            service.validateOrder(dateOrder);
            fail("Should throw an invalid date exception.");
        } catch (InvalidDateException ex) {
            // do nothing
        }

        dateOrder.setDate(LocalDate.now());
        
        try {
            service.validateOrder(dateOrder);
            fail("Should throw an invalid date exception.");
        } catch (InvalidDateException ex) {
            // do nothing
        }
        
        Order areaOrder = new Order(id++);
        areaOrder.setName(normalName);
        areaOrder.setArea(new BigDecimal("100"));
        areaOrder.setDate(normalDate);
        areaOrder.setState(normalState);
        areaOrder.setProduct(normalProduct);
        
        // should not throw exception. If it does, it fails.
        service.validateOrder(areaOrder);
        
        areaOrder.setArea(new BigDecimal("50"));
        
        try {
            service.validateOrder(areaOrder);
            fail("Should throw an invalid area exception.");
        } catch (InvalidAreaException ex) {
            // do nothing
        }
        
        Order productOrder = new Order(id++);
        productOrder.setName(normalName);
        productOrder.setArea(normalArea);
        productOrder.setDate(normalDate);
        productOrder.setState(normalState);
        productOrder.setProduct(null);
        
        try {
            service.validateOrder(productOrder);
            fail("Should throw an invalid product exception.");
        } catch (InvalidProductException ex) {
            // do nothing
        }
        
        Order stateOrder = new Order(id++);
        stateOrder.setName(normalName);
        stateOrder.setArea(normalArea);
        stateOrder.setDate(normalDate);
        stateOrder.setState(null);
        stateOrder.setProduct(normalProduct);
        
        try {
            service.validateOrder(stateOrder);
            fail("Should throw an invalid state exception.");
        } catch (InvalidStateException ex) {
            // do nothing
        }
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
    public void checkNewOrderTest() throws Exception{
        // we call the validateOrder method in this method to validate the data.
        // I don't need to test a method twice.
        
        Order oldOrder = new Order(1);
        oldOrder.setName("Acme Inc.");
        oldOrder.setArea(new BigDecimal("200"));
        LocalDate ld = LocalDate.of(3020, 7, 10);
        oldOrder.setDate(ld);
        oldOrder.setState(new State("NY", "New York", new BigDecimal("4.00")));
        oldOrder.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));
        oldOrder.setLaborCost(new BigDecimal("800"));
        oldOrder.setMaterialCost(new BigDecimal("700"));
        oldOrder.setTax(new BigDecimal("60"));
        oldOrder.setTotal(new BigDecimal("1560"));
        Order newOrder = new Order(1);
        
        Order received = service.checkNewOrder(oldOrder, newOrder);
        
        assertNotNull(received, "Should not be null.");
        
        assertEquals(newOrder.toString(), oldOrder.toString(), "The orders should now be equal to each other.");
        String newName = "Edit, order";
        newOrder.setName(newName);
        newOrder.setArea(null);
        newOrder.setDate(null);
        newOrder.setState(null);
        newOrder.setProduct(null);
        
        service.checkNewOrder(oldOrder, newOrder);
        
        assertEquals(newOrder.getName(), newName, "Checking name.");
        assertEquals(newOrder.getArea(), oldOrder.getArea(), "Checking area.");
        assertEquals(newOrder.getDate(), oldOrder.getDate(), "Checking date.");
        assertEquals(newOrder.getState(), oldOrder.getState(), "Checking state.");
        assertEquals(newOrder.getProduct(), oldOrder.getProduct(), "Checking product.");
        
    }
    
    @Test
    public void editOrderTest() throws Exception {
        Order testOrder = new Order(1);
        testOrder.setName("Acme Inc.");
        testOrder.setArea(new BigDecimal("200"));
        testOrder.setDate(LocalDate.of(2020, 7, 10));
        testOrder.setState(new State("NY", "New York", new BigDecimal("4.00")));
        testOrder.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));
        
        Order received = service.editOrder(testOrder);
        
        assertEquals(received, testOrder, "Should be the same.");
    }
    
    @Test
    public void removeOrderTest() throws Exception {
        Order order = new Order(1);
        order.setName("Acme Inc.");
        order.setArea(new BigDecimal("200"));
        LocalDate ld = LocalDate.of(2020, 7, 10);
        order.setDate(ld);
        order.setState(new State("NY", "New York", new BigDecimal("4.00")));
        order.setProduct(new Product("Stone", new BigDecimal("3.50"), new BigDecimal("4.00")));

        // We always check to see if the order exists first, so we should never get
        // to this point ever. But I will assume the "what if" of someone meddling
        // with my code.
        Order receivedOrder = service.removeOrder(order);
        
        assertNotNull(receivedOrder, "Should not be null.");
        assertEquals(order, receivedOrder, "Should be equal.");
        
        order = new Order(2);
        order.setDate(ld);
        
        receivedOrder = service.removeOrder(order);
        
        assertNull(receivedOrder, "Should be null.");
        
    }
    
    @Test
    public void exportTest() {
        try {
            service.export();
        } catch (FlooringPersistenceException ex) {
            fail("Exporting shouldn't throw an exception.");
        }
    }

    @Test
    public void compConfirmationTest() throws Exception {
        String[] testTrueStrings = {"Y", "y", "Yes", "YES", "yEs", "yES", "yes"};
        boolean received;
        
        for (int i = 0; i < testTrueStrings.length; i++) {
            String test = testTrueStrings[i];
            received = service.compConfirmation(test);
            assertTrue(received, "\"" + test + "\" should be TRUE");
        }
        
        String[] testFalseStrings = {"N", "n", "No", "NO", "no", "NO"};
        
        for (int i = 0; i < testFalseStrings.length; i++) {
            String test = testFalseStrings[i];
            received = service.compConfirmation(test);
            assertFalse(received, "\"" + test + "\" should be FALSE");
        }
        
        try {
            service.compConfirmation("es");
            
            fail("Should throw exception.");
        } catch (NotYesOrNoException ex) {
            // do nothing, it passed!
        }
        
    }
    
}
