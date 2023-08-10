class Product {
    private int productID;
    private String productName;
    private double price;
    private int quantityAvailable;

    public Product(int productID, String productName, double price, int quantityAvailable) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void updateQuantity(int quantityPurchased) {
        this.quantityAvailable -= quantityPurchased;
    }

    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity Available: " + quantityAvailable);
    }


}
