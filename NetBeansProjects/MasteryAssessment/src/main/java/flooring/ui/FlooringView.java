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
import java.util.Map;

public interface FlooringView {
    int displayGetMenu();
    String lookUpDateOrders();
    void displayAllOrders(Map<Integer, Order> allOrders);
    String getNewOrderDate();
    String getNewNameDate();
    String displayGetStateMenu(Map<String, State> allStates);
    String displayGetProductMenu(Map<String, Product> allProducts);
    BigDecimal getArea();
    String displayGetOrderConfirmation(Order newOrder);
    void displayAddOrderSuccessBanner();
    Order displayGetEdit(Order order);
    String displayGetEditConfirmation(Order editedOrder);
    void displayEditOrderSuccessBanner();
    String findOrderByDate();
    int findOrderById();
    String displayDeletionConfirmation(Order removedOrder);
    void displayDeletionOrderSuccessBanner();
    void displayError(String error);
    void displayExportingBanner();
    void displayExportingSuccess();
    void goodBye();
}
