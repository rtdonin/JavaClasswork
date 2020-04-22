/*
Created by: Margaret Donin
Date created: 04/21/20
Date revised:
*/

package BasicProgrammingConcepts;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {

        boolean areWePlaying = true;
        int totalRounds;

        // unless we change areWePlaying to false, we keep playing.
        while (areWePlaying){
            totalRounds = startGame();
            areWePlaying = playGame(totalRounds);
            // plays game and then checks if
        }
        System.out.println("\nThank you for playing!");
    }
    
    public static int startGame(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many rounds would you like to play? ");
        int totalRounds = input.nextInt();

        // When to give us an error
        if (totalRounds < 1 || totalRounds > 10){
            System.out.println("ERROR!!!!");
            System.exit(0);
        }
        return totalRounds;
    }
    
    public static boolean playGame(int totalRounds){
        Scanner input = new Scanner(System.in);
        Random randomValue = new Random();

        int userPlay; // what the user plays this round
        int computerPlay; // what the computer plays this round
        int roundsTied = 0;
        int roundsUserWon = 0;
        int roundsComputerWon;
        boolean keepPlaying;

        for(int currentRound = 1; currentRound <= totalRounds; currentRound++){
            System.out.println("\nChoose: (1) Rock, (2) Paper, or (3) Scissors");
            userPlay = input.nextInt();

            // 1. rock 2. paper 3. scissors
            computerPlay = randomValue.nextInt(3) + 1;

            // game logic (what beats what)
            if (userPlay == computerPlay){
                roundsTied++;
                System.out.println("Round was a tie!");
            } else {
                roundsUserWon = whoWon(userPlay, computerPlay, roundsUserWon);
            }

            roundsComputerWon = currentRound - roundsUserWon - roundsTied;

            // prints Round information
            System.out.println("\nRound " + currentRound);
            System.out.println("Number of rounds user won: " + roundsUserWon);
            System.out.println("Number of rounds computer won: " + roundsComputerWon);
            System.out.println("Number of rounds tied: " + roundsTied);
        }

        keepPlaying = checkPlay(); // are we playing another game?
        
        return keepPlaying;
    }

    public static int whoWon(int user, int comp, int userWon){
        String roundResult = "";

        // 1. rock 2. paper 3. scissors
        switch(user){
            case 1:
                roundResult = (comp == 2) ? "You Lost." : "You won!";
                break;
            case 2:
                roundResult = (comp == 3) ? "You Lost." : "You won!";
                break;
            case 3:
                roundResult = (comp == 1) ? "You Lost." : "You won!";
                break;
            default:
                System.out.println("\nError! That was not an option.");
                System.exit(0);
        }

        // not included in switch result for readability
        if (roundResult.equals("You won!")){
             userWon++;
        }

        System.out.println(roundResult);
        return userWon;
    }

    public static boolean checkPlay(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nWould you like to play again? (y/n) ");
        String playAgain = input.next();
        
        boolean check = playAgain.equals("y") ? true : false;
        
        return check;
    }
}