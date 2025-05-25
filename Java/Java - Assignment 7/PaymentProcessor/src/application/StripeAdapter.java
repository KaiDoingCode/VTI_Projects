package application;

import api.StripeAPI;
import domain.PaymentProcessor;

public class StripeAdapter implements PaymentProcessor {
    private StripeAPI stripe;
    private String cardToken;

    public StripeAdapter(String cardToken) {
        this.stripe = new StripeAPI();
        this.cardToken = cardToken;
    }

    @Override
    public void pay(double amount) {
        stripe.makePayment(amount, cardToken);
    }
}

