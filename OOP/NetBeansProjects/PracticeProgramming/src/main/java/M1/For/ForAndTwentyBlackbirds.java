/*
Created by: Margaret Donin
Date created: 04/17/20
Date revised:

What did you change to update the bird number printouts so the count is from 1 - 24?
Line 16 was changed from:
"for (int i = 0; i < 20; i++) {"
to
"for (int i = 1; i <= 24; i++) {"
*/

package M1.For;

public class ForAndTwentyBlackbirds {

    public static void main(String[] args) {
        int birdsInPie = 0;
        for (int i = 1; i <= 24; i++) { // this line
            System.out.println("Blackbird #" + i + " goes into the pie!");
            birdsInPie++;
        }

        System.out.println("There are " + birdsInPie + " birds in there!");
        System.out.println("Quite the pie full!");
    }
}