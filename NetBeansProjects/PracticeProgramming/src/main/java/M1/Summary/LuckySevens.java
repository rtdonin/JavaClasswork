/*
    Name: Margaret Donin
    Date Created: 04/21/20
    Most recent revision: 
*/

package M1.Summary;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Random randNum = new Random();
        
        // Declaring all my variables
        int startingBet;
        int totalRolls;
        int rollsOnMax = 0;
        int max = 0;
        int gameMoney;
        int die1;
        int die2;
        
        System.out.print("How many dollars do you have? ");
        startingBet = input.nextInt();
        gameMoney = startingBet;

        for (totalRolls = 1; gameMoney > 0; totalRolls++) {
            // getting die numbers. 
            die1 = randNum.nextInt(6) + 1;
            die2 = randNum.nextInt(6) + 1;

            if ((die1 + die2) == 7) {
                 gameMoney += 4;
                 
                if (gameMoney > max) {
                    max = gameMoney;
                    rollsOnMax = totalRolls;
                }
            } else {
            gameMoney--;
            }
        }
        System.out.println("You are broke after " + totalRolls + " rolls.");
        System.out.println("You should have quit after " + rollsOnMax + " rolls when you had $" + max + ".");        
    }
}
    