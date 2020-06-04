/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Service;

import M3.BigDecimal.CarLot.Dto.Car;
import M3.BigDecimal.CarLot.Dto.CarKey;
import java.math.BigDecimal;
import java.util.List;

public interface CarLotService {
    public Car getACar(String VIN) throws NoSuchCarException;    
    public List<Car> getAllCars() throws NoSuchCarException;
    public List<Car> getCarsByColor(String color) throws NoSuchCarException;
    public List<Car> getCarsInBudget(BigDecimal maxPrice) throws NoSuchCarException;
    public List<Car> getCarByMakeAndModel(String make, String model) throws NoSuchCarException;

    public BigDecimal discountCar(String VIN, BigDecimal percentDiscount)
        throws NoSuchCarException;

    public CarKey sellCar(String VIN, BigDecimal cashPaid)
        throws NoSuchCarException,
        OverpaidPriceException,
        UnderpaidPriceException;
}
