 /*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.controller;

import flooring.service.NotYesOrNoException;
import flooring.dao.FlooringPersistenceException;
import flooring.dto.MainMenuChoices;
import flooring.dto.Order;
import flooring.dto.Product;
import flooring.dto.State;
import flooring.service.FlooringServiceLayer;
import flooring.service.InvalidAreaException;
import flooring.service.InvalidDateException;
import flooring.service.InvalidNameException;
import flooring.ui.FlooringView;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class FlooringController {
    FlooringView view;
    FlooringServiceLayer service;

    public FlooringController(FlooringView view, FlooringServiceLayer service) {
        this.view = view;
        this.service = service;
    }
    
    public void run() {
        boolean keepGoing = true;
        MainMenuChoices[] choice = MainMenuChoices.values();
        
        try {
            while (keepGoing) {
                int menuSelection = view.displayGetMenu() - 1;

                switch (choice[menuSelection]) {
                    case GET_ALL_FROM_DATE:
                        getAllOrders();
                        break;
                    case ADD_ORDER:
                        addOrder();
                        break;
                    case EDIT_ORDER:
                        editOrder();
                        break;
                    case REMOVE_ORDER:
                        removeOrder();
                        break;
                    case EXPORT:
                        // aka backup
                        export();
                        break;
                    case QUIT:
                        keepGoing = false;
                        break;
                    default:
                        view.displayError("Something went wrong in main menu.");
                }
            }
        } catch (FlooringPersistenceException e) {
            view.displayError("Main menu error. Reading and writing from a file.");
        }
        
        view.goodBye();
    }
    
    private void getAllOrders() {
        
        LocalDate date = null;
        
        while (date == null) {
            date = view.getOrderDate();
        }
        
        try {
            List<Order> allOrders = service.getDateOrders(date);
            view.displayAllOrders(allOrders);
        } catch (FlooringPersistenceException e){
            view.displayNoOrdersForDate();
        }
    }
    
    private void addOrder() throws FlooringPersistenceException {
        int id = service.getNewId();
        Order order = new Order(id);
        
        LocalDate date = null;
        
        while (date == null) {
            date = view.getOrderDate();
        }
        
        String name = view.getOrderName();
        
        Map<String, Product> products = service.getAllProducts();
        Product product = view.displayGetProductMenu(products);
        order.setProduct(product);
        
        Map<String, State> states = service.getAllStates();
        State state = view.displayGetStateMenu(states);
        order.setState(state);
        
        BigDecimal area = view.getArea();
        
        Order costTaxOrder = null;
        boolean hasError = true;
        
            do{
                try{
                    order.setDate(date);
                    order.setName(name);
                    order.setArea(area);

                    costTaxOrder = service.validateOrder(order);
                    hasError = false;
                    
                } catch (InvalidNameException e) {
                    name = view.getOrderName();
                } catch (InvalidAreaException e ){
                    area = view.getArea();
                } catch (InvalidDateException e) {
                    date = view.getOrderDate();
                }
            } while (hasError);
        
        String confirm = view.displayGetOrderConfirmation(costTaxOrder);
        
        boolean keepGoing = true;
        boolean saidYes;
        
        while (keepGoing){
            try {
                saidYes = service.compConfirmation(confirm);
                if(saidYes) {
                    service.addOrder(costTaxOrder);
                    view.displayAddOrderSuccessBanner(costTaxOrder);
                } else if (!saidYes) {
                    view.diplayActionNotCompleted();
                }
                keepGoing = false;
            } catch(NotYesOrNoException e) {
                view.displayError(e.getMessage());
            }
        }
       
    }
    
    private void editOrder() throws FlooringPersistenceException {
        LocalDate date = null;
        
        while (date == null) {
            date = view.getOrderDate();
        }
        
        Integer id = view.findOrderById();
        Order selected = service.getOrder(date, id);
        
        if (selected == null) {
            
            view.noSuchOrder();
            
        } else {
        
            String name = view.editName(selected.getName());
            view.displayOriginalInput("product", selected.getProduct().getProductType());
            Map<String, Product> products = service.getAllProducts();
            Product product = view.displayGetProductMenu(products);
            view.displayOriginalInput("state", selected.getState().getStateName());
            Map<String, State> states = service.getAllStates();
            State state = view.displayGetStateMenu(states);
            BigDecimal area = view.editArea(selected.getArea());

            Order finalOrder = null;
            boolean hasError = true;

            do {
                try {
                    Order edit = new Order(selected.getId());
                    edit.setName(name);
                    edit.setProduct(product);
                    edit.setState(state);
                    edit.setArea(area);

                    finalOrder = service.checkNewOrder(selected, edit);
                    hasError = false;
                } catch (InvalidAreaException ex) {
                    area = view.editArea(selected.getArea());
                } catch (InvalidNameException ex) {
                    name = view.editName(selected.getName());
                } catch (InvalidDateException ex) {
                    // should never happen.
                    // This property is already checked for when the order was added

                    view.displayError("Date exception thrown in editOrder method.");
                }
            } while (hasError);

            String confirm = view.displayGetEditConfirmation(finalOrder);

            boolean keepGoing = true;
            boolean saidYes;

            while (keepGoing){
                try {
                    saidYes = service.compConfirmation(confirm);
                    if(saidYes) {
                        service.editOrder(finalOrder);
                        view.displayEditOrderSuccessBanner(finalOrder);
                    } else if (!saidYes) {
                        view.diplayActionNotCompleted();
                    }
                    keepGoing = false;
                } catch(NotYesOrNoException e) {
                    view.displayError(e.getMessage());
                }
            }
        }
    }
    
    private void removeOrder() throws FlooringPersistenceException {
        LocalDate date = null;
        
        while (date == null) {
            date = view.getOrderDate();
        }
        
        Integer id = view.findOrderById();
        Order selected = service.getOrder(date, id);
        
        if (selected == null) {
            
            view.noSuchOrder();
            
        } else {
        
            String confirm = view.displayDeletionConfirmation(selected);

            boolean keepGoing = true;
            boolean saidYes;

            while (keepGoing){
                try {
                    saidYes = service.compConfirmation(confirm);
                    if(saidYes) {
                        service.removeOrder(selected);
                        view.displayDeletionOrderSuccessBanner(selected);
                    } else if (!saidYes) {
                        view.diplayActionNotCompleted();
                    }
                    keepGoing = false;
                } catch(NotYesOrNoException e) {
                    view.displayError(e.getMessage());
                }
            }
        }
    }
    
    private void export() throws FlooringPersistenceException {
        view.displayExportingBanner();
        service.export();
        view.displayExportingSuccess();
    }
}