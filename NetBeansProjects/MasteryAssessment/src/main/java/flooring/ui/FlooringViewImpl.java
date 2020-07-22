/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.ui;

import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlooringViewImpl implements FlooringView {

    UserIO io;
    
    public FlooringViewImpl(UserIO io) {
        this.io = io;
    }

    @Override
    public int displayGetMenu() {
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Export All Data");
        io.print("* 6. Quit");
        io.print("*");
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        
        return io.readInt("Please select one of the above options.", 1, 6);
    }

    @Override
    public LocalDate getOrderDate() {
        return io.readLocalDate("Enter order date:");
    }

    @Override
    public void displayAllOrders(List<Order> allOrders) {
        io.print("Listing all orders:");
        
        if (allOrders == null) {
            io.print("There are no orders from the selected date.");
            return;
        }
        
        for (Order order : allOrders) {
            Order o = order;
            
            io.print(o.getId() + ": " + o.getName() + " $" + o.getTotal().toPlainString());
        }
        
        io.readString("Press enter to continue.");
    }

    @Override
    public String getOrderName() {
        return io.readString("Enter order name:");
    }

    @Override
    public State displayGetStateMenu(Map<String, State> allStates) {
        Set<String> abbreviation = allStates.keySet();
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<State Menu>>");
        
        abbreviation.forEach((s) -> {
            io.print("* " + allStates.get(s).toString());
        });
        
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        
        String selected = io.readString("Please select one of the above states.");

        return allStates.get(selected);
    }

    @Override
    public Product displayGetProductMenu(Map<String, Product> allProducts) {
        Set<String> type = allProducts.keySet();
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("*  <<Product Menu>>");

        type.forEach((s) -> {
            Product p = allProducts.get(s);
            io.print("* " + p.toString());
        });
        io.print("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        
        String selected = io.readString("Please select one of the above products.");
        
        return allProducts.get(selected);
    }

    @Override
    public BigDecimal getArea() {
        return io.readBigDecimal("Enter area in (square feet):");
    }

    @Override
    public String displayGetOrderConfirmation(Order newOrder) {
        io.print("New Order:");
        io.print(newOrder.toString());
        
        return io.readString("Would you like to save this order? (yes/no)");
    }

    @Override
    public void displayAddOrderSuccessBanner(Order newOrder) {
        io.print("The following order was saved successfully.");
        io.print(newOrder.getName());
        io.print("Total Cost: $" + newOrder.getTotal().toPlainString());
        
        io.readString("Press enter to continue.");
    }

    @Override
    public String editName(String orgName) {
        return io.readString("Enter name for the order (" + orgName + "):");
    }

    @Override
    public BigDecimal editArea(BigDecimal orgArea) {
        return io.readBigDecimal("Enter area for the order (" + orgArea + "):");
    }
    
    @Override
    public void displayOriginalInput(String type, String input){
        io.print("Enter new " + type + " (" + input + "):");
    }

    @Override
    public String displayGetEditConfirmation(Order editedOrder) {
        io.print("Edit Order:");
        io.print(editedOrder.toString());
        
        return io.readString("Would you like to save this order? (yes/no)");
    }

    @Override
    public void displayEditOrderSuccessBanner(Order order) {
        io.print("The following order was saved successfully.");
        io.print(order.getName());
        io.print("Total Cost: $" + order.getTotal().toPlainString());
        
        io.readString("Press enter to continue.");
    }

    @Override
    public int findOrderById() {
        return io.readInt("Enter the order ID number:");
    }

    @Override
    public String displayDeletionConfirmation(Order removedOrder) {
        io.print("Delete Order:");
        io.print(removedOrder.toString());
        
        return io.readString("Would you like to delete this order? (yes/no)");
    }

    @Override
    public void displayDeletionOrderSuccessBanner(Order removedOrder) {
        io.print("The following order was deleted successfully.");
        io.print(removedOrder.getName());
        io.print("Total Cost: $" + removedOrder.getTotal().toPlainString());
        
        io.readString("Press enter to continue.");
    }

    @Override
    public void displayError(String error) {
        io.print(error);
    }

    @Override
    public void displayExportingBanner() {
        io.print("Exporting all date...");
        io.print("....");
    }

    @Override
    public void displayExportingSuccess() {
        io.print("All data exported successfully.");
        io.readString("Press enter to continue.");
    }

    @Override
    public void goodBye() {
        io.print("Goodbye!");
    }

    @Override
    public void unknownCommand() {
        io.print("Command not understood.");
    }

    @Override
    public void diplayActionNotCompleted() {
        io.print("Action was not completed.");
        io.readString("Press enter to continue.");
    }

    @Override
    public void noSuchOrder() {
        io.print("There is no such orders in the system.");
        io.readString("Press enter to continue.");
    }

    @Override
    public void displayNoOrdersForDate() {
        io.print("There are not orders for this date in the system.");
        io.readString("Press enter to continue.");
    }
    
}
