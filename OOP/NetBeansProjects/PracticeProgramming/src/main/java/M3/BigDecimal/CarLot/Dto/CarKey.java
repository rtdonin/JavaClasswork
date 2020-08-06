/*
Created by: Margaret Donin
Date created: 06/03/20
Date revised:
*/

package M3.BigDecimal.CarLot.Dto;

public class CarKey {
    private final String VIN;
    private boolean laserCut;
    
    public CarKey(String VIN){
        this.VIN = VIN;
    }

    public String getVIN() {
        return VIN;
    }

    public boolean isLaserCut() {
        return laserCut;
    }

    public void setLaserCut(boolean laserCut) {
        this.laserCut = laserCut;
    }
}
