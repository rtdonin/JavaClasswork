/*
Created by: Margaret Donin
Date created: 04/24/20
Date revised:
*/

package Arrays;

import java.util.Random;

public class HiddenNuts {

    public static void main(String[] args) {

        String[] hidingSpots = new String[100];
        Random squirrel = new Random();
        hidingSpots[squirrel.nextInt(hidingSpots.length)] = "Nut";
        System.out.println("The nut has been hidden ...");

        // Nut finding code should go here!
        int locOfNut = -1;

        for (int i = 0; i < hidingSpots.length; i++){ 
            if ("Nut".equals(hidingSpots[i])){
                locOfNut = i;
                break;
            }
        }
        
        System.out.println("Found it! It's in spot# " + locOfNut);
    }
}