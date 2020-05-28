/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.arrays;

import static unittesting.arrays.ArrayExerciseA.maxOfArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/*
* maxOfArray( {1}  ) ->  1
* maxOfArray( {3,4,5}  ) ->  5
* maxOfArray( {-9000, -700, -50, -3}  ) ->  -3
*/
public class ArrayExerciseATest {
    
    public ArrayExerciseATest() {
    }

    @Test
    public void maxOfArrayOneElement() {
        // Arrange
        int[] numbers = {1};
        
        // Act
        int result = maxOfArray(numbers);
        int expResult = 1;
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void maxOfArrayNormalCase() {
        // Arrange
        int[] numbers = {3, 4, 5};
        
        // Act
        int result = maxOfArray(numbers);
        int expResult = 5;
        
        // Assert
        assertEquals(expResult, result);
    }
    
    @Test
    public void maxOfArrayNegativeElements() {
        // Arrange
        int[] numbers = {-9000, -700, -50, -3};
        
        // Act
        int result = maxOfArray(numbers);
        int expResult = -3;
        
        // Assert
        assertEquals(expResult, result);
    }
    
}
