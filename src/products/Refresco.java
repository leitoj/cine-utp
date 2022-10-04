package products;

public class Refresco extends Product {
    private String size;

    public Refresco(String size, int amount) {
        super("Refresco " + size, amount);
        switch (size) {
            case "Pequeña":
                setPrice(1.30);
                break;
            case "Mediano":
                setPrice(2.00);
                break;
            case "Grande":
                setPrice(2.75);
                break;
            default:
                setPrice(0.0);
                break;
        }
        this.size = size;
    }
}
