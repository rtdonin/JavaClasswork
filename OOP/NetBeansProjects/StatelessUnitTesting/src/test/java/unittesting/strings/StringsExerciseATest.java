/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.strings.StringsExerciseA.yell;


public class StringsExerciseATest {
    
    public StringsExerciseATest() {
    }

    @Test
    public void testYellPhrase() {
        // Arrange
        String toYell = "Hello there.";
        String expResult = "HELLO THERE.";
        
        // Act
        String result = yell(toYell);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testYellLowerCase() {
        // Arrange
        String toYell = "shhhhhhhhhhhh";
        String expResult = "SHHHHHHHHHHHH";
        
        // Act
        String result = yell(toYell);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testYellMixCase() {
        // Arrange
        String toYell = "AAaAAAaAAAaaAAHHHH";
        String expResult = "AAAAAAAAAAAAAAHHHH";
        
        // Act
        String result = yell(toYell);
        
        // Assert
        assertEquals(expResult, result);
    }

}
