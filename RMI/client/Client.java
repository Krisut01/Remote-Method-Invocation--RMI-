import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the registry.
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9100);

            CartInterface myCart = (CartInterface) registry.lookup("myCart");
            ProductInterface p1 = (ProductInterface) registry.lookup("laptop");
            ProductInterface p2 = (ProductInterface) registry.lookup("Phone");
            ProductInterface p3 = (ProductInterface) registry.lookup("charger");
            ProductInterface p4 = (ProductInterface) registry.lookup("powerBank");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Display all products");
                System.out.println("2. Add products ");
                System.out.println("3. View all added products");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Available products:");
                        System.out.println("1. " + p1.getName() + " - Code: " + p1.getCode());
                        System.out.println("2. " + p2.getName() + " - Code: " + p2.getCode());
                        System.out.println("3. " + p3.getName() + " - Code: " + p3.getCode());
                        System.out.println("4. " + p4.getName() + " - Code: " + p4.getCode());
                        break;
                    case 2:
                        System.out.println("Enter product code to add:");
                        int productCode = scanner.nextInt();
                        String productName = "";
                        if (productCode == p1.getCode()) {
                            productName = p1.getName();
                        } else if (productCode == p2.getCode()) {
                            productName = p2.getName();
                        } else if (productCode == p3.getCode()) {
                            productName = p3.getName();
                        } else if (productCode == p4.getCode()) {
                            productName = p4.getName();
                        } else {
                            System.out.println("Invalid product code!");
                            continue;
                        }
                        myCart.addProdInCart(productCode, productName);
                        System.out.println("Product added to cart.");
                        break;
                    case 3:
                        String[][] prods = myCart.viewProdInCart();
                        System.out.println("\nProducts in Cart:");
                        for (int i = 0; i < prods[0].length; i++) {
                            System.out.printf("Name: %s\t Code: %s\n", prods[0][i], prods[1][i]);
                        }
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }

        } catch (Exception e) {
            System.out.println("Client side error: " + e);
        }
    }
}
