/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:

What changes if you turn the while loop's condition to just read "true".
We keep diving.
*/

package WhilesAndDos;

import java.util.Random;
import java.util.Scanner;

public class BewareTheKraken {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randomized = new Random();
        String yesOrNo;

        System.out.println("Already, get those flippers and wetsuit on - we're going diving!");
        System.out.println("Here we goooOOooOooo.....! *SPLASH*");

        int depthDivedInFt = 0;
        int fish;

        // The ocean is only 36200 at the deepest survey
        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");

            System.out.println("Do you want to keep going? (y/n) ");
            yesOrNo = input.nextLine();
            
            if (yesOrNo.equals("n")){
                break;
            } else {
                if(depthDivedInFt >= 20000){
                    System.out.println("Uhhh, I think I see a Kraken, guys ....");
                    System.out.println("TIME TO GO!");
                    break;
                }

                depthDivedInFt += 1000;
           
                fish = randomized.nextInt(3);
            
                switch (fish){
                    case 0: System.out.println("Look! A seahorse!");
                        break;
                    case 1: System.out.println("Look! A clownfish!");
                        break;
                    case 2: System.out.println("Look! A Basselet!");
                }
            }
        }
        
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}