package products;

public class Combo extends Product {
    public Combo(String name, int amount, double price) {
        super(name, amount);
        setPrice(price);
    }
}
