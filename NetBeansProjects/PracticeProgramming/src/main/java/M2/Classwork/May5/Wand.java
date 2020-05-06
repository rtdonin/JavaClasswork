/**
 * Created: 05/06/20
 */

package M2.Classwork.May5;

public class Wand extends Item{
    public String woodType;
    public String core;

    
    public Wand(String name, Double price, Integer quantity, String woodType, String core) {
        super(name,price,quantity);
        this.woodType = woodType;
        this.core = core;
    }

    
    public String getWoodType() {
        return woodType;
    }
    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }
    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }
    
}