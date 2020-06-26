/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.ui;

import flooring.dto.Edit;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import java.time.LocalDate;
import java.util.Map;

public interface FlooringView {
    public int displayGetMenu();
    public String getOrderDate();
    public String getOrderName();
    public void displayAllOrders(Map<LocalDate, Map<Integer, Order>> allOrders);
    public String displayGetOrderStateMenu(Map<String, State> allStates);
    public String displayGetOrderProductMenu(Map<String, Product> allProducts);
    public String getOrderArea();
    public String displayGetOrderConfirmation(Order newOrder);
    public void displayAddOrderSuccessBanner();
    public int displayGetEditMenu();
    public String getChange(Edit edit);
    public String displayGetEditConfirmation(Order editedOrder);
    public void displayEditOrderSuccessBanner();
    public String findOrderByDate();
    public int findOrderById();
    public String displayDeletionConfirmation(Order removedOrder);
    public void displayDeletionOrderSuccessBanner();
    public void displayError(String error);
    public void displayExportingBanner();
    public void displayExportingSuccess();
}
