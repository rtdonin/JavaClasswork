/*
Created by: Margaret Donin
Date created: 04/19/20
Date revised:
*/
package M1.For;

import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("How many units of fizzing and buzzing do you need in your life? ");
        int userNumber = input.nextInt();
        int fizzingAndBuzzing = 0;
        
        System.out.println("0");

        for (int i = 1; fizzingAndBuzzing < userNumber; i++){
            if (i % 3 == 0 && i % 5 == 0){
                System.out.println("fizz buzz");
                fizzingAndBuzzing++;

            } else if (i % 3 == 0){
                System.out.println("fizz");
                fizzingAndBuzzing++;

            } else if (i % 5 == 0){
                System.out.println("buzz");
                fizzingAndBuzzing++;

            } else{
                System.out.println(i);
            }
        }
        System.out.println("TRADITION!!!!!");
    }
}