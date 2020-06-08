/*
Created by: Margaret Donin
Date created:
Date revised:
*/

package M3.vendingmachine.ui;

import M2.DVDlibrary.ui.UserIO;
import M3.vendingmachine.dto.Candy;
import java.util.Map;

public class VendingMachineView {
    UserIO io;
    
    public VendingMachineView(UserIO myIo) {
        this.io = io;
    }

    public int printMenuGetSelection(Map<Integer, Candy> availableCandy) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void unknownCommand() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
