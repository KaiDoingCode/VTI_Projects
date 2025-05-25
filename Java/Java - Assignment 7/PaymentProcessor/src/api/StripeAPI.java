package api;

public class StripeAPI {
    public void makePayment(double amount, String cardToken) {
        System.out.println("Stripe: Charged " + amount + " USD using card token " + cardToken);
    }
}
