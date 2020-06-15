/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.arrays;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.arrays.ArrayExerciseB.multiplyAll;

/*
* multiplyAll( 5, [ 1, 2, 3, 4, 5 ] ) ->  [ 5, 10, 15, 20, 25 ]
* multiplyAll( 0, [ 1, 1, 1, 1, 1, 1, 1, 1, 1 ] ) ->  [  ]
* multiplyAll( -1, [ -2, 0, 0, 1 ] ) ->  [ 2, 0, 0, -1 ]
*/

public class ArrayExerciseBTest {
    
    public ArrayExerciseBTest() {
    }

    @Test
    public void multiplyAllTestNormal() {
        // Arrange
        int[] numbers = {1, 2, 3, 4, 5};
        int multiplier = 5;
        
        // Act
        int[] result = multiplyAll(multiplier, numbers);
        int[] expResult = {5, 10, 15, 20, 25};
        
        // Assert
        assertEquals(Arrays.toString(expResult), Arrays.toString(result));
    }
    
    @Test
    public void multiplyAllTestZeros() {
        // Arrange
        int[] numbers = {1, 1, 1, 1, 1, 1, 1, 1, 1};
        int multiplier = 0;
        
        // Act
        int[] result = multiplyAll(multiplier, numbers);
        int[] expResult = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        // Assert
        assertEquals(Arrays.toString(expResult), Arrays.toString(result));
    }
    
    @Test
    public void multiplyAllTestNegativeMultiplier() {
        // Arrange
        int[] numbers = {-2, 0, 0, 1};
        int multiplier = -1;
        
        // Act
        int[] result = multiplyAll(multiplier, numbers);
        int[] expResult = {2, 0, 0, -1};
        
        // Assert
        assertEquals(Arrays.toString(expResult), Arrays.toString(result));
    }
}
