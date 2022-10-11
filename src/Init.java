import java.util.Scanner;

import helpers.Database;
import helpers.Helper;
// import helpers.Sales;
import helpers.ShoppingCart;
import views.Views;

public class Init {
    private static Scanner teclado = new Scanner(System.in);
    private static Views view = new Views();
    private Database database = new Database();

    // Sales sales = new Sales();

    private int option;

    public void run() {
        do {
            controlViewOptions();
        } while (option != 3);
    }

    public void controlViewOptions() {

        // MENU OPTION
        view.clearConsole();
        view.showPrincipalHeader();
        view.showPrincipalMenu();

        // INPUT OPTION
        option = Helper.insert(1, 3);
        view.clearConsole();

        switch (option) {
            case 1:
                purchaseController();
                break;
            case 2:
                invoicesController();
                break;
            case 3:
                System.out.print("Opcion 3 salir");
                break;
            default:
                System.out.print("Opcion no valida");
                break;
        }

    }

    public void purchaseController() {
        ShoppingCart cart = new ShoppingCart();
        int itemOption;

        do {
            // VISUAL MENU
            view.showBuyMenu();
            view.showSaleMenu();

            // HANDLE SELECTION AND ADD IT TO THE CART
            itemOption = Helper.insert(0, 12);
            cart.insertProduct(itemOption);

        } while (itemOption != 0);

        // SHOW INVOICE AND THEN SAVE IT INTO THE DATABASE
        cart.show();
        database.insertRecord(cart);
        Helper.pause();
    }

    public void invoicesController() {
        // System.out.print("Opcion 2 ver compras");
        // view.clearConsole();
        // sales.showInvoices();
        // view.waitMenu();
        // try {
        // System.in.read();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }
    }

}
