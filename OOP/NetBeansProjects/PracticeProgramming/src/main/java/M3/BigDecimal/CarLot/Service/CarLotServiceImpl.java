/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.BigDecimal.CarLot.Service;

import M3.BigDecimal.CarLot.Dao.CarLotDaoImpl;
import M3.BigDecimal.CarLot.Dto.Car;
import M3.BigDecimal.CarLot.Dto.CarKey;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

public class CarLotServiceImpl implements CarLotService {
    private CarLotDaoImpl dao;
    
    public CarLotServiceImpl(CarLotDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public Car getACar(String VIN) throws NoSuchCarException {
        return dao.getCar(VIN);
    }

    @Override
    public List<Car> getAllCars() throws NoSuchCarException {
        return dao.getCars();
    }

    @Override
    public List<Car> getCarsByColor(String color) throws NoSuchCarException {
        List<Car> allCars = dao.getCars();
        List<Car> colorCars = new ArrayList<>();
        color = color.toUpperCase();
        
        for(Car car : allCars) {
            if (car.getColor().equals(color)) {
                colorCars.add(car);
            }
        }
        
        return colorCars;
    }

    @Override
    public List<Car> getCarsInBudget(BigDecimal maxPrice) throws NoSuchCarException {
        List<Car> allCars = dao.getCars();
        List<Car> budgetCars = new ArrayList<>();
        
        
        for(Car car : allCars) {
            if (car.getPrice().compareTo(maxPrice) >= 0) {
                budgetCars.add(car);
            }
        }
        
        return budgetCars;
    }

    @Override
    public List<Car> getCarByMakeAndModel(String make, String model) throws NoSuchCarException {
        List<Car> allCars = dao.getCars();
        List<Car> budgetCars = new ArrayList<>();
        make = make.toUpperCase();
        model = model.toUpperCase();
        
        for(Car car : allCars) {
            if (car.getMake().equals(make) && car.getModel().equals(model)) {
                budgetCars.add(car);
            }
        }
        
        return budgetCars;
    }

    
    @Override
    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount) throws NoSuchCarException {
        Car car = dao.getCar(VIN);
        BigDecimal percent = new BigDecimal("100");
        MathContext mc = new MathContext(2);
        
        // X% -> x/100
        percent = percentDiscount.divide(percent, mc);
        // Price * x/100 = discount
        percent = car.getPrice().multiply(percent, mc);
        // old price - discount
        BigDecimal newPrice = car.getPrice().subtract(percent, mc);
        car.setPrice(newPrice);
        dao.editCar(VIN, car);
        
        return newPrice;
        
    }

    @Override
    public CarKey sellCar(String VIN, BigDecimal cashPaid) throws NoSuchCarException, OverpaidPriceException, UnderpaidPriceException {
        Car car = dao.getCar(VIN);
        
        if (car.getPrice().compareTo(cashPaid) == 0) {
            dao.removeCar(VIN);
        } else if (car.getPrice().compareTo(cashPaid) > 0) {
            throw new OverpaidPriceException("The car was overpaid.");
        } else if (car.getPrice().compareTo(cashPaid) < 0 ) {
            throw new UnderpaidPriceException("The car was underpaid.");
        }
        
        return car.getKey();
    }

}
