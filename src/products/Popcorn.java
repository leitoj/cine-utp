package products;

public class Popcorn extends Product {

    public Popcorn(int sizeCode, boolean areSweet, int amount) {
        super("Popcorn " + (sizeCode == 1 ? "chico" : sizeCode == 2 ? "mediano" : "grande"), amount);

        switch (sizeCode) {
            case 1:
                setPrice(areSweet ? 2.25 : 1.25);
                break;
            case 2:
                setPrice(areSweet ? 2.50 : 2.00);
                break;
            case 3:
                setPrice(areSweet ? 3.50 : 3.00);
                break;
            default:
                setPrice(0.0);
                break;
        }
    }
}
