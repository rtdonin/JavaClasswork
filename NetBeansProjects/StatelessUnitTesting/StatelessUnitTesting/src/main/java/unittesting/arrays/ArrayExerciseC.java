/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.arrays;

import java.util.Arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseC {

    /*
    * Given an array of integers, return them all as a single continuous text value.
    * 
    * stringThemTogether( { 1, 3, 3, 7 }  ) ->  "1337"
    * stringThemTogether( { 1, 33, 555, 7777, 99999 } ) ->  "133555777799999"
    * stringThemTogether( { }  ) ->  ""
    * 
    * @param nums
    * @return String
    */
    
    public static String stringThemTogether(int[] nums){
        String concat = "";
        
        for(int index : nums) {
            concat += String.valueOf(index);
        }
        
        return concat;
    }
    
}
