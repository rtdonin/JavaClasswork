/*
Created by: Margaret Donin
Date created: 04/21/20
Date revised:

*/

package M1.Summary;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InterestCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float initialPrinciple;
        float annualInterestRate;
        int years;
        String frequency;
        char freq;

        // collects user input
        System.out.print("How much do you want to invest? ");
        initialPrinciple = input.nextFloat();

        System.out.print("How many years are you investing? ");
        years = input.nextInt();
        
        System.out.print("What is the annual interest rate % growth? ");
        annualInterestRate = input.nextFloat();
        
        System.out.println("How often is this investment compounded?"
                + "\nA. Yearly"
                + "\nB. Quarterly"
                + "\nC. Monthly"
                + "\nD. Daily");
        frequency = input.next();
        freq = frequency.charAt(0);
        

        System.out.println("");
        System.out.println("\nCalculating...");

        printer(years, initialPrinciple, annualInterestRate, freq);
    }

    public static void printer(int year, float balance, float interestRate, char freq) {
        float interest = 0;
        int frequency = freqOfCompounder(freq);

        // to provide the correct rounding
        Locale currentLocale = Locale.getDefault();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        
        // prints the yearly breakdown
        for (int i = 1; i <= year; i++) {
            float end;
            interest = compounder(interestRate, balance, frequency);
            end = balance + interest;
            
            System.out.println("Year " + i + ":");
            System.out.println("Began with " + currencyFormatter.format(balance));
            System.out.println("Earned " + currencyFormatter.format(interest));
            System.out.println("Ended with " + currencyFormatter.format(end));
            System.out.println();
            balance = end;
        }
    }
    
    // does the compounding returns only the interest earned per year
    public static float compounder(float rate, float balance, int frequency){
        float interestTotal;
        float initialBalance = balance;

        for (int j = 0; j < frequency; j++) {
                float interest = balance * (rate / frequency / 100);
                balance += interest;
        }
        
        interestTotal = balance- initialBalance;

        return interestTotal;
    }
    
    // "translates" the user input into an interger
    public static int freqOfCompounder(char freq){
        int frequency = 0;
        switch(freq){
            case 'A' : frequency = 1;
                break;
            case 'B' : frequency = 4;
                break;
            case 'C' : frequency = 12;
                break;
            case 'D' : frequency = 365;
                break;
            default:
                System.out.println("Please try again.");
                System.exit(0);
        }
        
        return frequency;
    }
    
}

//Additional Challenges
//Change the program so that interest is compounded monthly.
//Change the program so that the user can choose from quarterly, monthly, or daily interest compound periods.