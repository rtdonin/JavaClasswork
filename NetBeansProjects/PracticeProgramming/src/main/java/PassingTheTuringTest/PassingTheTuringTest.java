/*
Created by: Margaret Donin
Date created: 04/14/20
Date revised:
*/

package PassingTheTuringTest;

import java.util.Scanner;

public class PassingTheTuringTest{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        String humanName;
        String humanColor;
        String humanFruit;
        
        int humanNumber;
        int product;
        
        System.out.println("Hello there!");
        System.out.println("What's your name?");
        humanName = reader.nextLine();
        
        System.out.println("Hi, " + humanName + "! I'm Alice.");
        System.out.println("What's your favorite color?");
        humanColor = reader.nextLine();
        
        System.out.println("Huh, " + humanColor + "? Mine's Electric Lime.");
        System.out.println("I really like limes. They're my favorite fruit, too");
        System.out.println("What's YOUR favorite fruit, " + humanName + "?");
        humanFruit = reader.nextLine();
        
        System.out.println("Really? " + humanFruit + "? That's wild!");
        System.out.println("Speaking of favorites, what's your favorite number?");
        humanNumber = reader.nextInt();
        product = humanNumber * -7;
        
        System.out.println(humanNumber + " is a cool number. Mine's -7.");
        System.out.println("Did you know " + humanNumber + " * -7 is " + product + ".");
        System.out.println("Well, thanks for talking to me, " + humanName + "!");
        
    }
}