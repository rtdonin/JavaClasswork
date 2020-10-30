/*
Created by: Margaret Donin
Date created: 08/23/20
Date revised:
*/

package BullsAndCows.dao;

import BullsAndCows.TestApplicationConfiguration;
import BullsAndCows.dto.Attempt;
import BullsAndCows.dto.Game;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class GameDatabaseDaoTest {
    
    @Autowired
    private AttemptDao attemptDao;
        
    @Autowired
    private GameDao gameDao;

    private String answerOne;
    private Game gameOne;
    
    public GameDatabaseDaoTest() {
    }
    
    @Before
    public void setUp() {
        List<Game> games = gameDao.getAllGames();
        
        // Cleares Games and Attempts.
        for (Game game : games) {
            gameDao.deleteGame(game.getGameId());
        }
        
        // Part of arrange and act for all test methods
        // repeating the same bit of code just doesn't seem necessary.
        this.answerOne = "1234";                    // Arrange
        this.gameOne = gameDao.addGame(answerOne);  // Act
    }

    @Test
    public void testGetAddGames() {
        // Arrange
        
        // Act
        Game gameTwo = gameDao.getGameByGameId(gameOne.getGameId());
        
        // Assert
        assertEquals(gameTwo, gameOne, "Both games should be equal.");
        assertFalse(gameOne.getIsFinished(), "Should be false.");
    }
    
    @Test
    public void testGetAllGames() {
        // Arrange
        String answerTwo = "5678";
        
        // Act
        Game gameTwo = gameDao.addGame(answerTwo);
        List<Game> testGames = gameDao.getAllGames();
        
        //Assert
        assertEquals(2, testGames.size(), "There should be two games.");
        assertTrue(testGames.contains(gameOne), "List should contain test game one.");
        assertTrue(testGames.contains(gameTwo), "List should contain test game two.");    
    }

    @Test
    public void testDeleteGame() {
        // Arrange        
        // Create Attempts
        int gameId = gameOne.getGameId();
        Attempt attemptOne = new Attempt(gameId, "2453");
        Attempt attemptTwo = new Attempt(gameId, "1532");
        
        attemptOne.setScore("e:0:p:3");
        attemptTwo.setScore("e:1:p:2");

        // Act
        // Add Attempts to DB
        attemptDao.addAttempt(attemptOne);
        attemptDao.addAttempt(attemptTwo);
        
        // Remove Game Attempts are associated with.
        gameDao.deleteGame(gameId);
        
        // Get all Attempts
        List<Attempt> attempts = attemptDao.getAllAttempts();
        
        // Assert
        assertTrue(attempts.isEmpty(), "Should be empty.");
    }

    @Test
    public void testUpdateGame() {
        // Arrange
        int gameId = gameOne.getGameId();

        // Act
        gameDao.updateGame(gameId);
        gameOne = gameDao.getGameByGameId(gameId);
        
        // Assert
        assertTrue(gameOne.getIsFinished(), "Should be true.");
        
    }
    
}
