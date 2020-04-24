/*
Created by: Margaret Donin
Date created: 04/23/20
Date revised:
*/

package Random;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {
    public static void main(String[] args) {

        Random diceRoller = new Random();
        Scanner input = new Scanner(System.in);
        
        System.out.print("How man sides does your die have? ");
        int dieSides = input.nextInt();

        int rollResult = diceRoller.nextInt(dieSides) + 1;

        System.out.println("\nTIME TO ROOOOOOLL THE DICE!");
        System.out.println("I rolled a " + rollResult);

        if (rollResult == 1) {
            System.out.println("You rolled a critical failure! Ouch!");
        } else if (rollResult == dieSides){
            System.out.println("You rolled a critical! Nice Job!");
        }
    }
}