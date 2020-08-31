/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package BullsAndCows.dto;

import java.util.Objects;

public class GameVM {
    private int gameId;
    private String status;

    public GameVM(int gameId, String status) {
        this.gameId = gameId;
        this.status = status;
    }
    
    public GameVM() {
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.gameId;
        hash = 41 * hash + Objects.hashCode(this.status);
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
        final GameVM other = (GameVM) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        return true;
    }

}
