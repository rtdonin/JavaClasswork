/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:
*/ 
package KnockKnock;

import java.util.Scanner;

public class KnockKnock {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Knock Knock! Guess who!! ");
        String nameGuess = input.nextLine();

        if (nameGuess.equals("Marty McFly")){
            System.out.println("Hey! That's right! I'm back!"
                    + "\n.... from the Future.");
        } else{
            System.out.println("Dude, do I -look- like " + nameGuess);
        }
    }
}