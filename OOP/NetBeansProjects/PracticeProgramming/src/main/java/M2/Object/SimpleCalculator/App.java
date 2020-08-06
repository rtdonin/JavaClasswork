/*
Created by: Margaret Donin
Date created: 04/28/20
Date revised: 04/29/20
*/

package M2.Object.SimpleCalculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        while (true) {
            System.out.print("Would you like to (1) add, (2) subtract, (3) multiply, (4) divide, or (5) exit? ");
            simpleCalculator.setOperation(input.nextInt());

            System.out.print("Which two intergers would you like to preform this operation with? ");
            simpleCalculator.setNumberOne(input.nextInt());

            System.out.print("And the other one? ");
            simpleCalculator.setNumberTwo(input.nextInt());

            simpleCalculator.getOperation();

        }
    }
}