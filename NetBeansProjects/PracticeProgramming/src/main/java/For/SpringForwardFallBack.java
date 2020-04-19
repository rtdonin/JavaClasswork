/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

What are the start/stop ranges of output for both loops?
The first loop starts at 0 and ends at 9. The second loop starts at 10 and ends at 1.

How can you update the first loop so that it prints out the same range as the second
loop, only changing only the start point or the stopping point?
From:
for (int i = 0; i < 10; i++) {
To:
for (int i = 1; i <= 10; i++) {
*/

package For;

public class SpringForwardFallBack {

    public static void main(String[] args) {

        System.out.println("It's Spring...!");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + ", ");
        }

        System.out.println("\nOh no, it's fall...");
        for (int i = 10; i > 0; i--) {
            System.out.print(i + ", ");
        }
    }
}