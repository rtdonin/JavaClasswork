/*
Created by: Margaret Donin
Date created: 08/28/20
Date revised:
*/

package BullsAndCows.service;

import BullsAndCows.TestApplicationConfiguration;
import BullsAndCows.dao.GameDao;
import BullsAndCows.dto.Attempt;
import BullsAndCows.dto.Game;
import BullsAndCows.dto.GameVM;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class BullAndCowsServiceLayerTest {
    
    @Autowired
    private BullAndCowsServiceLayer service;
    
    @Autowired
    private GameDao gameDao;
    
    public BullAndCowsServiceLayerTest() {
    }
    
    @Before
    public void setUp() {
        List<Game> games = gameDao.getAllGames();
        for (Game game : games) {
            gameDao.deleteGame(game.getGameId());
        }
    }

    @Test
    public void testGetAllGames() {
        // Arrange
        GameVM one = service.addGame();
        GameVM two = service.addGame();
        
        // Act
        List<GameVM> games = service.getAllGames();
        
        // Assert
        assertNotNull(games, "List should not be null.");
        assertEquals(2, games.size(), "List should have two view model games.");
        assertTrue(games.contains(one), "List should include the first game.");
        assertTrue(games.contains(two), "List shoudl include the second game.");
    }

    @Test
    public void testGetAllAttempts() throws Exception {
        // Arrange
        GameVM game = service.addGame();
        int gameIdOne = game.getGameId();
        Attempt attemptOne = service.addAttempt(new Attempt(gameIdOne, "1123"));
        Attempt attemptTwo = service.addAttempt(new Attempt(gameIdOne, "5813"));
        
        game = service.addGame();
        int gameIdTwo = game.getGameId();
        service.addAttempt(new Attempt(gameIdTwo, "1123"));
        
        // Act
        List<Attempt> attempts = service.getAllAttempts(gameIdOne);
        
        // Assert
        assertEquals(2, attempts.size(), "Should only have two attempts.");
        assertTrue(attempts.contains(attemptOne), "List should include the first attempt.");
        assertTrue(attempts.contains(attemptTwo), "List should include the second attempt.");
    }

    @Test
    public void testGetGameById() throws Exception {
        // Arrange
        GameVM gameOne = service.addGame();
        int id = gameOne.getGameId();
        int badId = id + 1;
        
        // Act
        GameVM gameTwo = service.getGameById(id);
        
        // Assert
        assertEquals(gameOne, gameTwo, "Should be the same game.");
        
        try {
            service.getGameById(badId);
            fail("Should throw an NoSuchGameException.");
        } catch (NoSuchGameException ex) {
            // do nothing
        }
    }

    // Also tests method pickNewAnswer();
    @Test
    public void testAddGame() {
        // Arrange
        GameVM gameVM = service.addGame();
        Game game = gameDao.getGameByGameId(gameVM.getGameId());
        String answer = game.getAnswer();
        char[] digitsArray = answer.toCharArray();
        
        // Act
        // Hash set insures no repeats in digits.
        Set<Character> digitsSet = new HashSet<>();
        
        for (char c : digitsArray) {
            digitsSet.add(c);
        }
        
        // Assert
        assertNotNull(game, "Added game should not be null.");
        assertEquals(4, digitsSet.size(), "There should be only 4 numbers in the set.");
    }

    // Also tests method testAttempt and validateGuess
    @Test
    public void testAddAttempt() throws Exception {
        // Arrange
        GameVM game = service.addGame();
        int gameId = game.getGameId();
        String perfectScore = "e:4:p:0";
        
        // Can not be a correct answer because of the repeat numbers.
        String guess = "1111";
        Attempt attempt = new Attempt(gameId, guess);
       
        // Act
        attempt = service.addAttempt(attempt);
        game = service.getGameById(gameId);
        
        // Assert
        assertFalse(perfectScore.equals(attempt.getScore()), "Should not be a perfect score.");
        assertTrue(game.getStatus().equals("Game not finished."), "Game is incomplete and should not show answer.");
        
        /************************************************************
         * 
         * PART TWO OF TEST!
         * 
         ************************************************************/
        
        // Arrange
        // Obviously the correct answer
        guess = gameDao.getGameByGameId(gameId).getAnswer();
        attempt = new Attempt(gameId, guess);
        String answerStatus = "Game complete. Answer = " + guess;
        
        // Act
        attempt = service.addAttempt(attempt);
        game = service.getGameById(gameId);
        
        // Assert
        assertTrue(perfectScore.equals(attempt.getScore()), "Should be a perfect score.");
        assertTrue(game.getStatus().equals(answerStatus), "Game should be finished and show answer.");
        
        // Testing a bad gameId
        // Arrange
        int badId = gameId + 1;
        attempt = new Attempt(badId, guess);
        
        try {
            service.addAttempt(attempt);
            fail("Should throw Exception.");
        } catch (NoSuchGameException ex) {
            // do nothing
        }
        
        /************************************************************
         * 
         * PART THREE OF TEST!
         * 
         ************************************************************/
        
        // Arrange
        guess = "12";
        attempt = new Attempt(gameId, guess);
        
        // Act and Assert
        
        try {
            service.addAttempt(attempt);
            fail("Should throw Exception.");
        } catch (BadAttemptException ex) {
            // do nothing
        }
        
        // Arrange
        guess = "abcd";
        attempt = new Attempt(gameId, guess);
        
        // Act and Assert
        
        try {
            service.addAttempt(attempt);
            fail("Should throw Exception.");
        } catch (BadAttemptException ex) {
            // do nothing
        }
    }
    
}
