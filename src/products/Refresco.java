package products;

public class Refresco extends Product {
    public Refresco(int sizeCode, int amount) {
        super("Refresco " + (sizeCode == 5 ? "pequeño" : sizeCode == 6 ? "mediano" : "grande"), amount);
        switch (sizeCode) {
            case 5:
                setPrice(1.30);
                break;
            case 6:
                setPrice(2.00);
                break;
            case 7:
                setPrice(2.75);
                break;
            default:
                setPrice(0.0);
                break;
        }
    }
}
