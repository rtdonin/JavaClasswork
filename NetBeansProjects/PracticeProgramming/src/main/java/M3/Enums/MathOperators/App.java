/*
Created by: Margaret Donin
Date created: 05/31/20
Date revised:
*/

package M3.Enums.MathOperators;

import static M3.Enums.MathOperators.MathOperator.*;
import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Type in a number: ");
        int operand1 = parseInt(input.nextLine());
        
        System.out.print("Type in a second number: ");
        int operand2 = parseInt(input.nextLine());
        
        System.out.println("Calculating ... ");
        System.out.println("Adding: " + calculate(PLUS, operand1, operand2));
        System.out.println("Subtracting: " + calculate(MINUS, operand1, operand2));
        System.out.println("Multiplying: " + calculate(MULTIPLY, operand1, operand2));
        System.out.println("Dividing: " + calculate(DIVIDE, operand1, operand2));

    }
    
   public static int calculate(MathOperator operator, int operand1, int operand2) {
         switch(operator) {
                case PLUS:
                      return operand1 + operand2;
                case MINUS:
                      return operand1 - operand2;
                case MULTIPLY:
                      return operand1 * operand2;
                case DIVIDE:
                      return operand1 / operand2;
                default:
                      throw new UnsupportedOperationException();
         }
   }
}
