/**
 * Created: 05/05/20
 */

package M2.Classwork.May5;

//import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store implements StoreInterface {
    public Scanner input = new Scanner(System.in);
    public String name;
    public String shopkeeper;
    public int capacity;
    //Map<String, Double, Integer> inventory = new HashMap<>();
    
    List<Item> inventory= new ArrayList<>();
    
    @Override
    public void sell(){
        System.out.print("Would you like to buy this? (y/n)");
        String answer = input.nextLine();
        
        if (answer.equals("y")){
            System.out.println("Thank you for your business!");
        } else{
            System.out.println("Ok, Good bye.");
        }
    }
    
    @Override
    public void enter(){
        System.out.println("Welcome, to " + name + "!");
    }
    
    @Override
    public void exit(){
        System.out.println("Thank you for dropping in!");
    }
    
    public Store(String name, String shopkeeper, int capacity){
        this.name = name;
        this.shopkeeper = shopkeeper;
        this.capacity = capacity;
    }

    public String getShopkeeper() {
        return shopkeeper;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setInventory(String name, Double price, Integer quantity){
        this.inventory.add(new Item(name, price, quantity));
    }
    
    public Item getInventory(int i){
        return inventory.get(i);
    }
    
    
}