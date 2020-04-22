/*
Created by: Margaret Donin
Date created: 04/20/20
Date revised:
*/

package Arrays;

public class FruitBasket {

    public static void main(String[] args) {
        String[] fruitBasket = {"Orange", "Apple", "Orange", "Apple", "Orange", "Apple",
            "Orange", "Apple", "Orange", "Orange", "Orange", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Apple", "Apple",
            "Orange", "Orange", "Apple", "Apple", "Apple", "Banana", "Apple", "Orange",
            "Orange", "Apple", "Apple", "Orange", "Orange", "Orange", "Orange", "Apple",
            "Apple", "Apple", "Apple", "Orange", "Orange", "PawPaw", "Apple", "Orange",
            "Orange", "Apple", "Orange", "Orange", "Apple", "Apple", "Orange", "Orange",
            "Apple", "Orange", "Apple", "Kiwi", "Orange", "Apple", "Orange",
            "Dragonfruit", "Apple", "Orange", "Orange"};

        int numOranges = 0;
        int numApples = 0;
        int numOtherFruit = 0;

        for (int i = 0; i < fruitBasket.length; i++){
            if (fruitBasket[i].equals("Apple")){
                numApples++;
            } else if (fruitBasket[i].equals("Orange")){
                numOranges++;
            } else {
                numOtherFruit++;
// I would prefer to take the length of fruitBasket and just subtract numApples
//and numOanges. But I'm willing to bet this is how they wanted it.
            }
        }

        System.out.println("Total# of Fruit in Basket: " + fruitBasket.length);
        System.out.println("Number of Apples: " + numApples);
        System.out.println("Number of Oranges: " + numOranges);
        System.out.println("Number of Other Fruit: " + numOtherFruit);

    }
}