/*
Created by: Margaret Donin
Date created: 05/31/20
Date revised:
*/

package M3.Enums.DaysUntilFriday;

import static M3.Enums.DaysUntilFriday.Days.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("What day of the week is today?");
        String todayAsString = input.nextLine().trim().toUpperCase();
        Days today = Days.valueOf(todayAsString);
        
        String message = calculateDays(today);
        
        System.out.println(message);
    }
    
    public static String calculateDays(Days today) {
        
        switch(today) {
            case SATURDAY:
                return "6 Days until Friday";
            case SUNDAY:
                return "5 Days until Friday";
            case MONDAY:
                return "4 Days until Friday";
            case TUESDAY:
                return "3 Days until Friday";
            case WEDNESDAY:
                return "2 Days until Friday";
            case THURSDAY:
                return "1 Day until Friday";
            case FRIDAY:
                return "TGIF";
            default: throw new UnsupportedOperationException();
        }
    }
}
