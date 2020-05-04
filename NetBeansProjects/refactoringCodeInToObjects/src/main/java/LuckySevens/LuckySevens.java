/*
Name: Margaret Donin
Date Created: 04/21/20
Most recent revision: 04/28/20
*/

package LuckySevens;

import java.util.Random;


public class LuckySevens{

    Random randNum = new Random();
    
    // Declaring all my variables
    private int startingBet;
    private int totalRolls;
    private int rollsOnMax = 0;
    private int max = 0;
    private int gameMoney;

    public void setStartingBet(int startingBet){
        this.startingBet = startingBet;
    }
    
    public void setGameMoney(){
        this.gameMoney = this.startingBet;
    }

    public int getDie(){
        return randNum.nextInt(6) + 1;
    }

    public void getResults() {
        setGameMoney();
        for (totalRolls = 1; gameMoney > 0; totalRolls++) {
            // getting die numbers. 
            int die1 = getDie();
            int die2 = getDie();

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
    