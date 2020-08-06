/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/
package M3.BigDecimal.CarLot;

import M2.Summary.classroster.ui.UserIOConsoleImpl;
import M3.BigDecimal.CarLot.Controller.CarLotController;
import M3.BigDecimal.CarLot.Dao.CarLotDaoImpl;
import M3.BigDecimal.CarLot.Service.CarLotServiceImpl;
import M3.BigDecimal.CarLot.Service.NoSuchCarException;
import M3.BigDecimal.CarLot.Ui.CarLotView;

public class App {
    public static void main(String[] args) throws NoSuchCarException {
        UserIOConsoleImpl userIO = new UserIOConsoleImpl();
        CarLotView myView = new CarLotView(userIO);
        CarLotDaoImpl myDao = new CarLotDaoImpl();
        CarLotServiceImpl myService = new CarLotServiceImpl(myDao);
        CarLotController controller = new CarLotController(myView, myService);
        
        controller.run();
    }
}
