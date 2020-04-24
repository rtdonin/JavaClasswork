/*
Created by: Margaret Donin
Date created: 04/22/20
Date revised:
*/

package Scanner;

import java.util.Scanner;

public class DoItBetter{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int answer;

        System.out.print("How many miles can you run? ");
        answer = 2 * scan.nextInt() + 1;
        System.out.println("Well I can run " + answer + " miles.");

        System.out.print("How many hot dogs can you eat? ");
        answer = 2 * scan.nextInt() + 1;
        System.out.println("Well I can eat " + answer + " hot dogs.");

        System.out.print("How many languages do you know? ");
        answer = 2 * scan.nextInt() + 1;
        System.out.println("Well I know " + answer + " languages.");

    }
}