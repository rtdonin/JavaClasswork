/*
Created by: Margaret Donin
Date created: 04/18/20
Date revised:

What happens if you change bedTime's value to 11?
The while loop will continue until 10 and on 11 print out:
Oh. It's 11 o'clock.
Guess I should go to bed ..

What about using bedTime's original value, but changing timeNow to 11?
The while loop will never be inititated and will just skip to:
Oh. It's 11 o'clock.
Guess I should go to bed ..

If you comment out timeNow++ at the end of the loop, what happens?
It becomes an infinite loop. And will never stop printing out:
It's only 5 o'clock!
I think I'll stay up just a liiiiittle longer....
*/

package M1.WhilesAndDos;

public class WaitAWhile {

    public static void main(String[] args) {

        int timeNow = 5;
        int bedTime = 10;

        while (timeNow < bedTime) {
            System.out.println("It's only " + timeNow + " o'clock!");
            System.out.println("I think I'll stay up just a liiiiittle longer....");
            timeNow++; // Time passes
        }

        System.out.println("Oh. It's " + timeNow + " o'clock.");
        System.out.println("Guess I should go to bed ...");
    }
}