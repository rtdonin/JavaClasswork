/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.DateTimeApi.MagicalBirthdayCalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class BirthdayCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Welcome to the Magical BirthDAY Calculator!\n");
        System.out.println("When is your birthday?");
        String userBirthday = input.nextLine(); // gets user input
        LocalDate birthDate = LocalDate.parse(userBirthday); // converts to date
        
        LocalDate today = LocalDate.now(); // today
        DayOfWeek birthDayOfWeek = birthDate.getDayOfWeek(); // the day of the week
        
        LocalDate birthday = birthDate.withYear(today.getYear()); // birthday this year
        
        if(birthday.isBefore(today)) {
            birthday = birthDate.withYear(today.getYear()+ 1);
        }
       
        DayOfWeek fallDayOfWeek = birthday.getDayOfWeek(); // Day of week of bday this year
        
        Period daysUntilBday = today.until(birthday); // days until next
        Period age = birthDate.until(birthday);

        System.out.println("That means you were born on a " + birthDayOfWeek + "!");
        System.out.println("This year it falls on a " + fallDayOfWeek + "...");
        System.out.println("And since today is " + today + " there's only " + daysUntilBday + " more days until the next one!");
        System.out.println("Bet yer excited to be turning " + age + "!");
    }
}
