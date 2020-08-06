/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.strings;

import java.util.Arrays;

/**
 *
 * @author ahill
 */
public class StringsExerciseD {
    
    /**
     * Given a phrase string - turns the whole thing around.
     * Return the original, but totally backwards to forwards!
     *
     * 
     * Ex: 
     * simpleReverse( "fun times" ) ->  "semit nuf"
     * simpleReverse( "llama llama duck" ) ->  "kcud amall amall"
     * simpleReverse( "hannah" ) ->  "hannah"
     * 
     * @param phrase
     * @return String backwards
     */
    public static String simpleReverse(String phrase){
        int length = phrase.length();
        String revPhrase = "";
        
        for(int i = 0; i < length; i++) {
            revPhrase += phrase.charAt(length - i - 1);
        }
        
        return revPhrase;
    }
}
