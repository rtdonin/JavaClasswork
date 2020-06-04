/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Controller;

import M3.BigDecimal.CarLot.Dto.Car;
import M3.BigDecimal.CarLot.Dto.CarKey;
import M3.BigDecimal.CarLot.Service.*;
import M3.BigDecimal.CarLot.Ui.CarLotView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CarLotController {
    private CarLotServiceImpl service;
    private CarLotView view;
    
    public CarLotController(CarLotView view, CarLotServiceImpl service) {
        this.service = service;
        this.view = view;
    }
    
    
    public void run() throws NoSuchCarException{
        boolean keepGoing = true;
        
        try {
            while(keepGoing){
                int choice = view.displayGetMenuSelection();

                switch(choice) {
                    case 1: viewCar();
                        break;
                    case 2: getAllCars();
                        break;
                    case 3: discountCar();
                        break;
                    case 4: sellCar();
                        break;
                    case 5: keepGoing = false;
                        break;
                    default: unknownCommand();
                }
            }
        } catch(NoSuchCarException | OverpaidPriceException | UnderpaidPriceException e) {
            view.displayErrorMessage(e.getMessage());
        }
        view.displayGoodBye();
    }
    
    private void viewCar() throws NoSuchCarException{
        view.displaydisplayCarBanner();
        String VIN = view.getACarVIN();
        Car car = service.getACar(VIN);
        view.displayCar(car);
    }
    
    private void getAllCars() throws NoSuchCarException {
        int choice = view.displayGetAllCarsMenu();
        List<Car> cars = new ArrayList<>();
        
        switch(choice){
            case 1: cars = service.getAllCars();
                break;
            case 2: cars = getCarsByColor();
                break;
            case 3: cars = getCarsInBudget();
                break;
            case 4: cars = getCarsByMakeAndModel();
                break;
            default: unknownCommand();
        }
        
        view.displayListOfCars(cars);
    }

    private void discountCar() throws NoSuchCarException {
        view.displayDiscountCarBanner();
        String VIN = view.getACarVIN();
        BigDecimal percentDiscount = view.getPercentDiscount();
        BigDecimal finalPrice = service.discountCar(VIN, percentDiscount);
        view.displayFinalPrice(finalPrice);
    }
    
    private void sellCar() throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        view.displaySellCarBanner();
        String VIN = view.getACarVIN();
        BigDecimal cashPaid = view.getCashPaid();
        CarKey key = service.sellCar(VIN, cashPaid);
        view.displayCarSale(key);
    }
    
    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private List getCarsByColor() throws NoSuchCarException {
        String color = view.getColor();
        return service.getCarsByColor(color);
    }

    private List getCarsInBudget() throws NoSuchCarException {
        BigDecimal maxPrice= view.getBudget();
        return service.getCarsInBudget(maxPrice);
    }

    private List getCarsByMakeAndModel() throws NoSuchCarException {
        String make = view.getCarMake();
        String model = view.getCarModel();
        
        return service.getCarByMakeAndModel(make, model);
    }
}