package M1.Scanner;

/*
Created by: Margaret Donin
Date created: 04/14/20
Date revised:

Goal of Assignment:

Prompt the user for the height of the window (in feet).
Prompt the user for the width of the window (in feet).
Calculate and display the area of the window.
Calculate and display the perimeter of the window.
Calculate the total cost of the window.
    glass is $3.50 per square foot.
    trim is $2.25 per linear foot.

Go Further:

Prompts for the cost of the window and trim.
Prompt the user to enter the number of windows in addition.
Update the cost calculations to include the number of windows.
Include a try/catch validation on the user input. --> did not do.
    the variable might not get initialized and therefore other part of
    the code need to be reworked. Due to time constraints I will
    come back to this if I have time Sunday night but not before then.
        try{this code}catch(possible error){run this code}
*/

import java.util.Scanner;

public class WindowMaster {
    public static void main(String[] args) {
        // declare variables for height, width, and costs
        float height;
        float width;
        float glassCost;
        float trimCost;
        float numberOfWindows;
        
        
        // declare String variables to hold input
        String stringHeight;
        String stringWidth;
        String stringGlassCost;
        String stringTrimCost;
        String stringNumberOfWindows;
        
        // declating other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;
        
        // declare and initialize the Scanner
        Scanner myScanner = new Scanner(System.in);
        
        // get input from the user
        System.out.println("Please enter window height:");
        stringHeight = myScanner.nextLine();
        System.out.println("Please enter window width:");
        stringWidth = myScanner.nextLine();
        System.out.println("Please enter window glass cost:");
        stringGlassCost = myScanner.nextLine();
        System.out.println("Please enter window trim cost:");
        stringTrimCost = myScanner.nextLine();
        System.out.println("Please enter number of windows:");
        stringNumberOfWindows = myScanner.nextLine();
        
        // convert String values of height and width to float values
        height = Float.parseFloat(stringHeight);
        width = Float.parseFloat(stringWidth);
        glassCost = Float.parseFloat(stringGlassCost);
        trimCost = Float.parseFloat(stringTrimCost);
        numberOfWindows = Float.parseFloat(stringNumberOfWindows);
        
        // calculate the area of the window
        areaOfWindow = height * width;
        
        // calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);
        
        // calculate total cost
        cost = numberOfWindows * (areaOfWindow * glassCost + perimeterOfWindow * trimCost);
        
        // display the results to the user
        System.out.println("Window height = " + stringHeight);
        System.out.println("Window width = " + stringWidth);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);        
    }
}
    
    
    
    
    
    
    
    
    

