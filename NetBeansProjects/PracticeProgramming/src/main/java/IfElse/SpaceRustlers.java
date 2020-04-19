/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

What does the else if and if do?

If the first statement is true, run this code.
If the first statement is false, try the second bit.
Continue until the end of the else if statements until something
is true or you are out of the statemets.

If you remove the else from the else if, what does THAT do?
Each if statments will get evaluated for sure and seperately.
*/

package IfElse;

public class SpaceRustlers{
    public static void main(String[] args) {

        int spaceships = 10;
        int aliens = 25;
        int cows = 5;

        if (aliens > spaceships){
            System.out.println("Vrroom, vroom! Let's get going!");
        } else {
            System.out.println("There aren't enough green guys to drive these ships!");
        }

        if (cows == spaceships){
            System.out.println("Wow, way to plan ahead! JUST enough room for all these walking hamburgers!");
        } else if (cows > spaceships){
            System.out.println("Dangit! I don't how we're going to fit all these cows in here!");
        } else {
            System.out.println("Too many ships! Not enough cows.");
        }
        
        if (aliens > cows) {
            System.out.println("Hurrah, we've got the grub! Hamburger party on Alpha Centauri!");
        } else if (aliens <= cows){
            System.out.println("Oh no! The herds got restless and took over! Looks like we're hamburger now!!");
        }

    }
}