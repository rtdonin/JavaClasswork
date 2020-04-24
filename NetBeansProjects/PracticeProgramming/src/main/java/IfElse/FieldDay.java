/*
Created by: Margaret Donin
Date created: 04/23/20
Date revised:

If a person's name falls before Baggins, then they are on the team "Red Dragons"
If it falls after Baggins, but before Dresden, they are on the team "Dark Wizards"
If it falls after Dresden, but before Howl, they are on the team "Moving Castles"
If it falls after Howl, but before Potter, they are on the team "Golden Snitches"
If it falls after Potter, but before Vimes, they are on the team "Night Guards"
If it falls after Vimes, they are on the team "Black Holes"
*/

package IfElse;

import java.util.Scanner;

public class FieldDay{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String lastName;
        String teamName;

        System.out.print("What's your last name? ");
        lastName = input.nextLine().toUpperCase();
        // needs to be compared in the same case because characters are compared unicode values
        
        if (lastName.compareTo("BAGGINS") < 0){
            teamName = "Red Dragon";
        } else if (lastName.compareTo("BAGGINS") >= 0 && lastName.compareTo("DRESDEN") < 0){
            teamName = "Dark Wizard";
        } else if (lastName.compareTo("DRESDEN") >= 0 && lastName.compareTo("HOWL") < 0){
            teamName = "Moving Castle";
        } else if (lastName.compareTo("HOWL") >= 0 && lastName.compareTo("POTTER") < 0){
            teamName = "Golden Snitches";
        } else if (lastName.compareTo("POTTER") >= 0 && lastName.compareTo("VIMES") < 0){
            teamName = "Night Guards";
        } else{
            teamName = "Black Holes";
        }

        System.out.println("Aha! You're on the team \"" + teamName + "\"!");
        System.out.println("Good luck in the games!");
    }
}