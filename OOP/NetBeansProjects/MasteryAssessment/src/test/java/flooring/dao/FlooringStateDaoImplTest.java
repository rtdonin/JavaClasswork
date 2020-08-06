/*
Created by: Margaret Donin
Date created: 06/26/20
Date revised:
*/

package flooring.dao;

import flooring.dto.State;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FlooringStateDaoImplTest {
    
    private FlooringStateDao testDao;
    
    public FlooringStateDaoImplTest() {

    }
    
    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "TestFile//StateTest.txt";
        String header = "State,StateName,TaxRate";

        PrintWriter out = new PrintWriter(new FileWriter(testFile));
        out.println(header);
        out.flush();
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
        this.testDao = ctx.getBean("stateDao", FlooringStateDao.class);
    }

    @Test
    public void getAllStatesTest() throws Exception {
        String abbrevOne = "LA";
        State stateOne = new State(abbrevOne, "Louisiana", new BigDecimal("4.45"));
        
        String abbrevTwo = "ND";
        State stateTwo = new State(abbrevTwo, "North Dakota", new BigDecimal("5.00"));
        
        testDao.addState(stateOne);
        testDao.addState(stateTwo);
        
        Map<String, State> received = testDao.getAllStates();
        
        assertNotNull(received, "Map should not be null.");
        assertEquals(received.size(), 2, "There should only be two states on the list.");
        assertEquals(received.get(abbrevOne), stateOne, "Louisiana should be in the map");
        assertEquals(received.get(abbrevTwo), stateTwo, "North Dakota should be in the map.");
    }
    
    @Test
    public void getStateTest() throws Exception {
        String abbrevOne = "LA";
        State stateOne = new State(abbrevOne, "Louisiana", new BigDecimal("4.45"));
        
        testDao.addState(stateOne);
        
        State received = testDao.getState(abbrevOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, stateOne, "Both states should be Louisiana.");
        assertEquals(received.getStateName(), stateOne.getStateName(), "Checking state name.");
        assertEquals(received.getStateAbbreviation(), stateOne.getStateAbbreviation(), "Checking state abbreviation.");
        assertEquals(received.getTaxRate(), stateOne.getTaxRate(), "Checking tax rate.");
    }
    
    @Test
    public void addStateTest() throws Exception {
        String abbrevOne = "LA";
        State stateOne = new State(abbrevOne, "Louisiana", new BigDecimal("4.45"));
        
        // Make sure it's not in the file.
        State received = testDao.getState(abbrevOne);
        assertNull(received, "Should be null.");

        testDao.addState(stateOne);
        
        // See if it actually got added.
        received = testDao.getState(abbrevOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, stateOne, "Both states should be Louisiana.");
        assertEquals(received.getStateName(), stateOne.getStateName(), "Checking state name.");
        assertEquals(received.getStateAbbreviation(), stateOne.getStateAbbreviation(), "Checking state abbreviation.");
        assertEquals(received.getTaxRate(), stateOne.getTaxRate(), "Checking tax rate.");
    }
    
    @Test
    public void editStateTest() throws Exception {
        String abbrevOne = "LA";
        State stateOne = new State(abbrevOne, "Louisiana", new BigDecimal("4.45"));
        
        testDao.addState(stateOne);
        
        State received = testDao.getState(abbrevOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, stateOne, "Both states should be Louisiana.");
        assertEquals(received.getStateName(), stateOne.getStateName(), "Checking state name.");
        assertEquals(received.getStateAbbreviation(), stateOne.getStateAbbreviation(), "Checking state abbreviation.");
        assertEquals(received.getTaxRate(), stateOne.getTaxRate(), "Checking tax rate.");
        
        stateOne.setTaxRate(new BigDecimal("3.00"));

        // Making sure the edit method function returns the edited State
        received = testDao.editState(stateOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, stateOne, "Both states should be Louisiana.");
        // checking the only thing we changed.
        assertEquals(received.getTaxRate(), stateOne.getTaxRate(), "Checking tax rate.");
        
        // Making sure the file has the edited State
        received = testDao.getState(abbrevOne);
        
        assertNotNull(received, "Should be not null.");
        assertEquals(received, stateOne, "Both states should be Louisiana.");
        // checking the only thing we changed.
        assertEquals(received.getTaxRate(), stateOne.getTaxRate(), "Checking tax rate.");
    }
    
    @Test
    public void removeStateTest() throws Exception {
        String abbrevOne = "LA";
        State stateOne = new State(abbrevOne, "Louisiana", new BigDecimal("4.45"));
        
        String abbrevTwo = "ND";
        State stateTwo = new State(abbrevTwo, "North Dakota", new BigDecimal("5.00"));
        
        testDao.addState(stateOne);
        testDao.addState(stateTwo);
        
        Map<String, State> received = testDao.getAllStates();
        
        assertNotNull(received, "Map should not be null.");
        assertEquals(received.size(), 2, "There should only be two states on the list.");
        assertEquals(received.get(abbrevOne), stateOne, "Louisiana should be in the map");
        assertEquals(received.get(abbrevTwo), stateTwo, "North Dakota should be in the map.");
        
        State receivedState = testDao.removeState(stateOne);
        
        assertNotNull(receivedState, "Should be not null.");
        assertEquals(receivedState, stateOne, "Both states should be Louisiana.");
        assertEquals(receivedState.getStateName(), stateOne.getStateName(), "Checking state name.");
        assertEquals(receivedState.getStateAbbreviation(), stateOne.getStateAbbreviation(), "Checking state abbreviation.");
        assertEquals(receivedState.getTaxRate(), stateOne.getTaxRate(), "Checking tax rate.");
        
        received = testDao.getAllStates();
        
        assertNotNull(received, "Map should not be null.");
        assertEquals(received.size(), 1, "There should only be one states on the list.");
        assertNull(received.get(abbrevOne), "Louisiana should not be in the map");
        assertEquals(received.get(abbrevTwo), stateTwo, "North Dakota should be in the map.");
        
    }
}
