/*
Created by: Margaret Donin
Date created: 06/09/20
Date revised: 06/18/20 For M4 Assessment

Arrange
Act
Assert

Methods we want to test:
    Map<Integer, Candy> getAllCandyForSale()
    boolean buyCandy(Candy, BigDecimal)
    Candy getCandy(Map<Integer, Candy>, int)
    Map<Coin, Integer> getChange(Candy, BigDecimal)
    boolean dispenseChange(Candy, BigDecimal)

TESTS WERE ONLY WRITTEN FOR METHODS THAT WERE REQUIRED FOR ASSESSMENT
*/

package M3.vendingmachine.service;

import M3.vendingmachine.dao.*;
import M3.vendingmachine.dto.*;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VendingMachineServiceLayerImplTest {
    private final VendingMachineServiceLayer service;

    public VendingMachineServiceLayerImplTest() {
//        VendingMachineDao dao = new VendingMachineDaoStubImpl();
//        VendingMachineAuditDao auditDao = new VendingMachineAuditDaoStubImpl();
//
//        service = new VendingMachineServiceLayerImpl(dao, auditDao);

        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:appContextFile.xml");
        
        service = appContext.getBean("service", VendingMachineServiceLayerImpl.class);

    }
    
    @Test
    public void testGetAllCandyForSale() throws VendingMachinePersistenceException, OutOfCandyException {
        // create both candies
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.26");
        int inventory = 2;
        Candy candyOne = new Candy(name, price, inventory);

        name = "Snickers";
        price = new BigDecimal("0.73");
        inventory = 0;
        Candy candyTwo = new Candy(name, price, inventory);

        // get Map from service layer
        Map<Integer, Candy> recievedMap = service.getAllCandyForSale();

        // test Map
        assertNotNull(recievedMap, "Should not be null.");
        assertEquals(1, recievedMap.size(), "Should only be one. One Candy is initialized to 0.");

        // test contents of Map
        assertTrue(recievedMap.containsValue(candyOne), "Should contain Whatchamacallit.");
        assertFalse(recievedMap.containsValue(candyTwo), "Should not contain Snickers.");
    }
    
    @Test
    public void testBuyCandy() throws VendingMachinePersistenceException {
        // set up Candy
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.26");
        int inventory = 2;
        Candy testCandy = new Candy(name, price, inventory);

        // create value for testing - not enough
        BigDecimal cashIn = new BigDecimal("1.00");

        // get value - not enough
        boolean returnedValue = service.buyCandy(testCandy, cashIn);

        // test values - not enough
        assertFalse(returnedValue, "We should not be able to buy the Candy.");

        // create value for testing - exact change
        cashIn = new BigDecimal("1.26");

        // get value - exact change
        returnedValue = service.buyCandy(testCandy, cashIn);

        // test values - exact change
        assertTrue(returnedValue, "We should be able to buy the Candy - exact change.");

        // create value for testing - more than enough
        cashIn = new BigDecimal("1.50");

        // get value - more than enough
        returnedValue = service.buyCandy(testCandy, cashIn);

        // test values - more than enough
        assertTrue(returnedValue, "We should be able to buy the Candy.");
    }
    
    @Test
    public void getCandy() {
        // set up candies
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.26");
        int inventory = 2;
        Candy candyOne = new Candy(name, price, inventory);

        name = "Snickers";
        price = new BigDecimal("0.73");
        inventory = 1;
        Candy candyTwo = new Candy(name, price, inventory);

        // create map
        Map<Integer, Candy> candyMap = Map.of(1, candyOne, 2, candyTwo);

        // get candy
        Candy retrievedCandy = service.getCandy(candyMap, 1);

        // check retrievedCandy
        assertNotNull(retrievedCandy, "Should be not null.");
        assertEquals(retrievedCandy, candyOne, "Should be a Whatchamacallit.");

        // get null candy
        retrievedCandy = service.getCandy(candyMap, 3);

        // check retrievedCandy
        assertNull(retrievedCandy, "Should be null.");

    }
    
    /*
        Option 1, I can check this by multiplying the coin value by the amount and
        making sure it match the change expected. Option 2, I can create my own map.
        While the first one is a bit less tedious, it involves logic. I get the
        feeling logic in a test example isn't ideal.
    */

    @Test
    public void getChange() {
        // set up candy
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.26");
        int inventory = 2;
        Candy candyOne = new Candy(name, price, inventory);

        // create cash put in
        BigDecimal cashInserted = new BigDecimal(2);

        // create expected map of change
        int[] testJingle = {2, 2, 0, 4};

        // get change
        int[] retrievedJingle = service.getChange(candyOne, cashInserted);

        // check the array is not null and is the same.
        assertNotNull(retrievedJingle, "We need change.");
        assertArrayEquals(testJingle, retrievedJingle, "Both arrays should be that same.");
        // test if we get change when perfect change
        // should never happen but still need to check
        cashInserted = candyOne.getPrice();
        
        testJingle = new int[] {0, 0, 0, 0};
        
        // get change
        retrievedJingle = service.getChange(candyOne, cashInserted);

        // check that map and what is has
        assertNotNull(retrievedJingle, "We need change.");
        assertArrayEquals(testJingle, retrievedJingle, "both arrays should be that same.");

    }
    
    
    /*
        Cash inserted should not be less than the price, as in such a situation
        shouldn't happen. There is a redudency check that I wrote. It throws and exception that is
        caught by the conroller and then kicks you out of the JVM
    */
    @Test
    public void testDoWeDispenseChange() throws NotEnoughCashInsertedException {
        // set up candy
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.26");
        int inventory = 2;
        Candy candyOne = new Candy(name, price, inventory);
        
        // set up cash inserted
        BigDecimal cashInserted = new BigDecimal("1.26");
        
        boolean returnedValue = service.doWeDispenseChange(candyOne, cashInserted);
        
        assertFalse(returnedValue, "Exact change was inserted, no change needs to be returned.");
        
        // test the other situation
        cashInserted = new BigDecimal("1.50");
        returnedValue = service.doWeDispenseChange(candyOne, cashInserted);
       
        assertTrue(returnedValue, "We need to return change.");
        
        // test the unlikely event! (not enought money was given)
        cashInserted = new BigDecimal("0.01");

        try {
            returnedValue = service.doWeDispenseChange(candyOne, cashInserted);
            fail("No Exception was thrown.");
        } catch (NotEnoughCashInsertedException e) {
            // do nothing
        }
 
    }
}
