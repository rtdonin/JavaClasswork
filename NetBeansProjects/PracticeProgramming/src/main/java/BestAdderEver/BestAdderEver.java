/*
Created by: Margaret Donin
Date created: 04/14/20
Date revised:
*/

package BestAdderEver;

import java.util.Scanner;

public class BestAdderEver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        float numberOne, numberTwo, numberThree, sum;
        String stringNumberOne;
        String stringNumberTwo;
        String stringNumberThree;
        
        System.out.println("Please enter a number to add:");
        stringNumberOne = scan.nextLine();
        System.out.println("Please enter a second number to add:");
        stringNumberTwo = scan.nextLine();
        System.out.println("Please enter a third number to add:");
        stringNumberThree = scan.nextLine();
        
        numberOne = Float.parseFloat(stringNumberOne);
        numberTwo = Float.parseFloat(stringNumberTwo);
        numberThree = Float.parseFloat(stringNumberThree);
        
        sum = numberOne + numberTwo + numberThree;
        
        System.out.println(stringNumberOne + " + " + stringNumberTwo + " + " + stringNumberThree + " = " + sum + ".");
    }
}