/*
Created by: Margaret Donin
Date created: 04/28/20
Date revised: 04/29/20
*/

package simplecalculator;

public class SimpleCalculator{
    private int numberOne;
    private int numberTwo;
    private int operation;

    public void setNumberOne(int numberOne){
        this.numberOne = numberOne;
    }

    public void setNumberTwo(int numberTwo) {
        this.numberTwo = numberTwo;
    }
    
    public void setOperation(int operation){
        this.operation = operation;

        if (this.operation == 5){
                System.out.println("Thank you!");
                System.exit(0);
            }        
    }
    
    public void getOperation(){
        switch (operation){
            case 1: System.out.println("The sum of " + numberOne + " and " + numberTwo + " is " + add());
                break;
            case 2: System.out.println("The difference between " + numberOne + " and " + numberTwo + " is "+ subtract());
                break;
            case 3: System.out.println("The product  of " + numberOne + " and " + numberTwo + " is "+ multiply());
                break;
            case 4: System.out.println("The quotient  of " + numberOne + " and " + numberTwo + " is " + divide());
                break;
        }
        
    }

    private int add() {
        return numberOne + numberTwo;
    }

    private int subtract() {
        return numberOne - numberTwo;
    }

    private int multiply() {
        return numberOne * numberTwo;
    }

    private float divide() {
        return (float)numberOne / numberTwo;
    }
}