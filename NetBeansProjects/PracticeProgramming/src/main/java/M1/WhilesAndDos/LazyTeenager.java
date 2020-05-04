/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:
*/

package M1.WhilesAndDos;

import java.util.Random;

public class LazyTeenager {
    public static void main(String[] args) {
        Random randomize = new Random();
        int timesAsked = 1;
        
        boolean roomIsClean = false;
        
        do{
            System.out.print("\nClean your room!! (x" + timesAsked + ")");
            
            int chance = randomize.nextInt(10) + 1;
            
            if (chance <= timesAsked){
                roomIsClean = true;
                System.out.println("\nFINE! I'LL CLEAN MY ROOM. BUT I REFUSE TO EAT MY PEAS.");
            } else if (timesAsked == 7){
                System.out.println("\nThat's IT, I'm doing it!!! YOU'RE GROUNDED AND I'M TAKING YOUR XBOX!");
                break;
            }
            timesAsked++;
        } while(!roomIsClean);
    }

}