/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.ui;

import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachineView {
    private final UserIO io;
    
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

    public void displayChange(Map<Coin, Integer> change, Candy candy) { 
        io.print("You're change is: ");
        
        for (Coin c : Coin.values()) {
            int numCoin = change.get(c);
            
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

    public void displayCashInventory(Map<Coin, Integer> jingle) {
        for(Coin c : Coin.values()) {
            io.print(jingle.get(c) + " - " + c);
        }
        
        io.readString("Press enter to continue.");

    }

    public Map<Coin, Integer> adminAddedChangeInventory() {
        Map<Coin, Integer> addedJingle = new HashMap<>();
        
        for(Coin c : Coin.values()) {
            int added = io.readInt("How many " + c + " are you adding?");
            addedJingle.put(c, added);
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
        return io.readString("Would you like to add new Candy? (yes/no)");
    }

    public Candy createNewCandy() {
        String name = io.readString("Please enter the name of the candy:");
        String priceString = io.readString("Please enter the price of " + name + ":");
        BigDecimal price = new BigDecimal(priceString);
        int inventory = io.readInt("How mant " + name + " are you adding?");
        
        return new Candy(name, price, inventory);
    }

}
