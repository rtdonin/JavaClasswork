/**
 * Created: 05/05/20
 */

package M2.Classwork.May5;

import java.util.ArrayList;
import java.util.List;

public class WandStore extends Store {
    public List<Wand> wandInventory= new ArrayList<>();
    private static final String DELIMITER = "::";

    public WandStore(String name, String shopkeeper, int capacity) {
        super(name, shopkeeper, capacity);
    }

    public void findWand() {
        boolean wandFound = false;

        while (!wandFound) {
            System.out.println("Does this wand suit you? (y/n)");
            String answer = input.nextLine();

            wandFound = answer.equals("y");
        }

        System.out.println("You will be a great wizzard!");
    }

    public void wandHistory() {
        System.out.println("Harry Potter's wand was 11\" long, made of holly, and possessed a phoenix feather core. This was described by Garrick Ollivander to be an unusual combination of wand core and wood. The feather was donated by Fawkes, Albus Dumbledore's phoenix. It was revealed by Garrick Ollivander that Tom Riddle's wand core also came from Fawkes, making the two wands \"brothers\". Harry\'s wand was described as being \"nice and supple");
    }
    
    public static String marshallWands(Wand myWand) {
        String wandString = "";
        
        wandString += InventoryMapper.marshallInventory(new Item(myWand.name, myWand.price, myWand.quantity)) + DELIMITER;
        wandString += myWand.getWoodType() + DELIMITER;
        wandString += myWand.getCore();

        return wandString;
    }
    
    public void setWandInventory(String name, Double price, Integer quantity, String woodType, String core){
        this.wandInventory.add(new Wand(name, price, quantity, woodType, core));
    }

    public Wand getWand(int i) {
        return wandInventory.get(i);
    }

    public List<Wand> getWandInventory() {
        return wandInventory;
    }
    
}