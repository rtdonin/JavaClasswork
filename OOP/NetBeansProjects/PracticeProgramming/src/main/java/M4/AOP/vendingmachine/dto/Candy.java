/*
Created by: Margaret Donin
Date created: 06/07/20
Date revised:
*/

package M4.AOP.vendingmachine.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Candy {
    private int inventory;
    private final String name;
    private final BigDecimal price;

    public Candy(String name, BigDecimal price, int inventory) {
        this.name = name;
        this.price = price;
        this.inventory = inventory;
    }
    
    public String getName() {
        return name;
    }
    
    public BigDecimal getPrice() {
        return price;
    }
    
    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "Candy " + name + " $" + price + " with " + inventory + " in stock.";
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + this.inventory;
        hash = 29 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Candy other = (Candy) obj;
        if (this.inventory != other.inventory) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }

}
