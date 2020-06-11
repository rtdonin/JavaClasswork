/*
Created by: Margaret Donin
Date created: 06/09/20
Date revised:

Notes:
We rely on the fact that my inventory file always has some text.
We never remove or add lines to it. Therefore before each test, we
rewrite the file to have two known strings and therefore known
candy objects.

Methods we are testing:
Map<String, Candy> getAllCandy()
Candy editCandy(Candy)
Candy getCandy(String name)
*/

package M3.vendingmachine.dao;

import M3.vendingmachine.dto.Candy;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineDaoImplTest {

    VendingMachineDao testDao;
    
    public VendingMachineDaoImplTest() {
    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testvendingmachine.txt";

        try {
            PrintWriter out = new PrintWriter(new FileWriter(testFile));
            
            // write known Candy to file
            out.println("Whatchamacallit::1.23::1");
            out.flush();
            
            out.println("Snickers::0.73::0");
            out.flush();
            
        } catch (IOException e) {
            throw new IOException("Could not write to file.");
        }
        testDao = new VendingMachineDaoImpl(testFile);
    }
    
    @Test
    public void testGetAllCandy() throws VendingMachinePersistenceException {
        // create our own known candy that is in the file
        String nameOne = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.23");
        int inventory = 1;
        Candy candyOne = new Candy(nameOne, price, inventory);

        String nameTwo = "Snickers";
        price = new BigDecimal("0.73");
        inventory = 0;
        Candy candyTwo = new Candy(nameTwo, price, inventory);

        // get the map
        Map<String, Candy> candyMap = testDao.getAllCandy();

        // check general contents
        assertNotNull(candyMap, "All candy map should not be null.");
        assertEquals(2, candyMap.size(), "There should only be two candies.");

        // Check the specifics
        assertTrue(candyMap.containsKey(nameOne), "The map should contain a key for Whatchamacallit.");
        assertTrue(candyMap.containsKey(nameTwo), "The map should contain a key for Snickers.");
        assertEquals(candyMap.get(nameOne), candyOne, "The map should contain a Whatchamacallit.");
        assertEquals(candyMap.get(nameTwo), candyTwo, "The map should contain a Snickers.");

    }
    
    @Test
    public void testEditCandy() throws VendingMachinePersistenceException {
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.23");
        int inventory = 1;
        Candy candy = new Candy(name, price, inventory);

        // Really check that candyOne is in the Map
        Map<String, Candy> candyMap = testDao.getAllCandy();
        Candy candyFromMap = candyMap.get(name);
        assertEquals(candy.toString(), candyFromMap.toString(), "The strings should be the same.");

        // edit our candyOne for testing
        candy.setInventory(300);

        // Edit Candy
        Candy candyReceived = testDao.editCandy(candy);

        assertEquals(candy.toString(), candyReceived.toString(), "The strings should be the same.");
        // Argument could be made based on my toString() method that I don't need to do the following tests.
        assertEquals(candy.getName(), candyReceived.getName(), "Names should be equal.");
        assertEquals(candy.getPrice(), candyReceived.getPrice(), "Prices should be equal.");
        assertEquals(candy.getInventory(), candyReceived.getInventory(), "Inventory should be equal.");

    }

    @Test
    public void testGetCandy() throws VendingMachinePersistenceException {
        // Create our candy
        String name = "Whatchamacallit";
        BigDecimal price = new BigDecimal("1.23");
        int inventory = 1;
        Candy candyOne = new Candy(name, price, inventory);

        // Get the Candy of interest
        Candy candyReceived = testDao.getCandy(name);

        // Test the Candy! ....without eating it D:
        assertEquals(candyOne.getName(), candyReceived.getName(), "Names should be equal.");
        assertEquals(candyOne.getPrice(), candyReceived.getPrice(), "Prices should be equal.");
        assertEquals(candyOne.getInventory(), candyReceived.getInventory(), "Inventory should be equal.");

        // What happens if I ask for a Candy that isn't there?
        name = "Bubblegum";
        candyReceived = testDao.getCandy(name);

        // check to make sure it doesn't work
        assertNull(candyReceived, "There should be no bubblegum.");
    }
}
