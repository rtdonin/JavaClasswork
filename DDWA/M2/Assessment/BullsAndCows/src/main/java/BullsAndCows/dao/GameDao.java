/*
Created by: Margaret Donin
Date created: 08/20/20
Date revised:
*/

package BullsAndCows.dao;

import BullsAndCows.dto.Game;
import java.util.List;

public interface GameDao {
    /**
     * Takes in the String answer.
     * Begins a new game and creates an new entry in the Game column.
     * Returns the new Game with an the correct gameId.
     * 
     * @param answer
     * @return Game
     */
    Game addGame (String answer);
    
    /**
     * Takes in the int id (the gameId) and returns the associated game.
     * 
     * @param id
     * @return Game
     */
    Game getGameByGameId (int id);
    
    /**
     * Returns all the games
     * 
     * @return List of Games
     */
    List<Game> getAllGames ();
    
    /**
     * CRUD method written for testing purposes.
     * Deleted a game based on the int id (gameId) and all associated attempts.
     * 
     * @param id 
     */
    void deleteGame (int id);
    
    /**
     * Updates a games status based on the int id (gameId).
     * NOTE: Will not update any other part of the game.
     * 
     * @param id 
     */
    void updateGame (int id);
}
