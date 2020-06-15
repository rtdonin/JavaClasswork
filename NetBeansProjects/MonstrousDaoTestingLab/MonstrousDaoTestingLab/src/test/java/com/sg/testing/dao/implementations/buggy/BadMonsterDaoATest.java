/*
Created by: Margaret DOnin
Date created: 06/02/20
Date revised:
*/
package com.sg.testing.dao.implementations.buggy;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.model.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import static com.sg.testing.model.MonsterType.*;
import static org.junit.jupiter.api.Assertions.*;

public class BadMonsterDaoATest {
    
    public BadMonsterDaoATest() {
    }

    MonsterDao testDao = new BadMonsterDaoA();
    
    @Test
    public void testAddGetMonster() {
        // Create a monster to test
        Integer monsterId = 0001;
        String name = "Fluffy";
        MonsterType type = YETI;
        int peopleEaten = 20;
        String favoriteFood = "popsicle";
        
        Monster myMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        // Add the monster to the DAO
        testDao.addMonster(monsterId, myMonster);
        
        // Get the monster from the DAO
        Monster retrieved = testDao.getMonster(monsterId);
        
        // Check that the data is equal
        assertEquals(myMonster.getName(), retrieved.getName(), "Check the monster name.");
        assertEquals(myMonster.getType(), retrieved.getType(), "Check the monster type.");
        assertEquals(myMonster.getPeopleEaten(), retrieved.getPeopleEaten(), "Check the number of people eaten.");
        assertEquals(myMonster.getFavoriteFood(), retrieved.getFavoriteFood(), "Check the monster's favorite food.");
    }
    
    @Test
    public void testAddGetAllMonster() {
        // Create two monsters to test
        Integer firstMonsterId = 0001;
        String name = "Fluffy";
        MonsterType type = YETI;
        int peopleEaten = 20;
        String favoriteFood = "popsicle";
        
        Monster firstMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        Integer secondMonsterId = 0002;
        name = "Jinx";
        type = VAMPIRE;
        peopleEaten = 10;
        favoriteFood = "not garlic";
        
        Monster secondMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        // Add the monsters to the DAO
        testDao.addMonster(firstMonsterId, firstMonster);
        testDao.addMonster(secondMonsterId, secondMonster);
        
        // Get the monsters List from the DAO
        List <Monster> monsters = testDao.getAllMonsters();
        
        // Check the general contents of the List
        assertNotNull(monsters, "The list should not be null.");
        assertEquals(2, monsters.size(), "There should be two monsters in the list.");
        
        // Chect that our monsters are in the list
        assertTrue(monsters.contains(firstMonster), "List should contain Fluffy.");
        assertTrue(monsters.contains(secondMonster), "List shoult contin Jinx.");
        
        
    }
    
    @Test
    public void testUpdateMonster(){
        // Create a monster to test
        Integer monsterId = 0001;
        String name = "Fluffy";
        MonsterType type = YETI;
        int peopleEaten = 20;
        String favoriteFood = "popsicle";
        
        Monster myMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        // Add monster to the DAO
        testDao.addMonster(monsterId, myMonster);
        
        // create a new monster change the update the monster
        name = "Jinx";
        type = VAMPIRE;
        peopleEaten = 10;
        favoriteFood = "not garlic";
        
        myMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        // update the monster
        testDao.updateMonster(monsterId, myMonster);
        
        // retrieve the monster we change
        Monster retrieved = testDao.getMonster(monsterId);
        
        // compare the monsters
        assertEquals(retrieved, myMonster, "They should be equal.");
        
    }
    
    @Test
    public void testRemoveMonster() {
        // Create two monsters to test
        Integer firstMonsterId = 0001;
        String name = "Fluffy";
        MonsterType type = YETI;
        int peopleEaten = 20;
        String favoriteFood = "popsicle";
        
        Monster firstMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        Integer secondMonsterId = 0002;
        name = "Jinx";
        type = VAMPIRE;
        peopleEaten = 10;
        favoriteFood = "not garlic";
        
        Monster secondMonster = new Monster(name, type, peopleEaten, favoriteFood);
        
        // Add the monsters to the DAO
        testDao.addMonster(firstMonsterId, firstMonster);
        testDao.addMonster(secondMonsterId, secondMonster);
        
        // Remove a monster from the DAO
        Monster removed = testDao.removeMonster(firstMonsterId);
        
        // Check the removedMonster is the one we wanted to remove
        assertEquals(firstMonster, removed);

        // Get List of Monsters back
        List<Monster> monsters = testDao.getAllMonsters();

        // Check the general contents of the List
        assertNotNull(monsters, "The list should not be null.");
        assertEquals(1, monsters.size(), "There should be one monster in the list.");
        
        // Check that what monsters are in the list
        assertFalse(monsters.contains(firstMonster), "List should not contain Fluffy.");
        assertTrue(monsters.contains(secondMonster), "List should contin Jinx.");

        // Remove the second monster
        testDao.removeMonster(secondMonsterId);

        // Get the list again
        monsters = testDao.getAllMonsters();

        // List should be empty
        assertTrue(monsters.isEmpty(), "Our list should be empty.");

        // Try to get the monsters we removed
        removed = testDao.getMonster(firstMonsterId);
        assertNull(removed, "Fluffy should have been removed.");
        
        removed = testDao.getMonster(secondMonsterId);
        assertNull(removed, "Jinx should have been removed.");
    }
    
}
