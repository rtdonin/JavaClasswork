/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
*/

package M2.Object.Factorizing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Factorizing myFactorizing = new Factorizing();
        Scanner input = new Scanner(System.in);

        System.out.print("What number would you like to factor? ");
        myFactorizing.setUserNum(input.nextInt());
        myFactorizing.getStats();
    }    
}