/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised: 06/17/20
*/

package M4.AOP.vendingmachine.ui;

import M4.AOP.vendingmachine.dto.Candy;
import M4.AOP.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// Component
public class VendingMachineView {
    private final UserIO io;
    
    // @Autowired
    public VendingMachineView(UserIO io) {
        this.io = io;
    }

    public String showMenuGetCash(Map<Integer, Candy> availableCandy) {
        io.print("==== Main Menu ====");
        for(int i = 1; i <= availableCandy.size(); i++) {
            Candy current = availableCandy.get(i);
            io.print(i + ") " + current.getName() + " $" + current.getPrice());
        }
        
        return io.readString("Please insert cash or enter EXIT.");
    }

    public int getCandySelection(int size) {
        return io.readInt("Please select one of the above snack options.", 1, size);
    }
    
    public String getCashIn() {
        return io.readString("Please insert cash.");
    }

    public void displayCashInserted(BigDecimal cashInserted) {
        io.print("You've inserted $" + cashInserted);
    }

    public void displayChange(int[] change, Candy candy) { 
        io.print("You're change is: ");
        
        for (Coin c : Coin.values()) {
            int numCoin = change[c.ordinal()];
            
            if (numCoin > 0) {
                io.print(c + " - " + numCoin);

            }
        
        }
        
        io.print("Enjoy your " + candy.getName() + "!");
        io.readString("Please press enter to collect your change.");
    }

    public void displayGoodBye() {
        io.print("Goodbye!");
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

    public String getMoreCashIn() {
        return io.readString("Please insert more cash.");
    }

    public void noChangeEnjoy(Candy candy) {
        io.print("Enjoy your " + candy.getName() + "!");
    }

    public int displayAdminMenu() {
        io.print("==== Administrative Menu ====");
        io.print("1. Check candy inventory");
        io.print("2. Restock Candy");
        io.print("3. Check the cash inventory");
        io.print("4. Restock change");
        io.print("5. Total Sales");
        io.print("6. Exit menu");
        
        return io.readInt("Select one of the above options.");
    }

    public void displayAllCandy(List<Candy> allCandy) {
        allCandy.forEach((current) -> {io.print(current.toString());});
        io.readString("Press enter to continue.");

    }

    public int adminAddedCandyInvetory(Candy addedCandy) {
        return io.readInt("How many " + addedCandy.getName() + " are you adding?");
    }

    public void displayCashInventory(int[] jingle) {
        for(Coin c : Coin.values()) {
            io.print(jingle[c.ordinal()] + " - " + c);
        }
        
        io.readString("Press enter to continue.");

    }

    public int[] adminAddedChangeInventory() {
        int[] addedJingle = new int[4];
        
        for(Coin c : Coin.values()) {
            int added = io.readInt("How many " + c + " are you adding?");
            addedJingle[c.ordinal()] = added;
        }
        return addedJingle;
    }

    public void displayTotalSales(BigDecimal sales) {
        io.print("Total sales are $" + sales.toString());
        io.readString("Press enter to continue.");
    }

    public String getResetSales() {
        return io.readString("If you would like to reset your sales, please enter \"RESET\"."
                + "\nIf not, please enter.");
    }

    public String getAreWeAddingNewCandy() {
        return io.readString("If you would like to add Candy enter \"YES\" or press enter to continue.");
    }

    public Candy createNewCandy() {
        String name = io.readString("Please enter the name of the candy:");
        String priceString = io.readString("Please enter the price of " + name + ":");
        BigDecimal price = new BigDecimal(priceString);
        int inventory = io.readInt("How mant " + name + " are you adding?");
        
        return new Candy(name, price, inventory);
    }

    public void dislpayWasReset() {
        io.print("Total sales are now $0.00");
        io.readString("Please press enter to continue.");
    }

}
