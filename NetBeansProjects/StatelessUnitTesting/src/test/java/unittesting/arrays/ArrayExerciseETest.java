/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.arrays;

import static unittesting.arrays.ArrayExerciseE.camelCaseIt;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
* Given an array of words turn it into a single camelCased phrase.
* Lower case the first word, capitalize the first letter (but only the first) of the rest.
*
* camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
* camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
* camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
*/
public class ArrayExerciseETest {
    
    public ArrayExerciseETest() {
    }

    @Test
    public void camelCaseItTest1() {
        // ARRANGE
        String[] array = {"llama", "llama", "duck"};
        String expResult = "llamaLlamaDuck";
        
        // ACT - 
        String result = camelCaseIt(array);
        
        // ASSERT
        assertEquals(expResult, result);
    }

    @Test
    public void camelCaseItTest2() {
        // ARRANGE
        String[] array = {"lambs", "eat", "oats", "and", "does", "eat", "oats"};
        String expResult = "lambsEatOatsAndDoesEatOats";
        
        // ACT - 
        String result = camelCaseIt(array);
        
        // ASSERT
        assertEquals(expResult, result);
    }
    
    @Test
    public void camelCaseItTest3() {
        // ARRANGE
        String[] array = {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"};
        String expResult = "doOrDoNotThereIsNoTry";
        
        // ACT
        String result = camelCaseIt(array);
        
        // ASSERT
        assertEquals(expResult, result);
    }
    
}
