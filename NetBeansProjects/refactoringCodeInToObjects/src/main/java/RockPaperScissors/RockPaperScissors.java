/*
Created by: Margaret Donin
Date created: 04/21/20
Date revised: 04/28/20
*/

package RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    Scanner input = new Scanner(System.in);
    private boolean areWePlaying = true;
    private int totalRounds;
    private int userPlay; // what the user plays this round
    private int computerPlay; // what the computer plays this round
    private int roundsTied;
    private int roundsUserWon;
    private int roundsComputerWon;

    //the entire operation.
    public void game(){
        // unless we change areWePlaying to false, we keep playing.
        // basically plays game and then checks if we keep going
        while (areWePlaying) {
            setTotalRound();
            playGame();
            setAreWePlaying();
        }
        // end of game!
        System.out.println("\nThank you for playing!");
    }

    public void setAreWePlaying() {
        System.out.print("\nWould you like to play again? (y/n) ");
        String playAgain = input.next();
        
        this.areWePlaying = playAgain.equals("y");
    }

    public boolean getAreWePlaying() {
        return areWePlaying;
    }
    
    public void setTotalRound(){
        System.out.print("How many rounds would you like to play? ");
        this.totalRounds = input.nextInt();
        // When to give us an error
        if (totalRounds < 1 || totalRounds > 10){
            throw new IllegalArgumentException("ERROR!!!!\nUser needs to provide a number from 1 - 10.");
        }
    }

    public int getTotalRound() {
        return this.totalRounds;
    }
    
    public void playGame(){
        Random randomValue = new Random();
        roundsTied = 0;
        roundsUserWon = 0;
        roundsComputerWon = 0;

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
                whoWon();
            }

            roundsComputerWon = currentRound - roundsUserWon - roundsTied;

            // prints Round information
            System.out.println("\nRound " + currentRound);
            System.out.println("Number of rounds user won: " + roundsUserWon);
            System.out.println("Number of rounds computer won: " + roundsComputerWon);
            System.out.println("Number of rounds tied: " + roundsTied);
        }
        
        if (roundsUserWon > roundsComputerWon){
            System.out.println("\nCongradulations! You won the game!");
        } else if (roundsUserWon < roundsComputerWon){
            System.out.println("\nAww.. The Computer won.");
        } else {
            System.out.println("\nIt was a tie!");
        }

    }

    public void whoWon(){
        String roundResult = "";

        // 1. rock 2. paper 3. scissors
        switch(userPlay){
            case 1:
                roundResult = (computerPlay == 2) ? "You Lost." : "You won!";
                break;
            case 2:
                roundResult = (computerPlay == 3) ? "You Lost." : "You won!";
                break;
            case 3:
                roundResult = (computerPlay == 1) ? "You Lost." : "You won!";
                break;
            default:
                throw new IllegalArgumentException("\nError! That was not an option.");
        }

        // not included in switch result for readability
        if (roundResult.equals("You won!")){
            roundsUserWon++;
        }

        System.out.println(roundResult);
    }
}