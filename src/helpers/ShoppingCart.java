package helpers;

import java.util.ArrayList;
import java.util.Scanner;

import products.Agua;
import products.Chocolate;
import products.Combo;
import products.HotDog;
import products.Popcorn;
import products.Product;
import products.Refresco;
import views.Views;

public class ShoppingCart {
    private ArrayList<Product> list = new ArrayList<>();
    private boolean jubilado = false;
    private double total = 0;

    private static Scanner teclado = new Scanner(System.in);
    private static Views view = new Views();

    public void insertProduct(int optionCode) {

        if (optionCode == 0) {
            view.askJubilado();
            jubilado = Helper.insert(1, 2) == 1 ? true : false;
            return;
        }

        // Ask amount
        view.askAmount();
        int amount = teclado.nextInt();

        // POPCORN OPTION
        if (optionCode > 0 && optionCode <= 3) {
            // Ask for sweet
            view.askSweet();
            int sweet = Helper.insert(1, 2);
            // ADD to cart
            list.add(new Popcorn(optionCode, sweet == 1 ? true : false, amount));
            return;
        }

        // SODA OPTION
        if (optionCode >= 5 && optionCode <= 7) {
            list.add(new Refresco(optionCode, amount));
            return;
        }

        if (optionCode >= 10 && optionCode <= 12) {
            String name = "Combo " + (optionCode == 10 ? "1" : optionCode == 11 ? "2" : "3");
            double price = optionCode == 10 ? 4.50 : optionCode == 11 ? 5.00 : 6.80;

            list.add(new Combo(name, amount, price));
            return;
        }

        switch (optionCode) {
            case 4:
                list.add(new HotDog(amount));
                break;
            case 8:
                list.add(new Agua(amount));
                break;
            case 9:
                list.add(new Chocolate(amount));
                break;
        }
        return;
    }

    public void show() {
        view.clearConsole();
        view.showInvoiceHeader();
        for (Product item : list) {
            System.out.printf("\n\t\t* %s (%d) - Total $ %s", item.getName(), item.getAmount(), item.getTotal());

            total += item.getTotal();
        }

        if (jubilado) {
            System.out.printf("\n\n\t\t* Total a pagar de: $ %.2f", total - (total * 0.20));
            System.out.println("\n\t\tDescuento de jubilado incluido exitosamente...");
            return;
        }

        System.out.printf("\n\n\t\t* Total a pagar de: $ %f.2", total);
        return;

    }

    public ArrayList<Product> getList() {
        return this.list;
    }

    public double getTotal() {
        return this.total;
    }

    public boolean getJubilado() {
        return this.jubilado;
    }
}
