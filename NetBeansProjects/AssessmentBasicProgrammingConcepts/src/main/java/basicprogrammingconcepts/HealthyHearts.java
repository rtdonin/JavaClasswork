/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:

// Sample expected output:

// What is your age? 50
// Your maximum heart rate should be 170 beats per minute
// Your target HR Zone is 85 - 145 beats per minute
*/
package basicprogrammingconcepts;

import java.util.Scanner;

public class HealthyHearts{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int age;
        int maxHR; // HR = Heart Rate
        int minTargetHR;
        int maxTargetHR;

        System.out.print("What is your age? ");
        age = input.nextInt();
        maxHR = 220 - age; // how we get maximum HR
        minTargetHR = Math.round((float) (0.50 * maxHR)); // gives us 50% of max
        maxTargetHR = Math.round((float) (0.85 * maxHR)); // gives us 85% of max
        
        System.out.println("Your maximum heart rate should be " + maxHR
                + " beats per minute");
        
        System.out.println("Your target HR Zone is " + minTargetHR + " - "
                + maxTargetHR + " beats per minute");
    }
}