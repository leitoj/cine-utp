package helpers;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

import products.Popcorn;
import products.Product;

class Products {
    int popcorn = 0, hotdog = 0, refresco = 0, chocolate = 0, agua = 0;
    double $popcorn = 0.0, $hotdog = 0.0, $refresco = 0.0, $chocolate = 0.0, $agua = 0.0;
    int totalProducts = 0;

    public void sumItem(Product item) {
        totalProducts += item.getAmount();

        switch (item.getClass().getSimpleName()) {
            case "Agua":
                agua += item.getAmount();
                $agua += item.getAmount() * item.getPrice();
                break;
            case "Chocolate":
                chocolate += item.getAmount();
                $chocolate += item.getAmount() * item.getPrice();
                break;
            case "HotDog":
                hotdog += item.getAmount();
                $hotdog += item.getAmount() * item.getPrice();
                break;
            case "Popcorn":
                popcorn += item.getAmount();
                $popcorn += item.getAmount() * item.getPrice();
                break;
            case "Refresco":
                refresco += item.getAmount();
                $refresco += item.getAmount() * item.getPrice();
                break;
            case "Combo":
                String named = item.getName();
                int code = item.getName().charAt(named.length() - 1);

                if (code == 49) {

                    popcorn += item.getAmount();
                    $popcorn += item.getAmount() * item.getPrice();

                    refresco += item.getAmount();
                    $refresco += item.getAmount() * item.getPrice();
                    break;
                }
                if (code == 50) {
                    hotdog += item.getAmount();
                    $hotdog += item.getAmount() * item.getPrice();

                    refresco += item.getAmount();
                    $refresco += item.getAmount() * item.getPrice();
                    break;
                }
                if (code == 51) {
                    popcorn += item.getAmount();
                    $popcorn += item.getAmount() * item.getPrice();

                    refresco += (item.getAmount() * 2);
                    $refresco += item.getAmount() * item.getPrice();
                    break;
                }
                break;
            default:
                break;
        }
    }
}

public class Database {
    private ArrayList<ShoppingCart> records = new ArrayList<>();
    private Products products = new Products();
    private int countJubilados = 0;

    public void insertRecord(ShoppingCart cart) {
        records.add(cart);
        countJubilados += cart.getJubilado() ? 1 : 0;
        for (Product item : cart.getList()) {
            products.sumItem(item);
        }
    }

    public void showRecords() {
        int record = 1;

        if (records.size() == 0) {
            System.out.println("\t\t**************************************");
            System.out.println("\t\t*    NO SE HAN REGISTRADO VENTAS     *");
            System.out.println("\t\t**************************************");

            return;
        }

        for (ShoppingCart shoppingCart : records) {
            System.out.print("\n\n");
            System.out.println("\t\t**************************************");
            System.out.printf("\t\t             FACTURA %s        \n", record);
            System.out.println("\t\t**************************************");
            for (Product item : shoppingCart.getList()) {
                System.out.printf("\t\t* %s (%d) ... $ %.2f \n", item.getName(), item.getAmount(), item.getTotal());
            }
            System.out.printf("\n\t\tTotal pagado: $ %.2f", shoppingCart.getTotal());
            if (shoppingCart.getJubilado()) {
                System.out.printf("\n\n\t\t\033[3m%s\033[0m", "Descuento de jubilado aplicado");
            }
            record++;
        }

        System.out.println("\n\n");
    }

    public void showData() {
        int base = products.totalProducts != 0 ? products.totalProducts : 1;
        System.out.printf("\n\t\t Descuento de jubilados aplicados ... %d \n", this.countJubilados);
        System.out.printf("\n\t\t1. POPCORN ............... $ %.2f (%d) - ", products.$popcorn,
                products.popcorn);
        System.out.print((products.popcorn * 100) / base + "%");

        System.out.printf("\n\t\t2. HOTDOG ................ $ %.2f (%d) - ", products.$hotdog, products.hotdog);
        System.out.print((products.hotdog * 100) / base + "%");

        System.out.printf("\n\t\t3. REFRESCO ................ $ %.2f (%d) - ", products.$refresco, products.refresco);
        System.out.print((products.refresco * 100) / base + "%");

        System.out.printf("\n\t\t4. CHOCOLATE ................ $ %.2f (%d) - ", products.$chocolate,
                products.chocolate);
        System.out.print((products.chocolate * 100) / base + "%");

        System.out.printf("\n\t\t5. AGUA ................ $ %.2f (%d) - ", products.$agua, products.agua);
        System.out.print((products.agua * 100) / base + "%");
    }
}
