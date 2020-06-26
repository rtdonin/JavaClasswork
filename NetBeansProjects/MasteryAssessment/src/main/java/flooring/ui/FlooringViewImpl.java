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

public class FlooringViewImpl implements FlooringView {

    UserIO io;
    
    public FlooringViewImpl(UserIO io) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int displayGetMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getOrderDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getOrderName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayAllOrders(Map<LocalDate, Map<Integer, Order>> allOrders) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String displayGetOrderStateMenu(Map<String, State> allStates) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String displayGetOrderProductMenu(Map<String, Product> allProducts) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getOrderArea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String displayGetOrderConfirmation(Order newOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayAddOrderSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int displayGetEditMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getChange(Edit edit) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String displayGetEditConfirmation(Order editedOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayEditOrderSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String findOrderByDate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int findOrderById() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String displayDeletionConfirmation(Order removedOrder) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayDeletionOrderSuccessBanner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayError(String error) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayExportingBanner() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void displayExportingSuccess() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
