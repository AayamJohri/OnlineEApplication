import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean isAdmin = false;

        ProductCatalog productCatalog1 = new ProductCatalog();

        Product p1 = new Product(101, "Iphone 13", 50.0, 10);
        Product p2 = new Product(102, "Laptop ", 25.0, 20);
        Product p3 = new Product(103, "Camera", 100.0, 5);
        productCatalog1.addProduct(p1);
        productCatalog1.addProduct(p2);
        productCatalog1.addProduct(p3);

        while (true) {
            if (!isAdmin) {
                System.out.println("Welcome to the e-commerce : ");
                System.out.print("Are you an admin? (yes/no): ");
                String isAdminInput = scanner.next();
                isAdmin = isAdminInput.equalsIgnoreCase("yes");



            }

            if (isAdmin) {
                System.out.println("Enter your userName");
                String username = scanner.next();
                System.out.println("Enter your password");
                String password = scanner.next();
                UserCases.adminPage(scanner, productCatalog1);
            } else {
                UserCases.userPage(scanner, productCatalog1);
            }
        }

    }


}
