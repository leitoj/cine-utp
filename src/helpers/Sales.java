// import java.lang.reflect.Array;
// import java.util.ArrayList;
// import java.util.List;

// import products.Product;

// public class Sales {
// private int popcorn = 0, refresco = 0, agua = 0, soda = 0, hotdog = 0,
// chocolate = 0, totalAmount = 0,
// totalSell = 0;

// private ArrayList<String> invoices = new ArrayList<String>();

// public void insertSale(ArrayList<Product> sales, boolean jubilado) {
// if (sales.size() == 0) {
// System.out.println("No se a registrado ningun venta el dia de hoy");
// } else {
// for (int i = 0; i < sales.size(); i++) {
// String invoice = "\t\t" + i + ". \t " + sales.get(i).getName() + "(" +
// sales.get(i).getAmount()
// + ") | Pago total... $ "
// + (sales.get(i).getAmount() * sales.get(i).getPrice());

// invoices.add(invoice);

// switch (sales.get(i).getName()) {
// case "Popcorn Chico":
// case "Popcorn Mediano":
// case "Popcorn Grande":
// popcorn = sales.get(i).getAmount();
// break;
// case "HotDog":
// hotdog = sales.get(i).getAmount();
// break;
// case "Refresco Pequeña":
// case "Refresco Mediano":
// case "Refresco Grande":
// refresco = sales.get(i).getAmount();
// break;
// case "Agua":
// agua = sales.get(i).getAmount();
// break;
// case "Chocolate":
// chocolate = sales.get(i).getAmount();
// break;
// default:
// break;
// }

// totalAmount += sales.get(i).getAmount();
// totalSell += (sales.get(i).getPrice() * sales.get(i).getAmount());
// }
// }

// }

// public void showInvoices() {
// if (invoices.size() == 0) {
// System.out.print("No se a registrado ninguna venta en el dia de hoy");
// } else {
// for (String i : invoices) {
// System.out.println(i);
// }

// System.out.println("\t\t Total elementos vendidos: " + totalAmount);
// System.out.println("\t\t Total ganado $: " + totalSell);
// System.out.println("\n\t\t Popcorn: " + (popcorn * 100) / totalAmount + "%");
// System.out.println("\t\t Refrescos: " + (refresco * 100) / totalAmount +
// "%");
// System.out.println("\t\t Hotdog: " + (hotdog * 100) / totalAmount + "%");
// System.out.println("\t\t Agua: " + (agua * 100) / totalAmount + "%");
// System.out.println("\t\t Chocolate: " + (chocolate * 100) / totalAmount +
// "%");
// }

// }

// }
