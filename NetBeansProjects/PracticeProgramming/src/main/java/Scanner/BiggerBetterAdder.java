/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:

I originally wrote it to take the user values instead of hard coding the values.
All I'm going to do is change it from taking a float to using only ints.
*/

package Scanner;

import java.util.Scanner;

public class BiggerBetterAdder{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int numberOne, numberTwo, numberThree, sum;

        System.out.println("Please enter a number to add:");
        numberOne = scan.nextInt();

        System.out.println("Please enter a second number to add:");
        numberTwo = scan.nextInt();

        System.out.println("Please enter a third number to add:");
        numberThree = scan.nextInt();
        
        sum = numberOne + numberTwo + numberThree;
        
        System.out.println(numberOne + " + " + numberTwo + " + " + numberThree + " = " + sum + ".");
    }
}