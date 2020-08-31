/*
Created by: Margaret Donin
Date created: 08/20/20
Date revised:
*/

package BullsAndCows.dto;

import java.sql.Time;
import java.util.Objects;

public class Attempt {
    private int attemptId;
    private int gameId;
    private String guess;
    private String score;
    private Time timestamp;

    public Attempt() {
    }
    
    public Attempt(int gameId, String guess) {
        this.gameId = gameId;
        this.guess = guess;
    }
    
    public int getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(int attemptId) {
        this.attemptId = attemptId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Time getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Time timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.attemptId;
        hash = 17 * hash + this.gameId;
        hash = 17 * hash + Objects.hashCode(this.guess);
        hash = 17 * hash + Objects.hashCode(this.score);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attempt other = (Attempt) obj;
        if (this.attemptId != other.attemptId) {
            return false;
        }
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.guess, other.guess)) {
            return false;
        }
        if (!Objects.equals(this.score, other.score)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "AttemptId - " + attemptId + " , gameId - " + gameId
                + " , guess - " + guess + " , score - " + score + " , timestamp - " + timestamp + '}';
    }
    
    
}
