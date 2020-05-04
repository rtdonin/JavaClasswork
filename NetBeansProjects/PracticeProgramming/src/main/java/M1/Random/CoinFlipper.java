/*
Created by: Margaret Donin
Date created: 04/23/20
Date revised:
*/

package M1.Random;

import java.util.Random;

public class CoinFlipper {
    public static void main(String[] args) {

        Random randomBoolean = new Random();
        
        boolean coin = randomBoolean.nextBoolean();
        
        String side = coin ? "HEADS" : "TAILS";
        
        System.out.println("Ready, Set, Flip....!!");
        System.out.println("You got " + side);
    }
}