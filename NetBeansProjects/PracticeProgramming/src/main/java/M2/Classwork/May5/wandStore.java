package M2.Classwork.May5;

import java.util.Scanner;

/**
 * Created: 05/05/20
 */

public class wandStore extends Store{
    Scanner input = new Scanner(System.in);

    public wandStore(String name, String shopkeeper, int capacity) {
        super(name, shopkeeper, capacity);
    }

    public void findWand(){
        boolean wandFound = false;
        
        while (!wandFound){
            System.out.println("Does this wand suit you? (y/n)");
            String answer = input.nextLine();
            
            wandFound = answer.equals("y");
        }
        
        System.out.println("You will be a great wizzard!");
    }
    
}