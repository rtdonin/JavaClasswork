/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

Originally line 21 said "int x = randomizer.nextInt(5);" This would only give us
intergers 0 to 4. 
*/

package Random;

import java.util.Random;

public class Opinionator {

    public static void main(String[] args) {
        Random randomizer = new Random();
        System.out.println("I can't decide what animal I like the best.");
        System.out.println("I know! Random can decide FOR ME!");

        int x = randomizer.nextInt(6); // the change was made on this line.

        System.out.println("The number we chose was: " + x);

        switch (x) {
            case 0:
                System.out.println("Llamas are the best!");
                break;
            case 1:
                System.out.println("Dodos are the best!");
                break;
            case 2:
                System.out.println("Woolly mammoths are DEFINITELY the best!");
                break;
            case 3:
                System.out.println("Sharks are the greatest, they have their own week!");
                break;
            case 4:
                System.out.println("Cockatoos are just so awesomme!");
                break;
            case 5:
                System.out.println("Have you ever met a naked mole-rat? They're GREAT!");
                break;
        }

        System.out.println("Thanks Random, maybe YOU'RE the best!");
    }
}