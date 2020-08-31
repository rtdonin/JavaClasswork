/*
Created by: Margaret Donin
Date created: 08/20/20
Date revised:
*/

package BullsAndCows.service;

import BullsAndCows.controller.NoSuchGameException;
import BullsAndCows.dao.AttemptDatabaseDao;
import BullsAndCows.dao.GameDatabaseDao;
import BullsAndCows.dto.Attempt;
import BullsAndCows.dto.Game;
import BullsAndCows.dto.GameVM;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BullAndCowsServiceLayer {
    @Autowired
    private AttemptDatabaseDao attemptDao;
    
    @Autowired
    private GameDatabaseDao gameDao;
    
    public List<GameVM> getAllGames() {
        List<Game> games = gameDao.getAllGames();
        List<GameVM> gameVMs = new ArrayList<>();
        
        for (Game g : games) {
            gameVMs.add(convert(g));
        }
        
        return gameVMs;
    }
    
    public List<Attempt> getAllAttempts(int id) {
        List<Attempt> attempts = attemptDao.getAllAttemptsByGameId(id);
        return attempts;
    }
    
    public GameVM getGameById(int id) throws NoSuchGameException {
        try {
            Game game = gameDao.getGameByGameId(id);
            return convert(game);
        } catch (NullPointerException ex) {
            throw new NoSuchGameException();
        }
        
    }
    
    public GameVM addGame() {
        String answer = pickNewAnswer();
        Game game = gameDao.addGame(answer);
        
        return convert(game);
    }
    
    public Attempt addAttempt(Attempt attempt) throws NoSuchGameException {

        try {
            int gameId = attempt.getGameId();
            Game game = gameDao.getGameByGameId(gameId);
            
            String answer = game.getAnswer();
            String score = checkAttempt(answer, attempt.getGuess());
            attempt.setScore(score);
            
            if (score.equals("e:4:p:0")) {
                gameDao.updateGame(attempt.getGameId());
            }

            return attemptDao.addAttempt(attempt);
        
        } catch (NullPointerException ex) {
            throw new NoSuchGameException();
        }

    }     

    private String pickNewAnswer() {
        Random random = new Random(System.currentTimeMillis());
        
        Set<Integer> ans = new HashSet<>();
        
        for(int i = 1; i <= 4; i++) {
            while (ans.size() != i) {
                Integer digit = random.nextInt(10);
                
                ans.add(digit);
            }
        }
        
        String out = "";
        
        for (Integer a : ans) {
            out += a.toString();
        }
        
        return out;
    }
    
    private String checkAttempt(String answer, String guess) {
        
        char[] answerArray = answer.toCharArray();
        char[] guessArray = guess.toCharArray();
        
        int e = 0; // exact matches
        int p = 0; // partial matches
        
        for (int i = 0; i < answerArray.length; i++) {
            char a = answerArray[i];
            String A = Character.toString(a);

            if (a == guessArray[i]) {
                // Exact match
                e++;
            } else if (guess.contains(A)) {
                // Partial match
                p++;
            }
        }

        // Score
        String score = "e:" + e + ":p:" + p;
        
        return score;
    }
    
    private GameVM convert(Game game) {
        String status;
        
        if (game.getIsFinished()) {
            status = "Game complete. Answer = " + game.getAnswer();
        } else {
            status = "Game not finished.";            
        }

        return new GameVM(game.getGameId(), status);
    }
}
