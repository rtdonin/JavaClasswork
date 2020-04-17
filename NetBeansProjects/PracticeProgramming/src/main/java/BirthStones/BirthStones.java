/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:
*/

package BirthStones;

import java.util.Scanner;

public class BirthStones{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int month;
        
        System.out.print("What month's birthstone do you want to know? ");
        month = input.nextInt();
        
        switch (month){
            case 1: System.out.println("\nJanuary's birthstone is Garnet.");
                break;
            case 2: System.out.println("\nFebruary's brithsone is Amethyst.");
                break;
            case 3: System.out.println("\nMarch's brithsone is Aquamarine.");
                break;
            case 4: System.out.println("\nApril's brithsone is Diamond.");
                break;
            case 5: System.out.println("\nMay's brithsone is Emerald.");
                break;
            case 6: System.out.println("\nJune's brithsone is Pearl.");
                break;
            case 7: System.out.println("July's brithsone is Ruby.");
                break;
            case 8: System.out.println("\nAugust's brithsone is Peridot.");
                break;
            case 9: System.out.println("\nSeptember's brithsone is Sapphire.");
                break;
            case 10: System.out.println("\nOctober's brithsone is Opal.");
                break;
            case 11: System.out.println("\nNovember's brithsone is Topaz.");
                break;
            case 12: System.out.println("\nDecember's brithsone is Turquoise.");
                break;
            default: System.out.println("\nI think you must be confused, " + month + " doesn't match a month.");
        }
    }
}