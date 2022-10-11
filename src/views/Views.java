package views;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import products.Product;

public class Views {
    public void showPrincipalHeader() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t* BIENVENIDOS A LA CAJA REGISTRADORA *");
        System.out.println("\t\t**************************************");
    }

    public void showEnterOption() {
        System.out.print("\t\t* Digite una opción: ");
    }

    public void showEnterOptionAgain() {
        System.out.print("\t\t* Digite una opción valida: ");
    }

    public void askAmount() {
        System.out.print("\t\t* Cantidad: ");
    }

    public void askSweet() {
        System.out.print("\t\t* Desea añadir dulce $0.50 cents adicionales");
        System.out.print("\n\t\t* 1. SI \t\t* 2. NO");
        showEnterOption();
    }

    public void askJubilado() {
        System.out.print("\t\t* Esta usted jubilado?");
        System.out.print("\n\t\t* 1. SI \t\t* 2. NO");
        showEnterOption();
    }

    public void showInvoice(ArrayList<Product> register) {
        int totalPayment = 0;

        System.out.println("\t\t*******************************************************************************");
        System.out.println("\t\t*                               C O M P R A                                   *");
        System.out.println("\t\t*******************************************************************************");

        for (Product i : register) {
            System.out.println("\t\t" + i.getName() + "(" + i.getAmount() + ")\t  - Unidad $ " + i.getPrice()
                    + "\t\t\t Total de $ "
                    + i.getAmount() * i.getPrice() + "\t\t");
            totalPayment += (i.getAmount() * i.getPrice());
        }
        System.out.println("\t\tTotal a pagar de ...... $ " + totalPayment);
    }

    public void showPrincipalMenu() {
        System.out.println("\t\t\t 1. Nueva compra");
        System.out.println("\t\t\t 2. Compras");
        System.out.println("\t\t\t 3. Salir");
        showEnterOption();
    }

    public void showBuyMenu() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE COMPRAS         *");
        System.out.println("\t\t**************************************");
    }

    public void showInvoiceHeader() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            FACTURA COMPRA          *");
        System.out.println("\t\t**************************************");
    }

    public void waitMenu() {
        System.out.print("\n\n\t\t* Presiona cualquier boton para continuar");
    }

    public void showSaleMenu() {
        System.out.println("\t\t**************************************");
        System.out.println("\t\t*            MENU DE CINE            *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  1. POPCORN CHICO......... $ 1.25  *");
        System.out.println("\t\t*  2. POPCORN MEDIANO....... $ 2.00  *");
        System.out.println("\t\t*  3. POPCORN GRANDE........ $ 3.00  *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  4. HOTDOG................ $ 2.50  *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  5. REFRESCO PEQUEÑO...... $ 1.30  *");
        System.out.println("\t\t*  6. REFRESCO MEDIANO...... $ 2.00  *");
        System.out.println("\t\t*  7. REFRESCO GRANDE....... $ 2.75  *");
        System.out.println("\t\t*  8. AGUA.................. $ 1.50  *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  9. CHOCOLATE............. $ 1.75  *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  10. COMBO 1.............. $ 4.50  *");
        System.out.println("\t\t*         -POPCORN MEDIANO           *");
        System.out.println("\t\t*         -REFRESCO GRANDE           *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  11. COMBO 2.............. $ 5.00  *");
        System.out.println("\t\t*         -HOTDOG                    *");
        System.out.println("\t\t*         -REFRESCO GRANDE           *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  12. COMBO 3.............. $ 6.80  *");
        System.out.println("\t\t*         -POPCORN GRANDE            *");
        System.out.println("\t\t*         -2 REFRESCOS MEDIANOS      *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t*  PRESIONA 0 (ZERO) PARA FINALIZAR  *");
        System.out.println("\t\t*              LA COMPRA             *");
        System.out.println("\t\t*                                    *");
        System.out.println("\t\t**************************************");
        showEnterOption();
    }

    public void clearConsole() {
        try {
            switch (System.getProperty("os.name").toLowerCase()) {
                case "linux":
                case "darwin":
                    System.out.print("\033[H\033[2J");
                    break;
                case "windows":
                    Runtime.getRuntime().exec("cls");
                    break;
                default:
                    System.out.println();
            }
        } catch (Exception ignored) {
            System.out.println(ignored);
        }
    }

}
