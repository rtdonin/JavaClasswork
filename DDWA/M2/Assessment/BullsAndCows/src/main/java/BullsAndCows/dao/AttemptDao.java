/*
Created by: Ma/garet Donin
Date created: 08/21/20
Date revised:
*/

package BullsAndCows.dao;

import BullsAndCows.dto.Attempt;
import java.util.List;

public interface AttemptDao {
    /**
     * Creates an attempt entry in the table and returns a completed Attempt object
     * with associated attemptId
     * 
     * @param attempt
     * @return attempt
     */
    Attempt addAttempt (Attempt attempt);
    
    /**
     * Returns as attempt by attemptId
     * CRUD method written for testing purposes.
     * 
     * @param id
     * @return 
     */
    Attempt getAttemptByAttemptId (int id);
    
    /**
     * Returns a list of all Attempts.
     * CRUD method written for testing purposes.
     * 
     * @return a list of all Attempts
     */
    List<Attempt> getAllAttempts ();
    
    /**
     * Take in an int id (gameId) and returns all associated attempts.
     * Meaning any attempt with a matching gameId.
     * 
     * @param id
     * @return List of attempts.
     */
    List<Attempt> getAllAttemptsByGameId (int id);
    
    /**
     * Takes in an int id (attemptId) and deletes the attempt.
     * CRUD method written for testing purposes.
     * 
     * @param id 
     */
    void deleteAttempt (int id);
    
    /**
     * Takes in an attempt and updates all the properties.
     * CRUD method written for testing purposes.
     * 
     * @param attempt 
     */
    void updateAttempt (Attempt attempt);
}
