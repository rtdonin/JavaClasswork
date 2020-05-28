/*
Created by: Margaret Donin
Date created: 05/27/20
Date revised:

pointFree( [1.1, .22]  ) ->  22
pointFree( [ .039 , 20 , .005005 ]  ) ->  5005
pointFree( [ -9.9 , -700 , -.5  ]  ) ->  -5
*/
package unittesting.arrays;

import static unittesting.arrays.ArrayExerciseD.pointFree;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayExerciseDTest {
    
    public ArrayExerciseDTest() {
    }

    @Test
    public void pointFreeTestOne() {
        // ARRANGE
        double[] arr = {1.1, .22};
        int expResult = 22;
        
        // ACT
        int result = pointFree(arr);
        
        // ASSERT
        assertEquals(expResult, result);
    }
    
    @Test
    public void pointFreeTestTwo() {
        // ARRANGE
        double[] arr = {.039, 20, .005005};
        int expResult = 5005;
        
        // ACT
        int result = pointFree(arr);
        
        // ASSERT
        assertEquals(expResult , result);
    }
    
    @Test
    public void pointFreeTestThree() {
        // ARRANGE
        double[] arr = {-9.9, -700, -.5};
        int expResult = -5;
        
        // ACT - 
        int result = pointFree(arr);
        
        // ASSERT
        assertEquals(expResult, result);
    }
    
}
