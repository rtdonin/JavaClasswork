/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Dao;

import M3.BigDecimal.CarLot.Dto.Car;
import M3.BigDecimal.CarLot.Service.NoSuchCarException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarLotDaoImpl implements CarLotDao {
    private Map<String, Car> cars = new HashMap<>();
    public final String LOT_FILE = "carlot.txt";
    public static final String DELIMITER = "::";

    @Override
    public Car addCar(String VIN, Car car) throws NoSuchCarException {
        loadLot();
        VIN = VIN.toUpperCase();
        Car newCar = cars.put(VIN, car);
        writeLot();
        return newCar;        
    }

    @Override
    public Car getCar(String VIN) throws NoSuchCarException {
        loadLot();
        return cars.get(VIN);
    }

    @Override
    public List<Car> getCars() throws NoSuchCarException {
        loadLot();
        return new ArrayList<Car>(cars.values());
    }

    @Override
    public void editCar(String VIN, Car car) throws NoSuchCarException {
        loadLot();
        cars.put(VIN, car);
        writeLot();
    }

    @Override
    public Car removeCar(String VIN) throws NoSuchCarException {
        loadLot();
        Car removedCar = cars.remove(VIN);
        writeLot();
        return removedCar;
    }
    
    private String marshallData(Car car) {
        String carAsText = car.getVIN() + DELIMITER;
        carAsText += car.getMake() + DELIMITER;
        carAsText += car.getModel() + DELIMITER;
        carAsText += car.getColor() + DELIMITER;
        carAsText += car.getPrice().toString() + DELIMITER;
        carAsText += Long.toString(car.getOdometerMiles()) + DELIMITER;
        carAsText += Boolean.toString(car.getKey().isLaserCut());
        
        return carAsText;
    }
    
    private Car unmarshallData(String currentLine) {
        String[] carTokens = currentLine.split(DELIMITER);
        String VIN = carTokens[0];
        Car carFromFile = new Car(VIN);
        carFromFile.setMake(carTokens[1]);
        carFromFile.setModel(carTokens[2]);
        carFromFile.setColor(carTokens[3]);
        carFromFile.setPrice(new BigDecimal(carTokens[4]));
        carFromFile.setOdometerMiles(parseLong(carTokens[5]));
        carFromFile.getKey().setLaserCut(Boolean.parseBoolean(carTokens[6]));
        
        return carFromFile;
    }
    
    private void loadLot() throws NoSuchCarException {
        Scanner scanner;
        
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LOT_FILE)));
        } catch(FileNotFoundException e) {
            throw new NoSuchCarException("Could not load car lot.", e);
        }
        
        String currentLine;
        Car currentCar;
        
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentCar = unmarshallData(currentLine);
            cars.put(currentCar.getVIN(), currentCar);
        }
        // close scanner
        scanner.close();
    }
    
    private void writeLot() throws NoSuchCarException  {
        PrintWriter out;
        
        try {
            out = new PrintWriter(new FileWriter(LOT_FILE));
        } catch (IOException e) {
            throw new NoSuchCarException("Could not save car data.", e);
        }
        String carAsText;
        List<Car> carLot = new ArrayList(cars.values());
        
        for(Car currentCar : carLot) {
            carAsText = marshallData(currentCar);
            out.println(carAsText);
            out.flush();
        }
        
        out.close();
    }

}
