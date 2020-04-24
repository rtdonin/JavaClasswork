/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised:
*/

package Arrays;

import java.util.regex.*;

public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = { "Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry",
                "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",
                "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple",
                "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry" };

        String[] fruitSalad;

        // Code Recipe for fruit salad should go here!
        int indexOfSalad = 0;
        int numKindsOfBerries = 0;
        int numKindsOfApples = 0;
        int numKindsOfOrange = 0;
        int numKindsOfTomato = 0;


        System.out.println("Total list of fruits in salad: ");
        displayArray(fruitSalad);
        System.out.println("Number of fruits in salad:");
        System.out.println("There are " + numKindsOfBerries + " berries.");
        System.out.println("There are " + numKindsOfApples + " apples.");
        System.out.println("There are " + numKindsOfOrange + " oranges.");
        System.out.println("There are " + numKindsOfTomato + " tomatos.");
    }
    
    public static int[] matchToPattern(String pattern, String[] array) {
        String[] tempArray;
        // create patterns object
        Pattern fruitPattern = Pattern.compile(pattern);

        for (int i = 0; i < array.length; i++) {

            // create matcher objmatcherect
            Matcher fruitMatch = fruitPattern.matcher();

            if (fruitMatch.matches()) {
                
            }
        }
        
        return tempArray
    }
    
    public static void displayArray(String[] array){
        for (String element : array){
            System.out.print(element + " ");
        }
    }
}