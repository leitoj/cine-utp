import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import database.Sales;
import products.Agua;
import products.Chocolate;
import products.HotDog;
import products.Popcorn;
import products.Product;
import products.Refresco;
import views.Views;

public class App {
    private static Scanner teclado = new Scanner(System.in);
    private static Views view = new Views();

    public static void main(String[] args) throws Exception {
        init();
    }

    public static void init() {
        Sales sales = new Sales();
        int option;
        do {
            view.clearConsole();
            view.showPrincipalHeader();
            view.showPrincipalMenu();

            option = teclado.nextInt();
            view.clearConsole();

            switch (option) {
                case 1:
                    int itemOption;
                    ArrayList<Product> register = new ArrayList<>();
                    do {
                        view.showBuyMenu();
                        view.showSaleMenu();
                        itemOption = teclado.nextInt();

                        boolean areSweet = false;

                        if (itemOption > 0 && itemOption <= 9) {
                            view.showAmount();
                            int amount = teclado.nextInt();
                            if (itemOption == 1 || itemOption == 2 || itemOption == 3) {
                                view.showSweet();

                                areSweet = teclado.nextInt() == 1 ? true : false;
                            }

                            handleSelection(itemOption, amount, register, areSweet);

                        } else if (itemOption == 0) {
                            view.clearConsole();
                            view.showInvoice(register);
                            sales.insertSale(register);

                            view.waitMenu();
                            try {
                                System.in.read();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } while (itemOption != 0);
                    break;

                case 2:
                    System.out.print("Opcion 2 ver compras");
                    view.clearConsole();
                    sales.showInvoices();
                    view.waitMenu();
                    try {
                        System.in.read();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    System.out.print("Opcion 3 salir");
                    break;
                default:
                    System.out.print("Opcion no valida");
                    break;
            }
        } while (option != 3);
    }

    public static void handleSelection(int itemOption, int amount, ArrayList<Product> register, boolean areSweet) {
        switch (itemOption) {
            case 1:
                register.add(new Popcorn("Chico", areSweet, amount));
                break;
            case 2:
                register.add(new Popcorn("Mediano", areSweet, amount));
                break;
            case 3:
                register.add(new Popcorn("Grande", areSweet, amount));
                break;
            case 4:
                register.add(new HotDog(amount));
                break;
            case 5:
                register.add(new Refresco("Pequeña", amount));
                break;
            case 6:
                register.add(new Refresco("Mediano", amount));
                break;
            case 7:
                register.add(new Refresco("Grande", amount));
                break;
            case 8:
                register.add(new Agua(amount));
                break;
            case 9:
                register.add(new Chocolate(amount));
            default:
                System.out.print("Error");
                break;
        }
    }
}
