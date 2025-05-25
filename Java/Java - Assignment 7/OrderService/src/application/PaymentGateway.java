package application;

public class PaymentGateway {
    public boolean processPayment(String customerId, double amount) {
        System.out.println("Processing payment for customer: " + customerId + ", amount: $" + amount);
        return true;
    }
}
