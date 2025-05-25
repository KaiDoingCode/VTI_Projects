import application.PaymentClient;
import application.*;

public class Main {
    public static void main(String[] args) {
        PaymentClient paypalClient = new PaymentClient(new PaypalAdapter("user@example.com"));
        paypalClient.processPayment(100.0);

        PaymentClient stripeClient = new PaymentClient(new StripeAdapter("tok_visa_123456"));
        stripeClient.processPayment(200.0);

        PaymentClient cryptoClient = new PaymentClient(new CryptoAdapter("btc_wallet_xyz"));
        cryptoClient.processPayment(300.0);
    }
}
