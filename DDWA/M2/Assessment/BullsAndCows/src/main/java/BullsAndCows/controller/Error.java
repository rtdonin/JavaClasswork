/*
Created by: Margaret Donin
Date created: 08/30/20
Date revised:
*/

package BullsAndCows.controller;

import java.time.LocalDateTime;

public class Error {
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
