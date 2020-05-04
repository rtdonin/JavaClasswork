/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised: 04/23/20
*/

package M1.Random;

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomNumber = new Random();
        int myNumber = randomNumber.nextInt(200) - 100;
        int guessedNumber;
        
        System.out.println("I've chosen a number. Betcha can't guess it!");
        System.out.print("Your Guess: ");
        guessedNumber = input.nextInt();

        if (guessedNumber == myNumber){
            System.out.println("\nWow, nice guess! That was it!");
        } else if (guessedNumber < myNumber){
            System.out.println("\nHa, nice try - too low!");
            System.out.print("Try again: ");
            guessedNumber = input.nextInt();
            
            if (guessedNumber == myNumber){
                System.out.println("\nWow, nice guess! That was it!");
            } else {
                System.out.println("Still wrong! I chose " + myNumber + ".");
            }

        } else if (guessedNumber > myNumber){
            System.out.println("\nToo bad, way too high.");
            System.out.print("Try again: ");
            guessedNumber = input.nextInt();
            
            if (guessedNumber == myNumber){
                System.out.println("\nWow, nice guess! That was it!");
            } else {
                System.out.println("Still wrong! I chose " + myNumber + ".");
            }
        }
        
    }
}