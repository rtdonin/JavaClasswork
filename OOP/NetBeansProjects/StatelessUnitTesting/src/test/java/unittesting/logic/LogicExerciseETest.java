/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittesting.logic;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static unittesting.logic.LogicExerciseE.whatColor;

/**
 *
 * @author rtdon
 */
public class LogicExerciseETest {
    
    public LogicExerciseETest() {
    }

    @Test
    public void whatColorYellowTest() {
        // Arrange
        int waveLengthNM = 575;
        int frequencyTHZ = 510;
        double photonicEnergyEV = 2.15;
        String expResult = "Yellow";
        
        // Act
        String result = whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        
        // Assert
        
        assertEquals(expResult, result, "Should be " + result + "!");        
    }
    
    @Test
    public void whatColorVioletTest() {
        // Arrange
        int waveLengthNM = 449;
        int frequencyTHZ = 670;
        double photonicEnergyEV = 3.00;
        String expResult = "Violet";
        
        // Act
        String result = whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        
        // Assert
        
        assertEquals(expResult, result, "Should be " + result + "!");        
    }

    @Test
    public void whatColorUnknownTest() {
        // Arrange
        int waveLengthNM = 621;
        int frequencyTHZ = 475;
        double photonicEnergyEV = 16.5;
        String expResult = "Unknown";
        
        // Act
        String result = whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        
        // Assert
        
        assertEquals(expResult, result, "Should be " + result + "!");        
    }
    
    @Test
    public void whatColorOrangeTest() {
        // Arrange
        int waveLengthNM = 590;
        int frequencyTHZ = 508;
        double photonicEnergyEV = 2.05;
        String expResult = "Orange";
        
        // Act
        String result = whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        
        // Assert
        
        assertEquals(expResult, result, "Should be " + result + "!");        
    }
    
    @Test
    public void whatColorYellowGreenTest() {
        // Arrange
        int waveLengthNM = 570;
        int frequencyTHZ = 526;
        double photonicEnergyEV = 2.17;
        String expResult = "Yellow-Green";
        
        // Act
        String result = whatColor(waveLengthNM, frequencyTHZ, photonicEnergyEV);
        
        // Assert
        
        assertEquals(expResult, result, "Should be " + result + "!");        
    }
    
}
