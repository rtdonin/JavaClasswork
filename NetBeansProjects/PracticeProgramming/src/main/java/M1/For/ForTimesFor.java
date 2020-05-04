/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

What are the start/stop ranges of output for both loops?
The first loop starts at 0 and ends at 9. The second loop starts at 10 and ends at 1.
*/

package M1.For;

import java.util.Scanner;

public class ForTimesFor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.print("What times table shall I recite? ");
        int number = input.nextInt();
        int answer;
        int correctAnswers = 0;
        
        for (int i = 1; i <= 15; i++) {
            System.out.print("\n" + i + " * " + number + " is: ");
            answer = input.nextInt();
            if (answer == i * number){
                System.out.println("\n Correct!");
                correctAnswers++;
            } else{
                System.out.println("\nSorry no, the answer is: "+ i * number);
            }
        }
        System.out.println("You got " + correctAnswers + " correct.");
    }
}