/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

Note: A person who is born in 1980 should display three messages,
one for being born before 2005, one for 1995, and finally for 1985.
*/

package YourLifeInMovies;

import java.util.Scanner;

public class YourLifeInMovies{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int year;
        int condition = 0;
        String name;
        
        System.out.print("Hey, let's play a game! What's your name? ");
        name = scan.nextLine();
        System.out.print("\nOk, " + name + ", when were you born? ");
        year = scan.nextInt();
        System.out.println("");
        
        // the younger they are the larger condition should be
        // this needs to happen so that the fall through of the
        // switch statement works for us.
        for (int i = 2005; i >= 1965; i -=10){
            if (year > i){
                condition++;
            }
        }
        
        
        switch (condition){
            case 0:
                System.out.println("The MASH TV series has been around for almost half a century!");
            case 1:
                System.out.println("The original Jurassic Park release is closer to the first lunar landing than it is to today.");
            case 2:
                System.out.println("Space Jam came out not last decade, but the one before THAT.");
            case 3:
                System.out.println("The first Harry Potter came out over 15 years ago.");
            case 4:
                System.out.println("Pixar's 'Up' came out over a decade ago.");
        }


    }
}