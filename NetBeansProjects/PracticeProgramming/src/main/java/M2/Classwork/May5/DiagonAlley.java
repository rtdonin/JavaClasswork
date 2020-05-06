package M2.Classwork.May5;

/**
 * Created: 05/05/20
 */

public class DiagonAlley{
    public static void main(String[] args) {
        WandStore olivanders = new WandStore("Olivanders", "Olivander", 20);
        // Store flourishAndBlottsBookseller = new Store("Flourish and Blotts Bookseller", "Mr. Manager", 50);

        olivanders.setInventory("Beechwood", 4.50, 3);
        olivanders.setInventory("Alder Wood", 7.50, 4);
        olivanders.setInventory("Oak Wood", 5.00, 2);
        
        olivanders.setWandInventory("Beechwood", 4.50, 3, "beech", "unicorn hair");
        olivanders.setWandInventory("Alder Wood", 7.50, 4, "alder", "dragon heartstring");
        olivanders.setWandInventory("Oak Wood", 5.00, 2, "oak", "phoenix feather");

//        olivanders.enter();
//        olivanders.wandHistory();
//        olivanders.findWand();
//        olivanders.sell();
//        olivanders.exit();

        for (int i = 0; i < olivanders.getWandInventory().size(); i++){
            System.out.println(WandStore.marshallWands(olivanders.getWand(i)));
        }
//        flourishAndBlottsBookseller.enter();
//        flourishAndBlottsBookseller.sell();
//        flourishAndBlottsBookseller.exit();
       int x = 2;
       
    }
}