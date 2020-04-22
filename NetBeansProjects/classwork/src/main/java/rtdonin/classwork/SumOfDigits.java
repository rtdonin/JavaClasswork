/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised:
*/

package rtdonin.classwork;

import java.util.Scanner;

public class SumOfDigits{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Please enter a positive integer: ");
        int userNum = input.nextInt();
        int i = 0;
        
        while (userNum > 0){
            i += (userNum % 10);
            userNum /= 10;
        }
        
        System.out.println("\nYou entered: " + userNum);
        System.out.println("Your sum: " + i);
//    1. prompt user to enter a positive integer
//    2. store input as int
//    3. declare/initialize var to 0.
//    4. Start loop (as long as data entered is greater than zero)
//        var = var + (user input % 10)
//        user input = user input / 10
//    5. end loop
//    6. print user input
//    7. print sum
    }
}