/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.logic;

/**
 *
 * @author ahill
 */
public class LogicExerciseB {

    /**
     * Given a number, return the 'place rank' word associated with it.
     * I.e. pretend you're ranking folks running in a race from the order they
     * arrived at the finish line. Assume nonzero, positive inputs! 
     * Also, start by going up to 100, but stretch to more if you can!
     *
     * Ex:
     * placeOf( 1 ) ->   "1st"
     * placeOf( 3 ) ->   "3rd"
     * placeOf( 22 ) ->   "22nd"
     *
     * @param place
     * @return String
     */
    public static String placeOf(int place) {
        String placeString = String.valueOf(place);
        char ones = placeString.charAt(placeString.length() - 1);
        
        switch(ones) {
            case '1': placeString += "st";
                break;
            case '2': placeString += "nd";
                break;
            case '3': placeString += "rd";
                break;
            default: placeString += "th";
        }
        
        return placeString;
    }

}
