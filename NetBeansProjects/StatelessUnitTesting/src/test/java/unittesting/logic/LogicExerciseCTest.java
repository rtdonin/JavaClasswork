package unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.logic.LogicExerciseC.goWalky;

public class LogicExerciseCTest {
    
    public LogicExerciseCTest() {
    }

    @Test
    public void goWalkyDarkNoFlashlightRainingUmbrella75Test() {
        // Arrange
        boolean isDark = true;
        boolean hasFlashlight = false;
        boolean raining = true;
        boolean hasUmbrella = true;
        int temperature = 75;
        
        // Act
        boolean result = goWalky(isDark, hasFlashlight, raining, hasUmbrella, temperature);
        
        // Assert
        
        assertFalse(result, "Should be going for a walk!");
    }
    
    @Test
    public void goWalkyNotDarkFlashlightNotRainingNoUmbrella50Test() {
        // Arrange
        boolean isDark = false;
        boolean hasFlashlight = true;
        boolean raining = false;
        boolean hasUmbrella = false;
        int temperature = 50;
        
        // Act
        boolean result = goWalky(isDark, hasFlashlight, raining, hasUmbrella, temperature);
        
        // Assert
        
        assertTrue(result, "Should be going for a walk!");
    }
    
    @Test
    public void goWalkyNotDarkNoFlashlightNotRainingNoUmbrella30Test() {
        // Arrange
        boolean isDark = false;
        boolean hasFlashlight = false;
        boolean raining = false;
        boolean hasUmbrella = false;
        int temperature = 30;
        
        // Act
        boolean result = goWalky(isDark, hasFlashlight, raining, hasUmbrella, temperature);
        
        // Assert
        
        assertFalse(result, "Should NOT be going for a walk!");
    }

    
}
