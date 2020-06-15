/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package unittesting.strings;

/**
 *
 * @author ahill
 */
public class StringsExerciseC {

    /**
     * Take a word, and remove all its vowels and returns it.
     *
     * Ex:
     * removeTheVowels( "truncate" ) ->  "trnct"
     * removeTheVowels( "squashed" ) ->  "sqshd"
     * removeTheVowels( "compressed" ) ->  "cmprssd"
     * @param word
     * @return String
     */
    public static String removeTheVowels(String word){
        String vowelsRemoved = "";
        
        for(int i = 0; i < word.length(); i++){
            char letter = word.charAt(i);
            if(letter != 'a' && letter != 'e' && letter != 'i' && letter != 'o'&& letter != 'u') {
                vowelsRemoved += letter;
            }
        }
        
        return vowelsRemoved;
    }
    
}
