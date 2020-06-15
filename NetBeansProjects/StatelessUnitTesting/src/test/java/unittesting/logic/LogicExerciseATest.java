
package unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.logic.LogicExerciseA.friendlyGreeting;

public class LogicExerciseATest {
    
    public LogicExerciseATest() {
    }

    @Test
    public void friendlyGreetingTestNamedNotFriend() {
        // Arrange
        boolean friend = false;
        String name = "Goofus";
        
        // Act
        String result = friendlyGreeting(name, friend);
        String expResult = "hi";
        
        // Assert
        assertEquals(expResult, result, "You don't know this person!");
    }

    @Test
    public void friendlyGreetingTestNamedFriend() {
        // Arrange
        boolean friend = true;
        String name = "Gallant";
        
        // Act
        String result = friendlyGreeting(name, friend);
        String expResult = "Hello, Gallant!";
        
        // Assert
        assertEquals(expResult, result, "This is your friend!");
    }
    
    @Test
    public void friendlyGreetingTestUnnamedNotFriend() {
        // Arrange
        boolean friend = false;
        String name = null;
        
        // Act
        String result = friendlyGreeting(name, friend);
        String expResult = "...";
        
        // Assert
        assertEquals(expResult, result, "You don't who this person is.");
    }    
}
