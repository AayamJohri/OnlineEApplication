import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class ProductCatalog {
    private Map<Integer, Product> productMap;

    public ProductCatalog() {
        this.productMap = new HashMap<>();


    }

    public void addProduct(Product product) {
        productMap.put(product.getProductID(), product);
    }

    public void removeProduct(int productID) {
        productMap.remove(productID);
    }

    public Product getProductByID(int productID) {
        return productMap.get(productID);
    }
    public Collection<Product> getAllProducts() {
        return productMap.values();


    }
}