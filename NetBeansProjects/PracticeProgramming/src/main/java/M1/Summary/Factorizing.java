/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised:
*/

package M1.Summary;

import java.util.Scanner;

public class Factorizing{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int userNum;
        int[] factors;
        String perfect;
        String prime;
        
        System.out.print("What number would you like to factor? ");
        userNum = input.nextInt();
        if (userNum <= 0){
            System.out.println("That was not a whole number, please try again!");
            System.exit(0);
        }
        factors = getFactors(userNum);

        // if the array only has two values it's a prime
        prime = (factors.length > 2)? "not " : "";
        perfect = (isItPerfect(factors))? "" : "not ";
        
        
        System.out.println("\nThe factors of " + userNum + " are:");
        printOutArray(factors);
        System.out.println(userNum + " has " + factors.length + " factors.");
        System.out.println(userNum + " is "+ perfect +"a perfect number.");
        System.out.println(userNum + " is "+ prime +"a prime number.");                
    }
    
    public static int[] getFactors(int input){
        int[] arr = {1, input};
        int[] temp = arr;
        
        if (input < 4){
            return arr;
        }
        
        for (int i = 2; i <= input; i++){
            if (input % i == 0){
                if(arr[1] == input){
                    arr[1] = i;
                    temp = arr;
                } else{
                    arr = new int[arr.length + 1];
                    for (int j = 0; j < temp.length; j++){
                        arr[j] = temp[j];
                    }
                    arr[temp.length] = i;
                    temp = new int[arr.length];
                    temp = arr;
                }
            }
        }
        return arr;
    }
    
    public static boolean isItPerfect(int[] array){
        int sum = 0;
        boolean isIt;
        
        for (int i = 0; i < array.length-1; i++){
            sum += array[i];
        }
        
        isIt = (sum == array[array.length - 1]);
        
        return isIt;
    }
    
    public static void printOutArray(int[] array){
        for (int element : array){
            System.out.print(element + " ");
        }
    }
}