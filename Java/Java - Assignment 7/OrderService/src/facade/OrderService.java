package facade;

import application.*;

public class OrderService {
    private Inventory inventory;
    private PaymentGateway paymentGateway;
    private Shipping shipping;
    private Notification notification;

    public OrderService() {
        this.inventory = new Inventory();
        this.paymentGateway = new PaymentGateway();
        this.shipping = new Shipping();
        this.notification = new Notification();
    }

    public void placeOrder(String itemId, String customerId, String address, double amount) {
        System.out.println("\nPlacing order...");

        if (!inventory.checkStock(itemId)) {
            System.out.println("Item is out of stock.");
            return;
        }

        inventory.reserve(itemId);

        if (!paymentGateway.processPayment(customerId, amount)) {
            System.out.println("Payment failed.");
            return;
        }

        shipping.shipItem(itemId, address);
        notification.sendConfirmation(customerId);

        System.out.println("Order placed successfully!");
    }
}

