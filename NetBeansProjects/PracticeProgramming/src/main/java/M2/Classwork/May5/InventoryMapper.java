/**
Created 05/05/20
*/

package M2.Classwork.May5;

public class InventoryMapper{
    private static final String DELIMITER = "::";
    
    public static String marshallInventory(Item item){
        String itemString = "";
        
        itemString += item.getName() + DELIMITER;
        itemString += Double.toString(item.getPrice()) + DELIMITER;
        itemString += Integer.toString(item.getQuantity());
        
        return itemString;
    }
}