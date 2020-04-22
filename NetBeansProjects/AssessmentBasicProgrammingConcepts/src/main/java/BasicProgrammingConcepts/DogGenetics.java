/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:
*/

package BasicProgrammingConcepts;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        String dogName;
        
        System.out.print("What is the name of your dog? ");
        dogName = reader.nextLine();
        
        System.out.println("I have this highly reliable report on "
                + dogName + "'s prestigious background right here.");
        System.out.println();
        System.out.println(dogName + " is:");
        System.out.println();
        
        randomDNA(); // prints random DNA to Console
        
        System.out.println();
        System.out.println("Wow, that's QUITE the dog!");
    }
    
    public static void randomDNA(){
        Random randomNumber = new Random();

        String[] breed = {"St.Bernard", "Chihuahua", "Dramatic RedNosed Asian Pug", "Common Cur", "King Doberman"};
        int sumOfPercents = 0;
        int percent;

        for (String type : breed){
            percent = randomNumber.nextInt(97 - sumOfPercents) + 0;
            sumOfPercents += percent;
            System.out.println(percent + "% " + type);
        }
        
        if (sumOfPercents != 100){
            percent = 100 - sumOfPercents;
            System.out.println(percent + "% Other");
        }
    }
}