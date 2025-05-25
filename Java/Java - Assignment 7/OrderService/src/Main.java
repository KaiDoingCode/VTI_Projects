import facade.OrderService;

public class Main {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();

        orderService.placeOrder("ITEM123", "CUST456", "123 Main St, Cityville", 99.99);
    }
}
