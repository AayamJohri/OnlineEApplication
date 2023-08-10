import java.time.LocalDate;
import java.util.Scanner;



public class UserCases {

    public static void adminPage(Scanner scanner, ProductCatalog productCatalog1 ) {
        while (true) {
            System.out.println("Welcome to the Admin Page : ");
            System.out.println("Press 1 to add new product to the product Catalog");
            System.out.println("Press 2 to remove the product from the product Catalog");
            System.out.println("Press 3 to show the product catalog");

            System.out.println("Press 0 to go back to the user Page");

            String input = scanner.next();


            if (input.equals("1")) {
                try {
                    System.out.println("Enter the Product ID");
                    int productID = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter the Product Name");
                    String productName = scanner.next();
                    scanner.nextLine();
                    System.out.println("Enter the price ");
                    double price = scanner.nextDouble();
                    System.out.println("Enter the quantity");
                    int quantityAvailable = scanner.nextInt();
                    scanner.nextLine();
                    Product product12 = new Product(productID, productName, price, quantityAvailable);
                    productCatalog1.addProduct(product12);

                    System.out.println("\nProduct Added to the Catalog:");
                    for (Product product : productCatalog1.getAllProducts()) {
                        product.displayDetails();
                        System.out.println("--------------");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input format. Please try again.");
                    scanner.nextLine();
                }
            } else if (input.equals("2")) {
                try {
                    System.out.println("Enter the Product ID");
                    int productID = scanner.nextInt();
                    productCatalog1.removeProduct(productID);

                    System.out.println("\nProduct Catalog:");
                    for (Product product : productCatalog1.getAllProducts()) {
                        product.displayDetails();
                        System.out.println("--------------");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input format. Please try again.");
                    scanner.nextLine();
                }
            } else if (input.equals("3")) {
                System.out.println("\nProduct Catalog:");
                for (Product product : productCatalog1.getAllProducts()) {
                    product.displayDetails();
                    System.out.println("--------------");
                }
            } else if (input.equals("0")) {
                ;userPage(scanner,productCatalog1);
            }
        }
    }

    public static void userPage(Scanner scanner, ProductCatalog productCatalog1) {
        try {
        while (true) {
            for (Product product : productCatalog1.getAllProducts()) {
                product.displayDetails();
                System.out.println("--------------");
            }
            System.out.println("Press 1 to Place an order");
            System.out.println("Press 2 to view the Shopping cart");
            System.out.println("Press 3 to go back to the main page");
            System.out.println("Press 0 to exit");

            int input = scanner.nextInt();
            scanner.nextLine();

            ShoppingCart shoppingCart = new ShoppingCart();
            Order order = null;

            switch (input) {
                case 1:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();

                    int min = 100;
                    int max = 1000;
                    int orderID = (int) (Math.random() * (max - min + 1) + min);
                    order = new Order(orderID, customerName, LocalDate.now());

                    System.out.println("\nAdding products to the shopping cart (enter 0 to stop):");
                    while (true) {
                        System.out.print("Enter Product ID to add to the cart: ");
                        int productID = scanner.nextInt();
                        if (productID == 0) {
                            break;
                        }
                        Product product = productCatalog1.getProductByID(productID);
                        if (product != null) {
                            shoppingCart.addProduct(product);
                            System.out.println("Product added to the cart.");
                        } else {
                            System.out.println("Product not found in the catalog.");
                        }
                    }

                    System.out.println("Enter Product ID to remove the product from cart");
                    int productIDs = scanner.nextInt();
                    Product product1 = productCatalog1.getProductByID(productIDs);
                    if (product1 != null) {
                        shoppingCart.removeProduct(product1);
                        System.out.println("Product has been removed");
                    }

                    System.out.println("\nShopping Cart Details:");
                    shoppingCart.displayCartDetails();

                    System.out.println("\nPlacing order from the shopping cart:");
                    for (Product product : shoppingCart.getProducts()) {
                        System.out.print("Enter quantity for Product " + product.getProductID() + ": ");
                        int quantity = scanner.nextInt();
                        if (quantity <= product.getQuantityAvailable()) {
                            product.updateQuantity(quantity);
                            order.addProduct(product, quantity);
                        } else {
                            System.out.println("Not enough quantity available for product: " + product.getProductName());
                        }
                    }

                    System.out.println("\nOrder Details:");
                    order.displayOrderDetails();

                    System.out.println("--------------");

                    break;

                case 2:
                    System.out.println("\nShopping Cart Details:");
                    shoppingCart.displayCartDetails();
                        break;
                case 3:
                    adminPage(scanner,productCatalog1);
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }catch (Exception e) {
            System.out.println("Invalid input format. Please try again.");
            scanner.nextLine();
        }
    }
}


