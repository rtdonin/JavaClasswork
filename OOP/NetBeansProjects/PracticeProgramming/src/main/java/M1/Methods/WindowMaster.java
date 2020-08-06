/*
Created by: Margaret Donin
Date created: 04/19/20
Date revised:

Note: Code copied from Lesson 8. This was to make it easier to follow along.
*/
package M1.Methods;

import java.util.Scanner;

public class WindowMaster {
    public static void main(String[] args) {
        // Declare variables for height and width
        float height;
        float width;
//        // Declare String variables to hold the user's height and width
//        // input
//        String stringHeight;
//        String stringWidth;

        // Declare other variables
        float areaOfWindow;
        float cost;
        float perimeterOfWindow;

        // Declare and initialize our Scanner
        Scanner sc = new Scanner(System.in);
//
//        // Get input from user
//        System.out.println("Please enter window height:");
//        stringHeight = sc.nextLine();
//        System.out.println("Please enter window width:");
//        stringWidth = sc.nextLine();

//        // Convert String values of height and width to floats
//        height = Float.parseFloat(stringHeight);
//        width = Float.parseFloat(stringWidth);

        // get input from user
        height = readValue ("Please enterr window height:");
        width = readValue ("Please enter windot width");

        // Calculate area of window
        areaOfWindow = height * width;

        // Calculate the perimeter of the window
        perimeterOfWindow = 2 * (height + width);

        // Calculate total cost - use hard coded for material cost
        cost = ((3.50f * areaOfWindow) + (2.25f * perimeterOfWindow));

        System.out.println("Window height = " + height);
        System.out.println("Window width = " + width);
        System.out.println("Window area = " + areaOfWindow);
        System.out.println("Window perimeter = " + perimeterOfWindow);
        System.out.println("Total Cost = " + cost);
    }
    
    public static float readValue(String prompt) {
        // Declare and initialize our Scanner
        Scanner sc = new Scanner(System.in);
        // print prompt to console
        System.out.println(prompt);
        // read value into String data type
        String input = sc.nextLine();
        // convert the String to a float
        float floatVal = Float.parseFloat(input);
        // return the float vaule
        return floatVal;
    }
}
    
    
    
    
    
    
    
    
    

