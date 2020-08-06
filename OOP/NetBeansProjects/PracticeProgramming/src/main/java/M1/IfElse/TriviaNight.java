/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:
*/

package M1.IfElse;

import java.util.Scanner;

public class TriviaNight{
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int score = 0;
        int answer;
        
        System.out.println("It's TRIVIA NIGHT! Are you ready?!");
        System.out.print("\nFIRST QUESTION!"
                + "\nWhat is the Lowest Level Programming Language?"
                + "\n1) Source Code"
                + "\n2) Assembly Language"
                + "\n3) C#"
                + "\n4) Machine Code"
                + "\n YOUR ANSWER: ");
        answer = input.nextInt();
        score = answer == 4? score + 1: score + 0;
        
        System.out.print("\nSECOND QUESTION!"
                + "\nWebsite Security CAPTCHA Forms Are Descended From the Work of?"
                + "\n1) Grace Hopper"
                + "\n2) Alan Turing"
                + "\n3) Charles Babbage"
                + "\n4) Larry Page"
                + "\n YOUR ANSWER: ");
        answer = input.nextInt();
        score = answer == 2? score + 1: score + 0;

        System.out.print("\nLAST QUESTION!"
                + "\nWhich of These Sci-Fi Ships Was Once Slated for a Full-Size Replica in Las Vegas?"
                + "\n1) Serenity"
                + "\n2) The Battlestar Galactica"
                + "\n3) The USS Enterprise"
                + "\n4) The Millennium Falcon"
                + "\n YOUR ANSWER: ");
        answer = input.nextInt();
        score = answer == 3? score + 1: score + 0;

        System.out.println("Nice job - you got " + score + " correct!");
        
        
    }
}