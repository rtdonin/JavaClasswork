/*
Created by: Margaret Donin
Date created: 08/20/20
Date revised:
*/

package BullsAndCows.controller;

import BullsAndCows.dto.Attempt;
import BullsAndCows.dto.GameVM;
import BullsAndCows.service.BullAndCowsServiceLayer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bullsandcows")
public class BullsAndCowsController {
    @Autowired
    BullAndCowsServiceLayer service;
    
    @GetMapping("/game")
    public ResponseEntity<List<GameVM>> allGames () {
        List<GameVM> games = service.getAllGames();
        return new ResponseEntity(games, HttpStatus.FOUND);
    }
    
    @GetMapping("/rounds/{id}")
    public ResponseEntity<List<Attempt>> allAttemps(@PathVariable int id) {
        List<Attempt> attempts = service.getAllAttempts(id);
        
        if (attempts.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(attempts);
        }
    }
    
    @GetMapping("/game/{id}")
    public ResponseEntity<GameVM> findById(@PathVariable int id) {
        try {
            GameVM game = service.getGameById(id);
            return new ResponseEntity(game, HttpStatus.FOUND);
        } catch (NoSuchGameException ex) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)    
    public GameVM createGame() {
        return service.addGame();
    }
    
    @PostMapping("/guess")
    public ResponseEntity<Attempt> createAttempt(@RequestBody Attempt attempt) {
        try{
            Attempt createdAttempt = service.addAttempt(attempt);
            return new ResponseEntity(createdAttempt, HttpStatus.CREATED);
        } catch(NoSuchGameException ex) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
}
