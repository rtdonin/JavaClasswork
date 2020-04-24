/*
Created by: Margaret Donin
Date created: 04/23/20
Date revised:
*/


package IfElse;

import java.util.Scanner;

public class MiniZork{
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        boolean userIsAlive = true;
        boolean lookingForFlashlight = false;
        boolean lookingForGloves = false;
        boolean haveGloves = false;
        int location = 1;
        int action;
        // 1 = field, 2 = mailbox, 3 = house, 4 = garden

        while (userIsAlive){
            
            switch (location) {
                case 1:
                    System.out.println("You are standing in an open field west of a white house,");
                    System.out.println("With a boarded front door.");
                    System.out.println("There is a small mailbox here.");
                    
                    if (lookingForGloves){
                        System.out.println("You find gloves on the ground.");
                        System.out.println("You go back to the garden.");
                        haveGloves = true;
                        lookingForGloves = false;
                        location = 4;
                    } else {
                        System.out.print("Go to the house (1), open the mailbox (2), or explore the garden (3)? ");
                        action = userInput.nextInt();

                        switch (action) {
                            case 1: location = 3;
                                break;
                            case 2: location = 2;
                                break;
                            case 3: location = 4;
                        }
                    }
                    break;

                case 2:
                    System.out.println("You open the mailbox.");
                    System.out.println("It's really dark in there.");
                    System.out.print("Look inside (1) or stick your hand in (2)? ");
                    action = userInput.nextInt();
                    
                    if (action == 1) {
                        System.out.println("You peer inside the mailbox.");
                        System.out.println("It's really very dark. So ... so very dark.");
                        System.out.print("Run away (1) or keep looking (2)? ");
                        action = userInput.nextInt();
                        
                        if (action == 1) {
                            System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                            System.out.println("You've been eaten by a grue.");
                            
                            userIsAlive = false;
                        } else if (action == 2) {
                            System.out.println("You run away screaming across to the garden - looking very foolish.");
                            System.out.println("But you're alive. Possibly a wise choice.");
                            
                            location = 4;
                        }
                    } else if (action == 2) {
                        System.out.println("Turns out, sticking your hand into dark places isn't a good idea.");
                        System.out.println("Your hand is bitten by a grue.");
                        System.out.println("You bleed to death.");
                        
                        userIsAlive = false;
                    }
                    break;
                case 3:
                    System.out.println("You go to the white house.");
                    System.out.println("The front door is boarded up.");
                    System.out.println("You notice a side door and a broken window.");
                    System.out.print("Enter via the side door (1) or the broken window (2)? ");
                    action = userInput.nextInt();
                    
                    if (action == 1){
                        System.out.println("The side door is locked and has rusted through hinges.");
                        System.out.print("Pick the lock (1) or break down the door (2)? ");
                        action = userInput.nextInt();
                        
                        if (action == 1){
                            System.out.println("You get the lock to open.");
                            System.out.println("It is dark.");
                            System.out.print("Look for a flashlight (1) or walk inside (2)? ");
                            action = userInput.nextInt();

                            if (action == 1){
                                System.out.print("Look for a flashlight in the mailbox (1) or the garden (2)? ");
                                action = userInput.nextInt();
                        
                                location = (action == 1) ? 2 : 4;
                                lookingForFlashlight = true;
                            } else if (action == 2){
                                System.out.println("Turns out walking into dark places with no light source is dangerous.");
                                System.out.println("A few feet from the door the floor fell through.");
                                System.out.println("You fall and break your leg.");
                                System.out.println("No one finds you.");
                                System.out.println("You die.");
                                
                                userIsAlive = false;
                            }
                        } else if (action == 2){
                            System.out.println("You break down the door.");
                            System.out.println("It is dark.");
                            System.out.println("You take a step in.");
                            System.out.print("Look for a flashlight (1) or walk inside (2)? ");
                            action = userInput.nextInt();

                            if (action == 1){
                                System.out.print("Look for a flashlight in the mailbox (1) or the garden (2)? ");
                                action = userInput.nextInt();

                                location = (action == 1) ? 2 : 4;
                                lookingForFlashlight = true;
                                
                            } else if (action == 2) {
                                System.out.println("Turns out walking into dark places with no light source is dangerous.");
                                System.out.println("A few feet from the door the floor fell through.");
                                System.out.println("You fall and break your leg.");
                                System.out.println("No one finds you.");
                                System.out.println("You die.");

                                userIsAlive = false;
                            }
                        }   
                    } else if (action == 2) {
                        System.out.println("As you enter you hurt yourself on the sharp edges of the window.");
                        System.out.println("You try the door.");
                        System.out.println("The nob turns. You push the door.");
                        System.out.println("You can not get the door to open.");
                        System.out.print("Go to the mailbox (1) or go to the garden (2) ? ");
                        action = userInput.nextInt();

                        location = (action == 1) ? 2 : 4;
                    }
                    break;
                case 4:
                    System.out.println("You are in the garden.");
                    System.out.println("The garden is overgrown.");
                    System.out.println("There is a bench and a bird bath.");
                    
                    if (lookingForFlashlight){
                        System.out.print("Look for a flashlight ");
                    } else{
                        System.out.print("Look in the flowers (1) or sit on the bench (2) ? ");
                        action = userInput.nextInt();
                        
                        switch (action){
                            case 1: System.out.print("Look in the ");
                                break;
                            case 2: System.out.println("Enjoy the peaceful day.");
                                System.exit(0);
                        }
                    }
                    
                    System.out.print("in the roses (1) or the petunias (2) ? ");
                    action = userInput.nextInt();

                    if (action == 1 && !haveGloves){
                        System.out.print("Look for some gloves to protect your hands from the thorns (1)"
                                + "\n or go search without gloves (2)? ");
                        action = userInput.nextInt();

                        if (action == 1){
                            System.out.print("Look for gloves in the house (1) or the field (2)? ");
                            action = userInput.nextInt();

                            location = (action == 1) ? 3 : 1;
                            lookingForGloves = true;

                        } else if (action == 2) {
                            System.out.println("You go look in the roses without gloves on.");
                            System.out.println("You prick ourself on a thorn.");
                            System.out.print("Look for bandages in the house (1) or look in the petunias (2) ? ");
                            action = userInput.nextInt();

                            if (action == 1) {
                                location = 3;
                            } else if (action == 2) {
                                System.out.println("You start looking in the petunias.");
                                System.out.println("Except those aren't petunias.");
                                System.out.println("This is a poisonous plant.");
                                System.out.println("You die.");

                                userIsAlive = false;
                            }
                        }
                    } else if (action == 2) {
                        System.out.println("You start looking in the petunias.");
                        System.out.println("Except those aren't petunias.");
                        System.out.println("This is a poisonous plant.");
                        System.out.println("You die.");

                        userIsAlive = false;
                    } else if (action == 1 && haveGloves) {
                        System.out.println("You did not find anything.");
                        System.out.println("Look in the mailbox (1) or go to the house (2)?");
                        action = userInput.nextInt();

                        location = (action == 1) ? 2 : 3;
                    }
            }
        }
    }  
}