import java.util.ArrayList;
import java.util.List;

class CustomerStatistics {
    private List<Order> orders;

    public CustomerStatistics() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public double calculateAverageOrderAmount() {
        double totalOrderAmount = 0;
        for (Order order : orders) {
            totalOrderAmount += order.calculateTotalOrderAmount();
        }
        return totalOrderAmount / orders.size();
    }

    public String getHighestSpendingCustomer() {
        String highestSpendingCustomer = "";
        double maxOrderAmount = 0;
        for (Order order : orders) {
            double orderAmount = order.calculateTotalOrderAmount();
            if (orderAmount > maxOrderAmount) {
                maxOrderAmount = orderAmount;
                highestSpendingCustomer = order.customerName;
            }
        }
        return highestSpendingCustomer;
    }

    public void generateCustomerReport() {
        System.out.println("Customer Report:");
        for (Order order : orders) {
            System.out.println("Customer Name: " + order.customerName);
            System.out.println("Total Order Amount: $" + order.calculateTotalOrderAmount());
            System.out.println("--------------");
        }
    }
}
