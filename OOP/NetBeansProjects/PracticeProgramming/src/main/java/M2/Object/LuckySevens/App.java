/*
Name: Margaret Donin
Date Created: 04/21/20
Most recent revision: 04/28/20
*/

package M2.Object.LuckySevens;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LuckySevens luckySevens = new LuckySevens();
        
        System.out.print("How many dollars do you have? ");
        luckySevens.setStartingBet(input.nextInt());

        luckySevens.getResults();

    }
}
    