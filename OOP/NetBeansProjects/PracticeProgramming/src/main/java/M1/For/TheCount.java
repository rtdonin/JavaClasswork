/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

What are the start/stop ranges of output for both loops?
The first loop starts at 0 and ends at 9. The second loop starts at 10 and ends at 1.
*/

package M1.For;

import java.util.Scanner;

public class TheCount {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        System.out.println("*** I LOVE TO COUNT! LET ME SHARE MY COUNTING WITH YOU! ***");
        System.out.print("Start at : ");
        int start = input.nextInt();
        
        System.out.print("\nEnd at : ");
        int end = input.nextInt();
        
        System.out.print("\nCount by : ");
        int increment = input.nextInt();
        
        int everyThird = 0;
        
        for (int i = start; i <= end; i+= increment) {
            System.out.print(i + " ");
            everyThird++;

            if (everyThird % 3 == 0){
                System.out.println("- Ah ah ah!");
            }
        }
    }
}