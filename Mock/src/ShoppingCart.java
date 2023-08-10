import java.util.ArrayList;
import java.util.List;

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }


    public void displayCartDetails() {
        System.out.println("Shopping Cart Details:");
        for (Product product : products) {
            product.displayDetails();
            System.out.println("--------------");
        }
        System.out.println("Total Price: $" + calculateTotalPrice());
    }
}