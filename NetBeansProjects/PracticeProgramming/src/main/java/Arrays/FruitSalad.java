///*
//Created by: Margaret Donin
//Date created: 04/20/20
//Date revised:
//*/
//
//package Arrays;
//
//import java.util.regex.*;
//
//public class FruitSalad {
//    public static void main(String[] args) {
//        String[] fruit = {"Kiwi Fruit", "Gala Apple", "Granny Smith Apple",
//            "Cherry Tomato", "Gooseberry", "Beefsteak Tomato", "Braeburn Apple",
//            "Blueberry", "Strawberry", "Navel Orange", "Pink Pearl Apple",
//            "Raspberry", "Blood Orange", "Sungold Tomato", "Fuji Apple",
//            "Blackberry", "Banana", "Pineapple", "Florida Orange", "Kiku Apple",
//            "Mango", "Satsuma Orange", "Watermelon", "Snozzberry"};
//
//        String[] fruitSalad = new String[fruit.length];
//        
//        // Code Recipe for fruit salad should go here!
//
//        // create patterns object
//        Pattern pBerries = Pattern.compile("berry");
//        Pattern pApples = Pattern.compile("Apple");
//        Pattern pOrange = Pattern.compile("Orange");
//        Pattern pTomato = Pattern.compile("Tomato");
//        
//        int indexOfSalad = 0;
//        int numKindsOfApples = 0;
//        int numKindsOfOrange = 0;
//        String[] typesOfFruit = new String[12];
//        
//        for (int i = 0; i < fruit.length && !typesOfFruit[11].equals(null); i++){
//
//            // create matcher objmatcherect
//            Matcher mBerries = pBerries.matcher(fruit[i]);
//            Matcher mApples = pApples.matcher(fruit[i]);
//            Matcher mOrange = pOrange.matcher(fruit[i]);
//            Matcher mTomato = pTomato.matcher(fruit[i]);
//
//            if (mBerries.matches()){
//                fruitSalad[indexOfSalad] = fruit[i];
//                indexOfSalad++;
//                
//                if (!indexOf(typesOfFruit, fruit[i])){
//                    typesOfFruit[typesOfFruit.length-1] = fruit[i];
//                }
//            } else if (mApples.matches() && numKindsOfApples <= 3){
//                fruitSalad[indexOfSalad] = fruit[i];
//                indexOfSalad++;
//                
//                if (!indexOf(typesOfFruit, fruit[i])){
//                    typesOfFruit[typesOfFruit.length-1] = fruit[i];
//                    numKindsOfApples++;
//                }
//            } else if (mOrange.matches() && numKindsOfOrange <= 2){
//                fruitSalad[indexOfSalad] = fruit[i];
//                indexOfSalad++;
//
//                if (!indexOf(typesOfFruit, fruit[i])){
//                    typesOfFruit[typesOfFruit.length-1] = fruit[i];
//                    numKindsOfOrange++;
//                }
//
//            } else if (mTomato.matches()){
//                continue;
//            } else{
//                fruitSalad[indexOfSalad] = fruit[i];
//                indexOfSalad++;
//                
//                if (!indexOf(typesOfFruit, fruit[i])){
//                    typesOfFruit[typesOfFruit.length-1] = fruit[i];
//                    numKindsOfApples++;
//                }
//            }
//        }
//        
//        System.out.println("Types of fruits in salad: ");
//        displayArray(typesOfFruit);
//        System.out.println("Number of fruits types in salad: " + typesOfFruit.length);
//
//        System.out.println("Total list of fruits in salad: ");
//        displayArray(fruitSalad);
//        System.out.println("Number of fruits in salad: " + indexOfSalad);
//    }
//    
//    public static void indexOf(String[] array, String elementOfInterest, int){
//        for (String element : array) {
//            if (element.equals(elementOfInterest)) {
//                itExists = true;
//                break;
//            }
//        }
//        return itExists;
//    }
//    
//    public static void displayArray(String[] array){
//        for(String element : array){
//            System.out.println(element);
//        }
//    }
//}