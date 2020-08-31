/*
Created by: Margaret Donin
Date created: 08/20/20
Date revised:
*/

package BullsAndCows.dto;

import java.util.Objects;

public class Game {
    private int gameId;
    private String answer;
    private boolean isFinished;

    public Game(int gameId, String answer, boolean isFinished) {
        this.gameId = gameId;
        this.answer = answer;
        this.isFinished = isFinished;
    }
    
    public Game() {
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean isFinished) {
        this.isFinished = isFinished;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.gameId;
        hash = 89 * hash + Objects.hashCode(this.answer);
        hash = 89 * hash + (this.isFinished ? 1 : 0);
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
        final Game other = (Game) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.isFinished != other.isFinished) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", answer=" + answer + ", isFinished=" + isFinished + '}';
    }
    
}
