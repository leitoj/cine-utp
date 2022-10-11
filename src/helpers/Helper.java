package helpers;

import java.util.Scanner;
import views.Views;

public class Helper {
    private static Scanner teclado = new Scanner(System.in);
    private static Views view = new Views();

    public static int insert(int min, int max) {
        do {
            int option = teclado.nextInt();
            if (option >= min && option <= max) {
                return option;
            }
            view.showEnterOptionAgain();

        } while (true);
    }

    public static void pause() {
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
