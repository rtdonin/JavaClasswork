/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:
*/

package GuessMe;

import java.util.Scanner;

public class GuessMe{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int myNumber = 14;
        int guessedNumber;
        
        System.out.println("I've chosen a number. Betcha can't guess it!");
        System.out.print("Your Guess: ");
        guessedNumber = input.nextInt();

        if (guessedNumber == myNumber){
            System.out.println("\nWow, nice guess! That was it!");
        } else if (guessedNumber > myNumber){
            System.out.println("\nHa, nice try - too low! I chose " + myNumber + ".");
        } else if (guessedNumber < myNumber){
            System.out.println("\nToo bad, way too high. I chose " + myNumber + ".");
        }
                


    }
}