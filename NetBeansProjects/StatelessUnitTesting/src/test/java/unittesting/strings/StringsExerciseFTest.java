/*
Created by: Margaret Donin
Date created: 05/28/20
Date revised:
*/

package unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.strings.StringsExerciseF.longestWord;

public class StringsExerciseFTest {
    
    public StringsExerciseFTest() {
    }

    @Test
    public void longestWordTestOne() {
        // Arrange
        String phrase = "Invention my dear friends is 93% perspiration 6% electricity 4% evaporation and 2% butterscotch ripple";
        String expResult = "perspiration";
        
        // Act
        String result = longestWord(phrase);
        
        // Assert
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void longestWordTestTwo() {
        // Arrange
        String phrase = "All well-established principles should be periodically challenged";
        String expResult = "well-established";
        
        // Act
        String result = longestWord(phrase);
        
        // Assert
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void longestWordTestThree() {
        // Arrange
        String phrase = "Never argue with the data";
        String expResult = "Never";
        
        // Act
        String result = longestWord(phrase);
        
        // Assert
        assertEquals(expResult, result);
        
    }
}
