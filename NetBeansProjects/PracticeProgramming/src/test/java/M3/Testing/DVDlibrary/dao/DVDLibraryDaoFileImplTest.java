/*
Created by: Margaret Donin
Date created: 05/31/20
Date revised:
*/

package M3.Testing.DVDlibrary.dao;

import M3.Testing.DVDlibrary.dto.DVD;
import java.io.FileWriter;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DVDLibraryDaoFileImplTest {
    DVDLibraryDao testDao;
    
    public DVDLibraryDaoFileImplTest() {
    }
    
    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testlibrary.txt";
        // Uses the FileWrite to quickly blank the file
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }
    
    @Test
    public void testAddGetDVD() throws Exception{
        // Create our method test inputs.
        String title = "Finding Nemo";
        DVD dvd = new DVD(title);
        dvd.setReleaseDate("2003");
        dvd.setMPAARating("G");
        dvd.setDirector("Andrew Stanton");
        dvd.setStudio("Walt Disney Picture, Pixar Animation Studios");
        dvd.setUserRating("fish are friends not food");
        
        // Add the DVD to the DAO
        testDao.addDVD(title, dvd);
        
        // Get the DVD from the DAO
        DVD retrievedDVD = testDao.getDVD(title);
        
        // Check the data is equal
        assertEquals(dvd.getTitle(), retrievedDVD.getTitle());
        assertEquals(dvd.getReleaseDate(), retrievedDVD.getReleaseDate());
        assertEquals(dvd.getMPAARating(), retrievedDVD.getMPAARating());
        assertEquals(dvd.getDirector(), retrievedDVD.getDirector());
        assertEquals(dvd.getStudio(), retrievedDVD.getStudio());
        assertEquals(dvd.getUserRating(), retrievedDVD.getUserRating());
    }
    
    @Test
    public void testAddGetAllStudents() throws Exception {
        // Create our first DVD
        DVD firstDVD = new DVD("Finding Nemo");
        firstDVD.setReleaseDate("2003");
        firstDVD.setMPAARating("G");
        firstDVD.setDirector("Andrew Stanton");
        firstDVD.setStudio("Walt Disney Picture, Pixar Animation Studios");
        firstDVD.setUserRating("fish are friends not food");
        
        // Create our second DVD
        DVD secondDVD = new DVD("Finding Dory");
        secondDVD.setReleaseDate("2016");
        secondDVD.setMPAARating("PG");
        secondDVD.setDirector("Andrew Stanton");
        secondDVD.setStudio("Walt Disney Picture, Pixar Animation Studios");
        secondDVD.setUserRating("I can speak whale");
        
        // Add the DVD to the DAO
        testDao.addDVD(firstDVD.getTitle(), firstDVD);
        testDao.addDVD(secondDVD.getTitle(), secondDVD);
    
        // Retrieve the list of all DVD's within the DAO
        List<DVD> allDVDs = testDao.getAllDVDs();
        
        // First check the general contents of the list
        assertNotNull(allDVDs, "The list of DVD's must not be null.");
        assertEquals(2, allDVDs.size(), "List of DVD's should have 2 DVD's.");
        
        // The specifics
        assertTrue(testDao.getAllDVDs().contains(firstDVD), "The list of students should include \"Finding Nemo\".");
        assertTrue(testDao.getAllDVDs().contains(secondDVD), "The list of students should include \"Finding Dory\".");
    }

    @Test
    public void testRemoveDVD() throws Exception {
        // Create two new DVDs
        String firstTitle = "Finding Nemo";
        DVD firstDVD = new DVD(firstTitle);
        firstDVD.setReleaseDate("2003");
        firstDVD.setMPAARating("G");
        firstDVD.setDirector("Andrew Stanton");
        firstDVD.setStudio("Walt Disney Picture, Pixar Animation Studios");
        firstDVD.setUserRating("fish are friends not food");
        
        String secondTitle = "Finding Dory";
        DVD secondDVD = new DVD(secondTitle);
        secondDVD.setReleaseDate("2016");
        secondDVD.setMPAARating("PG");
        secondDVD.setDirector("Andrew Stanton");
        secondDVD.setStudio("Walt Disney Picture, Pixar Animation Studios");
        secondDVD.setUserRating("I can speak whale");
        
        // Add the DVD to the DAO
        testDao.addDVD(firstTitle, firstDVD);
        testDao.addDVD(secondTitle, secondDVD);
        
        // remove the first student - Finding Nemo
        DVD removedDVD = testDao.removeDVD(firstDVD.getTitle());
        
        // Check that the correct object was removed.
        assertEquals(removedDVD, firstDVD, "The removed DVD should be \"Find Nemo\".");
        
        // Get all the DVDs
        List<DVD> allDVDs = testDao.getAllDVDs();
        
        // First check the general contents of the list
        assertNotNull(allDVDs, "All DVD list should be not null.");
        assertEquals(1, allDVDs.size(), "All DVDs should only have 1 dvd.");
        
        // Then the specifics
        assertFalse(allDVDs.contains(firstDVD), "All students should NOT include \"Finding Nemo\".");
        assertTrue(allDVDs.contains(secondDVD), "All students should include \"Finding Dory\".");
        
        // Remove the second DVD
        removedDVD = testDao.removeDVD(secondDVD.getTitle());
        
        // Check that the correct object was removed.
        assertEquals(removedDVD, secondDVD, "The removed DVD should be \"Finding Dory\".");
        
        // retrieve all the DVDs again, and check the list.
        allDVDs = testDao.getAllDVDs();
        
        // Check the contents of the list - it should be empty
        assertTrue(allDVDs.isEmpty(), "The retrieved list of the DVDs should be empty.");
        
        // Try to 'get' both DVDs by thier name - they should be null!
        DVD retrievedDVD = testDao.getDVD(firstDVD.getTitle());
        assertNull(retrievedDVD, "\"Finding Nemo\" was removed, should be null.");
        
        retrievedDVD = testDao.getDVD(secondDVD.getTitle());
        assertNull(retrievedDVD, "\"Finding Dory\" was removed, should be null.");
    }
}
