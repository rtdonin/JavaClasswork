/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised:
*/

package M1.Arrays;

public class SimpleCombination {
    public static void main(String[] args) {
        int[] firstHalf = {3, 7, 9, 10, 16, 19, 20, 34, 35, 45, 47, 49}; // 12 numbers
        int[] secondHalf = {51, 54, 68, 71, 75, 78, 82, 84, 85, 89, 91, 100}; // also 12!

        int[] wholeNumbers = new int[24];
//        int j = 0;

//        for (int i = 0; i < (firstHalf.length + secondHalf.length); i++){
//            if (i < firstHalf.length){
//                wholeNumbers[i] = firstHalf[i];
//            } else{
//                wholeNumbers[i] = secondHalf[j];
//                j++;
//            }
//        }

        // the better way:
        wholeNumbers = addArray(firstHalf, wholeNumbers);
        wholeNumbers = addArray(secondHalf, wholeNumbers);
        // better because I can add multiple arrays of non-zero numbers.
        
        System.out.println("All together now!:");
        for (int i = 0; i < wholeNumbers.length; i++){
            System.out.print(wholeNumbers[i] + " ");
        }

    }
    
    public static int[] addArray(int[] arrayToAdd, int[] newArray){
        int adjustIndex = 0;
        
        for (int i = 0; i < arrayToAdd.length; i++){
            while (newArray[adjustIndex + i] != 0){
                adjustIndex++;
            }
            
            newArray[i+adjustIndex] = arrayToAdd[i];
        }
        return newArray;
    }
}