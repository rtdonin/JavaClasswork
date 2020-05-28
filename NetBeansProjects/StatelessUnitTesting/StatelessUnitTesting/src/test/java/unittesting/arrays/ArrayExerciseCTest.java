/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.arrays.ArrayExerciseC.stringThemTogether;

public class ArrayExerciseCTest {
    
    public ArrayExerciseCTest() {
    }

    @Test
    public void stringThemTogetherNomralTest() {
        // Arrange
        int[] num = {1, 3, 3, 7};
        
        // Act
        String result = stringThemTogether(num);
        String expResult = "1337";
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void stringThemTogetherLargerNumbersTest() {
        // Arrange
        int[] num = {1, 33, 555, 7777, 99999};
        
        // Act
        String result = stringThemTogether(num);
        String expResult = "133555777799999";
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void stringThemTogetherEmptyArrayTest() {
        // Arrange
        int[] num = {};
        
        // Act
        String result = stringThemTogether(num);
        String expResult = "";
        
        // Assert
        assertEquals(expResult, result);
    }
}
