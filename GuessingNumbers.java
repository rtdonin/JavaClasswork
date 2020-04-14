/*
Created By: Margaret Donin
Date Created: 04/13/20
Date Revised:

exercise:
Create a Guessing game
-produce a random number 0<number<100
-let user guess the number
-for each guess....
- respond with
    too low
    too hign
    correct
    respond with total number of guesses


*/

import java.util.*;

public class GuessingNumbers {
	public static void main (String[] args)  {
        Scanner scan = new Scanner(System.in);

        Random rand = new Random();

        int randomNumber = rand.nextInt(99);
        int numberOfGuesses = 0;

        System.out.println("Guess a number between 0 and 100!");
        int guess = scan.nextInt();

        for (int i = 1; randomNumber != guess; i++) {
            if (randomNumber > guess) {
                System.out.println("Guess again! The number is higher.");
                guess = scan.nextInt();
            } else if (randomNumber < guess) {
                System.out.println("Guess again! The number is lower.");
                guess = scan.nextInt();
            }

            numberOfGuesses = i;
        }
        scan.close();

        if (randomNumber == guess){
            System.out.println("Correct! Only took you " + numberOfGuesses + " tries.");
        }
	}
}