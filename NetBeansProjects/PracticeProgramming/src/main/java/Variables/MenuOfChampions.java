/*
Created by: Margaret Donin
Date created: 04/14/20
Date revised:
*/

package Variables;

public class MenuOfChampions {
    public static void main(String[] args) {
        String foodItem1 = "Slice of Big Rico Pizza";
        String foodItem2 = "Invisible Strawberry Pie";
        String foodItem3 = "Denver Omelet";
        
        double price1 = 500.00;
        double price2 = 2.00;
        double price3 = 1.50;
        
        System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.");
        System.out.println("WELCOME TO RESTAURANT NIGHT VALE!");
        System.out.println("Today's Menu Is...");
        System.out.println(".oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.oOo.");
        
        System.out.println("$ " + price1 + " " + foodItem1);
        System.out.println("$ " + price2 + " " + foodItem2);
        System.out.println("$ " + price3 + " " + foodItem3);
    }
}