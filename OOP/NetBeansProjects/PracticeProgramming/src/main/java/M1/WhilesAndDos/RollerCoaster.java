/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:

What happens if the user enters a value that is neither "y" nor "n"?
Our condition only checks to see if it is equal to y, as long as it is not y,
it will exist the loop

What happens if we change the condition to check for a no answer instead?
We will never enter the loop and it will print:
Wow, that was FUN!
We looped that loop 0 times!!
*/

package M1.WhilesAndDos;

import java.util.Scanner;

public class RollerCoaster {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("We're going to go on a roller coaster...");
        System.out.println("Let me know when you want to get off...!");

        String keepRiding = "y";
        int loopsLooped = 0;
        
        while (keepRiding.equals("y")) {
            System.out.println("WHEEEEEEEEEEEEEeEeEEEEeEeeee.....!!!");
            System.out.print("Want to keep going? (y/n) :");
            keepRiding = userInput.nextLine();
            loopsLooped++;
        }

        System.out.println("Wow, that was FUN!");
        System.out.println("We looped that loop " + loopsLooped + " times!!");
    }
}