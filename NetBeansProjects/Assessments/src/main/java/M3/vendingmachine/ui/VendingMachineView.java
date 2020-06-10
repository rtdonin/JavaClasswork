/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M3.vendingmachine.ui;

import M3.vendingmachine.dto.Candy;
import M3.vendingmachine.dto.Coin;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        return io.readInt("Please select one of the above options", 1, size);
    }
    
    public String getCashIn() {
        return io.readString("Please insert cash.");
    }

    public void displayCashInserted(BigDecimal cashInserted) {
        io.print("You've inserted $" + cashInserted);
    }

    public void displayChange(List<BigDecimal> change, Candy candy) { 
        io.print("You're change is: ");
        int i = 0;
        for (Coin c : Coin.values()) {
            io.print(c + " - " + change.indexOf(i));
            i++;
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

}
