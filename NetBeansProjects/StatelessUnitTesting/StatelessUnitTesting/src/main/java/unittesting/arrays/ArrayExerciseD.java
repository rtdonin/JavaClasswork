/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.arrays;

import static java.lang.Double.parseDouble;
import java.util.Arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseD {
    
    /*
    * Given an array of doubles, return the biggest number of the lot, as if the decimal had gone missing!
    *
    * pointFree( [1.1, .22]  ) ->  22
    * pointFree( [ .039, 20, .005005 ]  ) ->  5005
    * pointFree( [ -9.9, -700, -.5  ]  ) ->  -5
    * 
    * @param numbers
    * @return int
    */
    public static int pointFree(double[] numbers){
        for(int i = 0; i < numbers.length; i++){
            String numString = String.valueOf(numbers[i]);
            String[] numDecimalRemoved = numString.split(".");
            numString = Arrays.toString(numDecimalRemoved);
            numbers[i] = parseDouble(numString);
        }
        
        double greatest = numbers[0];
        
        for(double index : numbers){
            if(index > greatest) {
                greatest = index;
            }
        }
        
        int numOfInterest = (int) greatest;
        
        return numOfInterest;
    }
    
}
