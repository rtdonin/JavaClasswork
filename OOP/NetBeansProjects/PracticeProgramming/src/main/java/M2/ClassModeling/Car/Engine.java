/*
Created by: Margaret Donin
Date created: 04/27/20
Date revised:
*/

package M2.ClassModeling.Car;

public class Engine{
    private float horsePower;
    private float trust;
    private float power;
    private float efficiency;

    public Engine(float horsePower, float trust, float power, float efficiency) {
        this.horsePower = horsePower;
        this.trust = trust;
        this.power = power;
        this.efficiency = efficiency;
    }

    public float getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(float horsePower) {
        this.horsePower = horsePower;
    }

    public float getTrust() {
        return trust;
    }

    public void setTrust(float trust) {
        this.trust = trust;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(float efficiency) {
        this.efficiency = efficiency;
    }
}