/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:

What You Should See (Example)
What unit is equivalent to 1,024 Gigabytes? Terabyte
Which planet is the only one that rotates clockwise in our Solar System? Venus
The largest volcano ever discovered in our Solar System is located on which planet? Mars
What is the most abundant element in the earth's atmosphere? Nitrogen

Wow, 1,024 Gigabytes is a Mars!
I didn't know that the largest ever volcano was discovered on Terabyte!
That's amazing that Venus is the most abundant element in the atmosphere...
Nitrogen is the only planet that rotates clockwise, neat!
*/

package M1.Scanner;

import java.util.Scanner;

public class AllTheTrivia {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        String answer1;
        String answer2;
        String answer3;
        String answer4;

        System.out.print("What unit is equivalent to 1,024 Gigabytes? ");
        answer1 = input.nextLine();
        
        System.out.print("Which planet is the only one that rotates clockwise in our Solar System? ");
        answer2 = input.nextLine();
        
        System.out.print("The largest volcano ever discovered in our Solar System is located on which planet? ");
        answer3 = input.nextLine();
        
        System.out.print("What is the most abundant element in the earth's atmosphere? ");
        answer4 = input.nextLine();
        
        System.out.println("Wow, 1,024 Gigabytes is a " + answer3 + "!");
        System.out.println("I didn't know that the largest ever volcano was discovered on " + answer1 + "!");
        System.out.println("That's amazing that " + answer2 + " is the most abundant element in the atmosphere...");
        System.out.println(answer4 + " is the only planet that rotates clockwise, neat!");
    }
}