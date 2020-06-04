/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.BigDecimal.CarLot.Ui;

import M2.Summary.classroster.ui.UserIOConsoleImpl;
import M3.BigDecimal.CarLot.Dto.Car;
import M3.BigDecimal.CarLot.Dto.CarKey;
import java.math.BigDecimal;
import java.util.List;

public class CarLotView {
    UserIOConsoleImpl io;
    
    public CarLotView(UserIOConsoleImpl io) {
        this.io = io;
    }
    
    public int displayGetMenuSelection() {
        io.print("Main Menu");
        io.print("1. View a Car");
        io.print("2. Get all Cars");
        io.print("3. Discount a Car");
        io.print("4. Sell a Car");
        io.print("5. Exit");
        
        return io.readInt("Please select from the above choices.", 1, 5);
    }

    public void displaydisplayCarBanner() {
        io.print("VIEW A CAR");
    }

    public String getACarVIN() {
        String VIN = io.readString("What is the car VIN?");
        return VIN.toUpperCase();
    }

    public void displayCar(Car car) {
        io.print(car.getColor() + " " + car.getMake() + " " + car.getModel());
        io.print(car.getOdometerMiles() + " miles");
        io.print("$" + car.getPrice().toPlainString());
        
        String isLaserCut = car.getKey().isLaserCut() ? "" : "not";
        
        io.print("The key is " + isLaserCut + " laser cut.");
        io.readString("Press enter to continue.");
    }

    public int displayGetAllCarsMenu() {
        io.print("Menu Car Lists");
        io.print("1. View all Car");
        io.print("2. Get Cars by Color");
        io.print("3. Get Cars by Budget");
        io.print("4. Get Cars by Make and Model");
        
        return io.readInt("Please select from the above choices.", 1, 4);
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command");
        io.readString("Press enter to continue.");
    }

    public void displayDiscountCarBanner() {
        io.print("DISCOUNT A CAR");
    }

    public BigDecimal getPercentDiscount() {
        double percentNum = io.readDouble("How much is the discount?");
        String percentString = String.valueOf(percentNum);
        BigDecimal discount = new BigDecimal(percentString);

        return discount;
    }

    public void displayFinalPrice(BigDecimal finalPrice) {
        io.print("The car is now priced at $" + finalPrice.toPlainString() + ".");
        io.readString("Hit enter to continue.");
    }

    public BigDecimal getCashPaid() {
        String cashString = io.readString("How much was paid?");
        BigDecimal cash = new BigDecimal(cashString);
        
        return cash;
    }

    public void displaySellCarBanner() {
        io.print("SELL CAR");
    }

    public String getColor() {
        String color = io.readString("What color cars would you like to list?");
        return color;
    }

    public void displayListOfCars(List<Car> cars) {
        io.print("Now listing cars...");
        
        for(Car car : cars) {
            io.print("VIN# " + car.getVIN() + " " + car.getMake() + " " + car.getModel());
        }
        
        io.print("Listing cars complete.");
        io.readString("Hit enter to continue.");
    }

    public BigDecimal getBudget() {
        String maxPrice = io.readString("What is your budget?");
        BigDecimal budget = new BigDecimal(maxPrice);
        
        return budget;
    }

    public String getCarMake() {
        String make = io.readString("What is the car make?");
        return make;
    }

    public String getCarModel() {
        String model = io.readString("What is the car model?");
        return model;
    }

    public void displayErrorMessage(String message) {
        io.print(message);
    }

    public void displayGoodBye() {
        io.print("Goodbye!");
    }

    public void displayCarSale(CarKey key) {
        io.print("The car is now yours!");
        io.print("VIN# " + key.getVIN());
        String isLaserCut = key.isLaserCut() ? "" : "not";
        
        io.print("The key is " + isLaserCut + " laser cut.");
        io.readString("Press enter to continue.");
    }

}
