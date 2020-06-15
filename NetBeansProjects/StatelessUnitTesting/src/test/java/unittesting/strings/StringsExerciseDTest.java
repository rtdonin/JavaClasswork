/*
Created by: Margaret Donin
Date created: 05/28/20
Date revised:
*/

package unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.strings.StringsExerciseD.simpleReverse;

public class StringsExerciseDTest {
    
    public StringsExerciseDTest() {
    }

    @Test
    public void simpleReverseTestTwoWords() {
        // Arrange
        String phrase = "fun times";
        String expResult = "semit nuf";
        
        // Act
        String result = simpleReverse(phrase);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void simpleReverseTestThreeWords() {
        // Arrange
        String phrase = "llama llama duck";
        String expResult = "kcud amall amall";
        
        // Act
        String result = simpleReverse(phrase);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void simpleReverseTestOneWord() {
        // Arrange
        String phrase = "hannah";
        String expResult = "hannah";
        
        // Act
        String result = simpleReverse(phrase);
        
        // Assert
        assertEquals(expResult, result);
    }
    
}
