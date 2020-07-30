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

public interface FlooringView {
    int displayGetMenu();
    LocalDate getOrderDate();
    void displayAllOrders(List<Order> allOrders);
    String getOrderName();
    State displayGetStateMenu(Map<String, State> allStates);
    Product displayGetProductMenu(Map<String, Product> allProducts);
    BigDecimal getArea();
    String displayGetOrderConfirmation(Order newOrder);
    void displayAddOrderSuccessBanner(Order newOrder);
    String editName(String orgName);
    BigDecimal editArea(BigDecimal orgArea);
    void displayOriginalInput(String type, String input);
    String displayGetEditConfirmation(Order editedOrder);
    void displayEditOrderSuccessBanner(Order order);
    int findOrderById();
    String displayDeletionConfirmation(Order removedOrder);
    void displayDeletionOrderSuccessBanner(Order removedOrder);
    void displayError(String error);
    void displayExportingBanner();
    void displayExportingSuccess();
    void goodBye();
    void unknownCommand();
    void diplayActionNotCompleted();
    void noSuchOrder();
    void displayNoOrdersForDate();
}
