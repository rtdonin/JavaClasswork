/*
Created by: Margaret Donin
Date created: 04/14/20
Date revised:
*/

import java.util.Scanner;

public class QuestForTheUserInput {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);

        String yourName;
        String yourQuest;
        double velocityOfSwallow;

        // Assigning scanner readline to string values because it returns a string
        System.out.print("What is your name?? ");
        yourName = inputReader.nextLine();

        System.out.print("What is your quest?! ");
        yourQuest = inputReader.nextLine();

        // use Scanner's nextDouble method the Double.parseDouble to convert the nextLine's String

        System.out.print("What is the airspeed velocity of an unladen swallow?!?! ");
        velocityOfSwallow = Double.parseDouble(inputReader.nextLine());
        System.out.println();
        System.out.println("How do you know " + velocityOfSwallow + " is correct, " + yourName + "?");
        System.out.println("You didn't even know if the swallow was African or European!");
        System.out.println("Maybe skip answering things about birds and instead go " + yourQuest + ".");
    }

}