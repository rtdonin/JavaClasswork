/*
Created by: Margaret Donin
Date created: 04/19/20
Date revised:
*/
package M1.For;

public class DifferentKettleOfFish {
    public static void main(String[] args) {

        int fish = 1;
        while(fish <= 10){
            if(fish == 3){
                System.out.println("RED fish!");
            }else if(fish == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish + " fish!");
            }

            fish++;
        }
        
        for (int fish2 = 1; fish2 <= 10; fish2++){
            if(fish2 == 3){
                System.out.println("RED fish!");
            }else if(fish2 == 4){
                System.out.println("BLUE fish!");
            } else{
                System.out.println(fish2 + " fish!");
            }
        }

    }
}