/*
Created by: Margaret Donin
Date created: 06/25/20
Date revised:
*/

package flooring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Order {
    private final Integer id;
    private String name;
    private State state; // includes state name, taxRate
    private Product product; // includes productType, costPerSquareFoot, laborCostPerSquareFoor
    private BigDecimal area;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal tax;
    private BigDecimal total;
    private LocalDate date;
    
    public Order(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + " " + name + ": " + state
                + "\n\t\t" + product
                + "\n\t\t" + "Area: " + area.toPlainString() + " sqft"
                + "\n\t\t" + "Materials: $"+ materialCost.toPlainString()
                + "\n\t\t" + "Labor: $" + laborCost.toPlainString()
                + "\n\t\t" + "Tax: $" + tax.toPlainString()
                + "\n\t\t" + "Total: $" + total.toPlainString()
                + "\n\t\t" + "Date: " + date;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.state);
        hash = 71 * hash + Objects.hashCode(this.product);
        hash = 71 * hash + Objects.hashCode(this.area);
        hash = 71 * hash + Objects.hashCode(this.materialCost);
        hash = 71 * hash + Objects.hashCode(this.laborCost);
        hash = 71 * hash + Objects.hashCode(this.tax);
        hash = 71 * hash + Objects.hashCode(this.total);
        hash = 71 * hash + Objects.hashCode(this.date);
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
        final Order other = (Order) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.area, other.area)) {
            return false;
        }
        if (!Objects.equals(this.materialCost, other.materialCost)) {
            return false;
        }
        if (!Objects.equals(this.laborCost, other.laborCost)) {
            return false;
        }
        if (!Objects.equals(this.tax, other.tax)) {
            return false;
        }
        if (!Objects.equals(this.total, other.total)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

}
