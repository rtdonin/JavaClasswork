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
import flooring.service.InvalidProductException;
import flooring.service.InvalidStateException;
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
        
        List<Order> allOrders = service.getDateOrders(date);
        view.displayAllOrders(allOrders);
    }
    
    private void addOrder() throws FlooringPersistenceException {
        int id = service.getNewId();
        Order order = new Order(id);
        
        String name = null;
        LocalDate date = null;
        BigDecimal area = null;
        Product product = null;
        State state = null;
        
        Map<String, Product> products = service.getAllProducts();
        Map<String, State> states = service.getAllStates();
        
        boolean hasError = true;
        
            do{
                try{
                    order.setDate(date);
                    order.setName(name);
                    order.setArea(area);
                    order.setProduct(product);
                    order.setState(state);
                    
                    service.validateOrder(order);
                    hasError = false;
                    
                } catch (InvalidNameException e) {
                    name = view.getOrderName();
                } catch (InvalidDateException e) {
                    date = view.getOrderDate();
                } catch (InvalidAreaException e ){
                    area = view.getArea();
                } catch (InvalidProductException e) {
                    product = view.displayGetProductMenu(products);
                } catch (InvalidStateException e) {
                    state = view.displayGetStateMenu(states);
                }
                
            } while (hasError);

        boolean keepGoing = true;
        
        while (keepGoing){
            String confirm = view.displayGetOrderConfirmation(order);
            boolean saidYes;

            try {
                saidYes = service.compConfirmation(confirm);
                if(saidYes) {
                    service.addOrder(order);
                    view.displayAddOrderSuccessBanner(order);
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
        Order selected;
        
        try {
            selected = service.getOrder(date, id);
        } catch (FlooringPersistenceException ex) {
            view.displayNoOrdersForDate();
            return;
        }

        
        if (selected == null) {
            view.noSuchOrder();
            return;
        } 
        
        // get the edits
        
        String name = view.editName(selected.getName());
        
        String originalProduct = selected.getProduct().getProductType();
        view.displayOriginalInput("product", originalProduct);
        Map<String, Product> products = service.getAllProducts();
        Product product = view.displayGetProductMenu(products);
        
        Map<String, State> states = service.getAllStates();
        String originalStateAbbreviation = selected.getState().getStateAbbreviation();
        String originalStateName = states.get(originalStateAbbreviation).getStateName();
        view.displayOriginalInput("state", originalStateName);
        State state = view.displayGetStateMenu(states);
        
        BigDecimal area = view.editArea(selected.getArea());

        // create the edited order
        
        Order edit = new Order(selected.getId());
        boolean hasError = true;

        do {
            try {
                
                // put in the values for the edited order.
        
                edit.setName(name);
                edit.setProduct(product);
                edit.setState(state);
                edit.setArea(area);

                // validate and redo cost and tax calculations
                service.checkNewOrder(selected, edit);
                hasError = false;
                
                // if the validation errors happen - get a new value.
            } catch (InvalidAreaException ex) {
                area = view.editArea(selected.getArea());
            } catch (InvalidNameException ex) {
                name = view.editName(selected.getName());
            } catch (InvalidStateException ex) {
                view.displayOriginalInput("state", originalStateName);
                state = view.displayGetStateMenu(states);
            } catch (InvalidProductException ex) {
                view.displayOriginalInput("product", originalProduct);
                product = view.displayGetProductMenu(products);
            } catch (InvalidDateException ex) {
                // should never happen.
                // This property is already checked for when the order was added

                view.displayError("Date exception thrown in editOrder method.");
                view.diplayActionNotCompleted();
                return;
            }
        } while (hasError);
            
        boolean keepGoing = true;

        while (keepGoing){
            String confirm = view.displayGetEditConfirmation(edit);
            boolean saidYes;

            try {
                saidYes = service.compConfirmation(confirm);
                if(saidYes) {
                    service.editOrder(edit);
                    view.displayEditOrderSuccessBanner(edit);
                } else if (!saidYes) {
                    view.diplayActionNotCompleted();
                }
                keepGoing = false;
            } catch(NotYesOrNoException e) {
                view.displayError(e.getMessage());
            }
        }
    }
    
    private void removeOrder() throws FlooringPersistenceException {
        LocalDate date = null;
        
        while (date == null) {
            date = view.getOrderDate();
        }
        
        Integer id = view.findOrderById();
        Order selected;
        
        try {
            selected = service.getOrder(date, id);
        } catch (FlooringPersistenceException ex) {
            view.displayNoOrdersForDate();
            return;
        }

        if (selected == null) {
            view.noSuchOrder();
            return;
        }

        boolean keepGoing = true;

        while (keepGoing){
            String confirm = view.displayDeletionConfirmation(selected);
            boolean saidYes;

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
    
    private void export() throws FlooringPersistenceException {
        view.displayExportingBanner();
        service.export();
        view.displayExportingSuccess();
    }
}