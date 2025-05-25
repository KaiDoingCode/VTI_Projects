package application;

import domain.PaymentProcessor;

public class PaymentClient {
    private PaymentProcessor paymentProcessor;

    public PaymentClient(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment(double amount) {
        paymentProcessor.pay(amount);
    }
}

