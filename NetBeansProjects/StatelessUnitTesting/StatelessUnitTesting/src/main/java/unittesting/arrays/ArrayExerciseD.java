/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.arrays;

import static java.lang.Double.parseDouble;

public class ArrayExerciseD {
    public static void main(String[] args) {
        double[] arr = {.039, 20, .005005};
        
        System.out.println(pointFree(arr));
    }
    /*
    * Given an array of doubles, return the biggest number of the lot, as if the decimal had gone missing!
    *
    * pointFree( [1.1, .22]  ) ->  22
    * pointFree( [.039, 20, .005005]  ) ->  5005
    * pointFree( [ -9.9, -700, -.5  ]  ) ->  -5
    * 
    * @param numbers
    * @return int
    */
    
    public static int pointFree(double[] numbers) {
        for(int i = 0; i < numbers.length; i++){
            double element = numbers[i];
            String num = String.valueOf(element);
            boolean found = false;
            int length = num.length();
            
            for(int j = 0; j < length && !found; j++) {
                if(num.charAt(j) == '.') {
                    element *= Math.pow(10, length - j - 1);
                    found = true;
                }
            }
            numbers[i] = element;
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
