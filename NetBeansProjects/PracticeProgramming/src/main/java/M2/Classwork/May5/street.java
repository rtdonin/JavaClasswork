package M2.Classwork.May5;

/**
 * Created: 05/05/20
 */

public class street{
    public static void main(String[] args) {
        wandStore olivanders = new wandStore("Olivanders", "Olivander", 20);
        Store flourishAndBlottsBookseller = new Store("Flourish and Blotts Bookseller", "Mr. Manager", 50);
        
        olivanders.enter();
        olivanders.findWand();
        olivanders.sell();
        olivanders.exit();
        
        flourishAndBlottsBookseller.enter();
        flourishAndBlottsBookseller.sell();
        flourishAndBlottsBookseller.exit();
    }
}