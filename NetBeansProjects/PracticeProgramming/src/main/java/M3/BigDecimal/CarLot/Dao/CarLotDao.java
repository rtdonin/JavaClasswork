/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Dao;

import M3.BigDecimal.CarLot.Dto.Car;
import M3.BigDecimal.CarLot.Service.NoSuchCarException;
import java.util.List;

public interface CarLotDao {
    public Car addCar(String VIN, Car car) throws NoSuchCarException;    

    public Car getCar(String VIN) throws NoSuchCarException;
    
    public List<Car> getCars() throws NoSuchCarException;

    public void editCar(String VIN, Car car) throws NoSuchCarException;    

    public Car removeCar(String VIN) throws NoSuchCarException;    
}
