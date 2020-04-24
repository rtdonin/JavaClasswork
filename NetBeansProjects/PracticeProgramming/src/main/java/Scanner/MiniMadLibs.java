/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:
*/

package Scanner;

import java.util.Scanner;

public class MiniMadLibs{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String noun;
        String adjective;
        String anotherNoun;
        String number;
        String anotherAdjective;
        String pluralNoun;
        String anotherPluralNoun;
        String yetAnotherPluralNoun;
        String presentTenseVerb;
        String pastTenseVerb;

        System.out.println("Let's play MAD LIBS!");
        System.out.println();

        System.out.print("I need a noun: ");
        noun = input.nextLine();

        System.out.print("Now an adjective: ");
        adjective = input.nextLine();

        System.out.print("Another noun: ");
        anotherNoun = input.nextLine();

        System.out.print("And a number: ");
        number = input.nextLine();

        System.out.print("Another adjective: ");
        anotherAdjective = input.nextLine();

        System.out.print("A plural noun: ");
        pluralNoun = input.nextLine();

        System.out.print("Another one: ");
        anotherPluralNoun = input.nextLine();

        System.out.print("One more: ");
        yetAnotherPluralNoun = input.nextLine();

        System.out.print("A verb (infinitive form): ");
        presentTenseVerb = input.nextLine();

        System.out.print("Same verb (past participle): ");
        pastTenseVerb = input.nextLine();
        
        System.out.println("\n*** NOW LETS GET MAD (libs) ***");

        System.out.println(noun + ": the " + adjective + " frontier. These are the "
                + "voyages of the starship " + anotherNoun + ".\nIts " + number
                + "-year mission: to explore strange " + anotherAdjective + " "
                + pluralNoun + ", to seek out " + anotherAdjective + " "
                + anotherPluralNoun + " and " + anotherAdjective + " "
                + yetAnotherPluralNoun + ",\nto boldly " + presentTenseVerb
                + " where no one has " + pastTenseVerb + " before.");
    }
}

