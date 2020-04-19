/*
Created by: Margaret Donin
Date created: 04/19/20
Date revised:

What are the ranges for the starting and stopping in each for loop?
First loop: starts at 0 ends at 10.
Second loop: starts at the user input year and ends and year-10

Which one is clearer to you? Why?
Both are clean? I can understand both when I read them and that's what matters,
another human being able to understand your logic

Change it so that the second loop counts back twenty years.
Line 34.
*/

package For;

import java.util.Scanner;

public class TwoForsAndTenYearsAgo {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("What year would you like to count back from? ");
        int year = userInput.nextInt();

        for (int i = 0; i <= 10; i++) {
            System.out.println(i + " years ago would be " + (year - i));
        }

        System.out.println("\nI can count backwards using a different way too...");

        for (int i = year; i >= year - 20; i--) { // this line was changed
            System.out.println( (year - i) + " years ago would be " + i);
        }
    }
}