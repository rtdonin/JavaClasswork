/**
 * Created: 05/05/20
 */

package M2.Classwork.May5;

public class Item{
    public String name;
    public Double price;
    public Integer quantity;
    

    public Item(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

}

