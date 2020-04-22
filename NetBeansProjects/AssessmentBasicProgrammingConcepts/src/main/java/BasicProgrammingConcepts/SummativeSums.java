/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:

Purpose: add arrays using a method outside of the main method

Expected output:

#1 Array Sum: 42
#2 Array Sum: 1337
#3 Array Sum: 2001    

*/

package BasicProgrammingConcepts;

public class SummativeSums{
    public static void main(String[] args) {
        int[] arrayOne = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] arrayTwo = {999, -60, -77, 14, 160, 301};
        int[] arrayThree = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120, 130,
            140, 150, 160, 170, 180, 190, 200, -99};
    
        System.out.println("#1 Array Sum: " + addArray(arrayOne));
        System.out.println("#2 Array Sum: " + addArray(arrayTwo));
        System.out.println("#3 Array Sum: " + addArray(arrayThree));
    }
    
    public static int addArray(int[] array){
        int sum = 0;
        
        for (int element : array){
            sum += element;
        }

        return sum;
    }
}