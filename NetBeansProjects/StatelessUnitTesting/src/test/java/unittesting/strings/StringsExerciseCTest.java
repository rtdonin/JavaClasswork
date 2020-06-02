/*
Created by: Margaret Donin
Date created: 05/28/20
Date revised:
*/

package unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.strings.StringsExerciseC.removeTheVowels;

public class StringsExerciseCTest {
    
    public StringsExerciseCTest() {
    }

    @Test
    public void testRemoveTheVowelsOne() {
        // Arrange
        String theWord = "truncate";
        String expResult = "trnct";
        
        // Act
        String result = removeTheVowels(theWord);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveTheVowelsTwo() {
        // Arrange
        String theWord = "squashed";
        String expResult = "sqshd";
        
        // Act
        String result = removeTheVowels(theWord);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testRemoveTheVowelsThree() {
        // Arrange
        String theWord = "compressed";
        String expResult = "cmprssd";
        
        // Act
        String result = removeTheVowels(theWord);
        
        // Assert
        assertEquals(expResult, result);
    }
    
}
