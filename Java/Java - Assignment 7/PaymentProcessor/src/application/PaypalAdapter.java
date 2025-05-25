package application;

import api.PaypalAPI;
import domain.PaymentProcessor;

public class PaypalAdapter implements PaymentProcessor {
    private PaypalAPI paypal;
    private String userEmail;

    public PaypalAdapter(String userEmail) {
        this.paypal = new PaypalAPI();
        this.userEmail = userEmail;
    }

    @Override
    public void pay(double amount) {
        paypal.sendPayment(userEmail, amount);
    }
}

