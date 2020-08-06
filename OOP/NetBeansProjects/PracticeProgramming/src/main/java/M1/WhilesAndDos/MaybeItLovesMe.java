/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:
*/

package M1.WhilesAndDos;

import java.util.Random;

public class MaybeItLovesMe {
    public static void main(String[] args) {
        Random randomizer = new Random();
        
        int petal = 1;
        int totalPetals = randomizer.nextInt(77) + 13;
        
        System.out.println("Well here goes nothing...");
        
        do{
            if (petal % 2 != 0){
                System.out.println("It loves me NOT!");
            } else{
                System.out.println("It LOVES me!");
            }
            
            petal++;
            
        } while (petal < totalPetals);
        
        if (petal % 2 != 0){
            System.out.println("I knew it! It LOVES ME!");
        } else{
                System.out.println("Awwww, bummer.");
        }
    }
}
