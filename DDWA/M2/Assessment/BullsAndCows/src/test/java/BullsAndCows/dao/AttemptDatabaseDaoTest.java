/*
Created by: Margaret Donin
Date created: 08/24/20
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class AttemptDatabaseDaoTest {
    
    @Autowired
    private AttemptDao attemptDao;
        
    @Autowired
    private GameDao gameDao;
    
    private Game gameOne;
    private Attempt attemptOne;

    public AttemptDatabaseDaoTest() {
    }

    @Before
    public void setUp() {
        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            gameDao.deleteGame(game.getGameId());
        }
        
        // Part of arrange and act for all test methods
        // repeating the same bit of code just doesn't seem necessary.
        
        this.gameOne = gameDao.addGame("1234");
        
        this.attemptOne = new Attempt(gameOne.getGameId(),"1345");
        this.attemptOne.setScore("e:1:p:2");
        this.attemptOne = attemptDao.addAttempt(attemptOne);
    }
    
    @Test
    public void testGetAddAttempt() {
        // Arrange
        int attemptId = attemptOne.getAttemptId();
        
        // Act
        Attempt attemptTwo = attemptDao.getAttemptByAttemptId(attemptId);
        
        // Assert
        assertEquals(attemptOne, attemptTwo, "Should be equal.");
    }

    @Test
    public void testGetAllAttempts() {
        // Arrange
        Attempt attemptTwo = new Attempt(gameOne.getGameId(),"6584");
        attemptTwo.setScore("e:1:p:0");
        
        // Act
        attemptTwo = attemptDao.addAttempt(attemptTwo);
        List<Attempt> testAttempts = attemptDao.getAllAttempts();
        
        // Assert
        assertEquals(2, testAttempts.size(), "The list should have only two attempts.");
        assertTrue(testAttempts.contains(attemptOne), "The list should contain the first attempt.");
        assertTrue(testAttempts.contains(attemptTwo), "The list should contain the second attempt.");
    }

    @Test
    public void testGetAllAttemptsByGameId() {
        // Arrange
        // Second Attempt for game one.
        int gameOneId = gameOne.getGameId();
        
        Attempt attemptTwo = new Attempt(gameOne.getGameId(),"6584");
        attemptTwo.setScore("e:1:p:0");
        attemptTwo = attemptDao.addAttempt(attemptTwo);
        
        // Second Game and attempt for that game.
        Game gameTwo = gameDao.addGame("5678");
        int gameTwoId = gameTwo.getGameId();
        
        Attempt attemptThree = new Attempt(gameTwoId, "5842");
        attemptThree.setScore("e:1:p:1");
        attemptThree = attemptDao.addAttempt(attemptThree);
        
        // Act
        List<Attempt> gameOneAttempts = attemptDao.getAllAttemptsByGameId(gameOneId);
        List<Attempt> gameTwoAttempts = attemptDao.getAllAttemptsByGameId(gameTwoId);

        // Assert
        assertEquals(2, gameOneAttempts.size(), "There should only be two attempts.");
        assertTrue(gameOneAttempts.contains(attemptOne), "List should contain first attempt.");
        assertTrue(gameOneAttempts.contains(attemptTwo), "List should contain second attempt.");
        
        assertEquals(1, gameTwoAttempts.size(), "There should only be one attempts.");
        assertTrue(gameTwoAttempts.contains(attemptThree), "List should contain third attempt.");
    }

    @Test
    public void testDeleteAttempt() {
        // Arrange
        int id = attemptOne.getAttemptId();
        
        // Act
        attemptDao.deleteAttempt(id);
        Attempt attemptTwo = attemptDao.getAttemptByAttemptId(id);
        
        // Assert
        assertNull(attemptTwo, "Should not exist.");
    }

    @Test
    public void testUpdateAttempt() {
        // Arrange
        int id = attemptOne.getAttemptId();
        // New attempt is copied data but different from attempt one.
        Attempt attemptTwo = new Attempt();
        attemptTwo.setAttemptId(id);
        attemptTwo.setGameId(gameOne.getGameId());
        attemptTwo.setGuess("6584");
        attemptTwo.setScore("e:1:p:0");

        // Act
        attemptDao.updateAttempt(attemptTwo);
        Attempt testAttempt = attemptDao.getAttemptByAttemptId(id);
        
        // Assert
        assertEquals(attemptTwo, testAttempt, "Should be equal. Are the same.");
        assertNotEquals(attemptOne, testAttempt, "Should not be equal.");
    }
    
}
