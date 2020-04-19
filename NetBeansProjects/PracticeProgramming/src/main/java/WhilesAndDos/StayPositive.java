/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:
*/

package WhilesAndDos;

import java.util.Scanner;

public class StayPositive {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;
        int newLine = 0;
        System.out.print("What number would you like to count down from? ");
        x = scan.nextInt();
        
        System.out.println("\nHere goes !\n");
 
        while (x >= 0){
            System.out.print(x + " ");
            x--;
            newLine++;
            if (newLine % 10 == 0){
                System.out.println("");
            }
        }
        
        System.out.println("\nBlast off!");
    }
}