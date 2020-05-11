/*
Created by: Margaret Donin
Date created: 04/28/20
Date revised: 05/07/20
*/

package M2.ListsAndMaps.SimpleCalculator;
import M2.ListsAndMaps.UserIOClassLab.UserIOImpl;

public class SimpleCalculator{
    UserIOImpl userIO = new UserIOImpl();
    private int numberOne;
    private int numberTwo;
    private int operation;

    public void setNumberOne(String numberOne){
        this.numberOne = userIO.readInt(numberOne);
    }

    public void setNumberTwo(String numberTwo) {
        this.numberTwo = userIO.readInt(numberTwo);
    }
    
    public void setOperation(String operation){
        this.operation = userIO.readInt(operation, 1, 5);

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