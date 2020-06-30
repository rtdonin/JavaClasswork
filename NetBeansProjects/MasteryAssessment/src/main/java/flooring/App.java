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
        
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:appContext.xml");
        
        FlooringController controller = appContext.getBean("controller", FlooringController.class);
        
        controller.run();
        
    }
}
