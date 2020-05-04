/*
Created by: Margaret Donin
Date created: 04/21/20
Date revised: 04/28/20

*/

package InterestCalculator;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InterestCalculator {
    private float initialPrinciple;
    private float annualInterestRate;
    private int years;
    private String frequency;
    private int freq;
    private float runningBalance;
    private float initialYearBalance;
        
    public void setUserInfo(){
        Scanner input = new Scanner(System.in);

        // collects user input
        System.out.print("How much do you want to invest? ");
        this.initialPrinciple = input.nextFloat();

        System.out.print("How many years are you investing? ");
        this.years = input.nextInt();
        
        System.out.print("What is the annual interest rate % growth? ");
        this.annualInterestRate = input.nextFloat();
        
        System.out.println("How often is this investment compounded?"
                + "\nA. Yearly"
                + "\nB. Quarterly"
                + "\nC. Monthly"
                + "\nD. Daily");
        this.frequency = input.next();        

        System.out.println("");
        System.out.println("\nCalculating...");

        printer();
    }

    public void printer() {
        float interest = 0;
        getFreq();
        runningBalance = initialPrinciple;

        // to provide the correct rounding
        Locale currentLocale = Locale.getDefault();
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(currentLocale);
        
        // prints the yearly breakdown
        for (int i = 1; i <= years; i++) {
            float end;
            interest = compounder();
            runningBalance = initialYearBalance + interest;
            
            System.out.println("Year " + i + ":");
            System.out.println("Began with " + currencyFormatter.format(initialYearBalance));
            System.out.println("Earned " + currencyFormatter.format(interest));
            System.out.println("Ended with " + currencyFormatter.format(runningBalance));
            System.out.println();
        }
    }
    
    // does the compounding returns only the interest earned per year
    public float compounder(){
        float interestTotal;

        initialYearBalance = runningBalance;
        
        for (int j = 0; j < freq; j++) {
            float interest = runningBalance * (annualInterestRate / freq / 100);
            runningBalance += interest;
        }
        
        interestTotal = runningBalance - initialYearBalance;

        return interestTotal;
    }
    
    
    // "translates" the user input into an interger
    public int getFreq(){
        switch(frequency){
            case "A" : freq = 1;
                break;
            case "B" : freq = 4;
                break;
            case "C" : freq = 12;
                break;
            case "D" : freq = 365;
                break;
            default:
                System.out.println("Please try again.");
                System.exit(0);
        }
        return freq;
    }
    
}

//Additional Challenges
//Change the program so that interest is compounded monthly.
//Change the program so that the user can choose from quarterly, monthly, or daily interest compound periods.