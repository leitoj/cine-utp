package products;

public class Popcorn extends Product {
    private String size;

    public Popcorn(String size, boolean areSweet, int amount) {
        super("Popcorn " + size, amount);
        switch (size) {
            case "Chico":
                setPrice(areSweet ? 2.25 : 1.25);
                break;
            case "Mediano":
                setPrice(areSweet ? 2.50 : 2.00);
                break;
            case "Grande":
                setPrice(areSweet ? 3.50 : 3.00);
            default:
                setPrice(0.0);
                break;
        }
        this.size = size;
    }
}
