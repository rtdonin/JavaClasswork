/*
Created by: Margaret Donin
Date created: 04/19/20
Date revised:
*/

package Methods;

import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = randomColor();
        String animal = randomAnimal();
        String colorAgain = randomColor();
        
        int weight = randomNumber(5, 200);
        int distance = randomNumber(5, 200);
        int number = randomNumber(10000, 20000);
        int time = randomNumber(2, 6);         

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
            + weight + "lb " + " miniature " + animal
            + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
            + number + " " + colorAgain + " poppies for nearly "
            + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
            + "let me tell you!");
    }

    public static String randomColor(){
        Random randomizer = new Random();
        int color = randomizer.nextInt(5);
        
        switch (color){
            case 0: return "red";
            case 1: return "green";
            case 2: return "blue";
            case 3: return "yellow";
            default: return "white";
        }
    }
    
    public static String randomAnimal(){
        Random randomizer = new Random();
        int animal = randomizer.nextInt(5);
        
        switch (animal){
            case 0: return "cat";
            case 1: return "dog";
            case 2: return "bird";
            case 3: return "fish";
            default: return "frog";
        }
    }
    
    public static int randomNumber(int min, int max){
        Random randomizer = new Random();
        return (randomizer.nextInt(max - min) + min + 1);
    }
}