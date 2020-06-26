/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:

to use for State and Product dto's

Map newMap = Collections.unmodifiableMap(map);
*/

package flooring;

import flooring.controller.FlooringController;
import flooring.dao.FlooringOrderDao;
import flooring.dao.FlooringOrderDaoImpl;
import flooring.dao.FlooringProductDao;
import flooring.dao.FlooringProductDaoImpl;
import flooring.dao.FlooringStateDao;
import flooring.dao.FlooringStateDaoImpl;
import flooring.service.FlooringServiceLayer;
import flooring.service.FlooringServiceLayerImpl;
import flooring.ui.FlooringView;
import flooring.ui.FlooringViewImpl;
import flooring.ui.UserIO;
import flooring.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        // will be reqired using Spring
        UserIO io = new UserIOConsoleImpl();
        FlooringView view = new FlooringViewImpl(io);
        
        FlooringOrderDao orderDao = new FlooringOrderDaoImpl();
        FlooringProductDao productDao = new FlooringProductDaoImpl();
        FlooringStateDao stateDao = new FlooringStateDaoImpl();
        
        FlooringServiceLayer service = new FlooringServiceLayerImpl(orderDao, productDao, stateDao);
        FlooringController controller = new FlooringController(view, service);
        
    }
}
