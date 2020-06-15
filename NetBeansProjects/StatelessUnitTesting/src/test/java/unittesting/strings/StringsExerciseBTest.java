package unittesting.strings;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.strings.StringsExerciseB.tripleIt;

public class StringsExerciseBTest {
    
    public StringsExerciseBTest() {
    }

    @Test
    public void testTripleItOne() {
        // Arrange
        String toTriple = "Llama";
        String expResult = "llamaLLAMAllama";
        
        // Act
        String result = tripleIt(toTriple);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testTripleItTwo() {
        // Arrange
        String toTriple = "ha";
        String expResult = "haHAha";
        
        // Act
        String result = tripleIt(toTriple);
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void testTripleItThree() {
        // Arrange
        String toTriple = "Beetlejuice";
        String expResult = "beetlejuiceBEETLEJUICEbeetlejuice";
        
        // Act
        String result = tripleIt(toTriple);
        
        // Assert
        assertEquals(expResult, result);
    }
    
}
