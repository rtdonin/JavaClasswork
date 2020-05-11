/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:

Note:
If you want to have an "other" category comment out lines 42-52 and uncomment 54-63
*/

package M1.basicprogrammingconcepts;

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

        for (int i = 0; i < breed.length; i++){
            if (i == breed.length - 1){
                percent = 100 - sumOfPercents;
            } else {
                percent = randomNumber.nextInt(100 - sumOfPercents + 1);
                sumOfPercents += percent;
            }
            
            System.out.println(percent + "% " + breed[i]);
        }
        
//        for (String type : breed){
//            percent = randomNumber.nextInt(100 - sumOfPercents + 1);
//            sumOfPercents += percent;
//            System.out.println(percent + "% " + type);
//        }
//        
//        if (sumOfPercents != 100){
//            percent = 100 - sumOfPercents;
//            System.out.println(percent + "% Other");
//        }
    }
}