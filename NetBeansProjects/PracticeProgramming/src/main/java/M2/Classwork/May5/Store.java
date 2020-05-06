/**
 * Created: 05/05/20
 */

package M2.Classwork.May5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Store implements StoreInterface{
    Scanner input = new Scanner(System.in);
    public String name;
    public String shopkeeper;
    public int capacity;
    public Map<String, String, Double> items = new HashMap<>();
    
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

    public void setItems(String object, String detail, double price){
        this.items.put(object, detail, price);
    }
    
    public Double getItem(String key){
        return items.get(key);
    }
    
    
}