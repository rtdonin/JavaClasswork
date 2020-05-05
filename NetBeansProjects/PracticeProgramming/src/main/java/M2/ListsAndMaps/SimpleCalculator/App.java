/*
Created by: Margaret Donin
Date created: 04/28/20
Date revised: 04/29/20
*/

package M2.ListsAndMaps.SimpleCalculator;

public class App {
    public static void main(String[] args) {
        SimpleCalculator simpleCalculator = new SimpleCalculator();

        while (true) {
            simpleCalculator.setOperation("Would you like to (1) add, (2) subtract, (3) multiply, (4) divide, or (5) exit? ");

            simpleCalculator.setNumberOne("Which two intergers would you like to preform this operation with? ");

            simpleCalculator.setNumberTwo("And the other one? ");

            simpleCalculator.getOperation();

        }
    }
}