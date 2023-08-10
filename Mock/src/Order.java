import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Order {
    private double orderID;
    public String customerName;
    private LocalDate orderDate;
    private List<Product> productsOrdered;
    private List<Integer> quantitiesOrdered;

    public Order(int orderID, String customerName, LocalDate orderDate) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.productsOrdered = new ArrayList<>();
        this.quantitiesOrdered = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        productsOrdered.add(product);
        quantitiesOrdered.add(quantity);
    }

    public double calculateTotalOrderAmount() {
        double totalOrderAmount = 0;
        for (int i = 0; i < productsOrdered.size(); i++) {
            Product product = productsOrdered.get(i);
            int quantity = quantitiesOrdered.get(i);
            totalOrderAmount += product.getPrice() * quantity;
        }
        return totalOrderAmount;
    }

    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderID);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Products Ordered:");
        for (int i = 0; i < productsOrdered.size(); i++) {
            Product product = productsOrdered.get(i);
            int quantityOrdered = quantitiesOrdered.get(i);
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity Ordered: " + quantityOrdered);
            System.out.println("--------------");
        }
        System.out.println("Total Order Amount: $" + calculateTotalOrderAmount());

    }

}
