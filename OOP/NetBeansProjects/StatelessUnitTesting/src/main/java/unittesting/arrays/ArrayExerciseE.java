/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.arrays;

/**
 *
 * @author ahill
 */
public class ArrayExerciseE {
    
    /**
     * Given an array of words turn it into a single camelCased phrase.
     * Lower case the first word, capitalize the first letter (but only the first) of the rest.
     *
     * camelCaseIt( {"llama", "llama", "duck"}  ) ->  "llamaLlamaDuck"
     * camelCaseIt( {"lambs", "eat", "oats", "and", "does", "eat", "oats"}  ) ->  "lambsEatOatsAndDoesEatOats"
     * camelCaseIt( {"DO", "OR", "DO", "NOT", "THERE", "IS", "NO", "TRY"}  ) ->  "doOrDoNotThereIsNoTry"
     * @param words
     * @return String camelCased phrase
     */

    public static String camelCaseIt(String[] words){
        String camelCase = "";
        
        for(int i = 0; i < words.length; i++){
            String temp = words[i];
            if( i != 0) {
                temp = temp.substring(0, 1).toUpperCase() + temp.substring(1).toLowerCase();;
                
            } else {
                temp = temp.toLowerCase();
            }
            camelCase += temp;
        }
        
        return camelCase;
    }
    
}
