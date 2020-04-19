/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:

Did you use a while loop or do-while loop? Why?
A do-while loop. I think this one depends on the condition you provide.

*/

package WhilesAndDos;

public class LovesMe {
    public static void main(String[] args) {
        System.out.println("Well here goes nothing...");
        
        int petal = 1;
        
        do{
            if (petal % 2 != 0){
                System.out.println("It loves me NOT!");
            } else{
                System.out.println("It LOVES me!");
            }
            
            petal++;
            
        } while (petal <= 34);
            System.out.println("I knew it! It LOVES ME!");
    }
}
