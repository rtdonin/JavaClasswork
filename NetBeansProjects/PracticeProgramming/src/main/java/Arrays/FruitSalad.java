/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised: 04/24/20

I went big, but needed to go home instead. Wasn't ready to do it the way I wanted to.
*/

package Arrays;

public class FruitSalad {
    public static void main(String[] args) {
        String[] fruit = { "Kiwi Fruit", "Gala Apple", "Granny Smith Apple", "Cherry Tomato", "Gooseberry",
                "Beefsteak Tomato", "Braeburn Apple", "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",
                "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple", "Blackberry", "Banana", "Pineapple",
                "Florida Orange", "Kiku Apple", "Mango", "Satsuma Orange", "Watermelon", "Snozzberry" };

        String[] fruitSalad = new String [12];

        // Code Recipe for fruit salad should go here!
        int numKindOfBerry = 0;
        int numKindOfApple = 0;
        int numKindOfOrange = 0;
        int numKindOfOther = 0;
        int fruitIndex = 0;

        for (int i = 0; i < fruit.length && fruitIndex < fruitSalad.length; i++) {
            if (fruit[i].contains("berry")) {
                fruitSalad[fruitIndex] = fruit[i];
                numKindOfBerry++;
                fruitIndex++;
            }
        }
        
        for (int i = 0; i < fruit.length && fruitIndex < fruitSalad.length; i++) {
            if (fruit[i].contains("Apple") && numKindOfApple < 3) {
                fruitSalad[fruitIndex] = fruit[i];
                numKindOfApple++;
                fruitIndex++;
                
            } else if (fruit[i].contains("Orange") && numKindOfOrange < 2) {
                fruitSalad[fruitIndex] = fruit[i];
                numKindOfOrange++;
                fruitIndex++;

            } else if (!fruit[i].contains("Tomato") && !fruit[i].contains("berry")
                    && !fruit[i].contains("Apple") && !fruit[i].contains("Orange")){
                fruitSalad[fruitIndex] = fruit[i];
                numKindOfOther++;
                fruitIndex++;
            }
                
        }
        System.out.println("Total list of fruits in salad: ");
        
        for (int i = 1; i < fruitSalad.length; i++){
            System.out.print(fruitSalad[i-1] + " ");
            if (i % 4 == 0){
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Number of fruits in salad:");
        System.out.println("There are " + numKindOfBerry + " berries.");
        System.out.println("There are " + numKindOfApple + " apples.");
        System.out.println("There are " + numKindOfOrange + " oranges.");
        System.out.println("There are " + numKindOfOther + " other fruit.");
    }
}