/**
Created 05/05/20
*/

package M2.Classwork.May5;

public class InventoryMapper{
    private static final String DELIMITER = "::";
    
    public static String marshallInventory(Inventory item){
        String itemString = "";
        
        itemString += item.name + DELIMITER;
        itemString += item.detail + DELIMITER;
        itemString += Double.toString(item.getPrice());
        
        return itemString;
    }
}