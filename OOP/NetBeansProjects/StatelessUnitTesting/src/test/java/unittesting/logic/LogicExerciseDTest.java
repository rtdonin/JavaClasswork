/*
Created by: Margaret Donin
Date created: 05/28/20
Date revised:
*/
package unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.logic.LogicExerciseD.isFirstTheFirst;

public class LogicExerciseDTest {
    
    public LogicExerciseDTest() {
    }

    @Test
    public void isFirstTheFirstabTest() {
        
        // Arrange
        char letterOne = 'a';
        char letterTwo = 'b';
        
        // Act
        boolean result = isFirstTheFirst(letterOne, letterTwo);
        
        // Assert
        assertTrue(result);
        
    }
    
    @Test
    public void isFirstTheFirstOXTest() {
        
        // Arrange
        char letterOne = 'O';
        char letterTwo = 'X';
        
        // Act
        boolean result = isFirstTheFirst(letterOne, letterTwo);
        
        // Assert
        assertTrue(result);
        
    }
    
    @Test
    public void isFirstTheFirstZzTest() {
        
        // Arrange
        char letterOne = 'Z';
        char letterTwo = 'z';
        
        // Act
        boolean result = isFirstTheFirst(letterOne, letterTwo);
        
        // Assert
        assertFalse(result);
        
    }
    
}
