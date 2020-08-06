package unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.logic.LogicExerciseB.placeOf;

public class LogicExerciseBTest {
    
    public LogicExerciseBTest() {
    }

    @Test
    public void placeOfTestFirst() {
        // Arrange
        int place = 1;
        
        // Act
        String result = placeOf(place);
        String expResult = "1st";
        
        // Assert
        
        assertEquals(expResult, result);        
    }
    
    @Test
    public void placeOfTestThird() {
        // Arrange
        int place = 3;
        
        // Act
        String result = placeOf(place);
        String expResult = "3rd";
        
        // Assert
        
        assertEquals(expResult, result);       
    }
    
    @Test
    public void placeOfTestTwentySecond() {
        // Arrange
        int place = 22;
        
        // Act
        String result = placeOf(place);
        String expResult = "22nd";
        
        // Assert
        
        assertEquals(expResult, result);       
    }
    
    @Test
    public void placeOfTestHundreth() {
        // Arrange
        int place = 100;
        
        // Act
        String result = placeOf(place);
        String expResult = "100th";
        
        // Assert
        
        assertEquals(expResult, result);       
    }
    
}
