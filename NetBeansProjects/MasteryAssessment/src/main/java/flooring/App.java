/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring;

import flooring.controller.FlooringController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        FlooringView view = new FlooringViewImpl(io);
//        
//        FlooringExportDao exportDao = new FlooringExportDaoImpl();
//        FlooringOrderDao orderDao = new FlooringOrderDaoImpl();
//        FlooringProductDao productDao = new FlooringProductDaoImpl();
//        FlooringStateDao stateDao = new FlooringStateDaoImpl();
//        
//        FlooringServiceLayer service = new FlooringServiceLayerImpl(exportDao, orderDao, productDao, stateDao);
//        FlooringController controller = new FlooringController(view, service);

        
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        
        FlooringController controller = appContext.getBean("controller", FlooringController.class);
        
        controller.run(); 
        
    }
}
