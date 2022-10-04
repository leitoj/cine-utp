package products;

public abstract class Product implements Cloneable {
    private String name;
    private int amount;
    private double price;

    Product() {
    }

    Product(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Registre un precio mayor a cero");
            return;
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto: " + this.name + " - " + this.amount + " - $" + this.price;
    }

    public Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }
}
