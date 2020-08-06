/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.strings.StringsExerciseE.containsTheOther;

/**
      * containsTheOther( "one", "tone" ) ->  true
     * containsTheOther( "same", "same" ) ->  false
     * containsTheOther( "fancypants", "pants" ) ->  true
     * containsTheOther( "llama", "duck" ) ->  false
 */
public class StringsExerciseETest {
    
    public StringsExerciseETest() {
    }

    @Test
    public void containsTheOtherTextContains() {
        // Arrange
        String one = "one";
        String two = "tone";
        
        // Act
        boolean result = containsTheOther(one, two);
        
        // Assert
        assertTrue(result);
        
    }
    
    @Test
    public void containsTheOtherTextSame() {
        // Arrange
        String one = "same";
        String two = "same";
        
        // Act
        boolean result = containsTheOther(one, two);
        
        // Assert
        assertFalse(result);
        
    }
    
    @Test
    public void containsTheOtherTextDifferent() {
        // Arrange
        String one = "llama";
        String two = "duck";
        
        // Act
        boolean result = containsTheOther(one, two);
        
        // Assert
        assertFalse(result);
        
    }
    
}
