package api;

public class PaypalAPI {
    public void sendPayment(String email, double amount) {
        System.out.println("PayPal: Paid " + amount + " USD using " + email);
    }
}

