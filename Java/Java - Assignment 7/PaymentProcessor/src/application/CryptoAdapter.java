package application;

import api.CryptoAPI;
import domain.PaymentProcessor;

public class CryptoAdapter implements PaymentProcessor {
    private CryptoAPI crypto;
    private String walletAddress;

    public CryptoAdapter(String walletAddress) {
        this.crypto = new CryptoAPI();
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        double btcRate = 0.000025; // For example purposes
        double amountInBTC = amount * btcRate;
        crypto.transferCrypto(walletAddress, amountInBTC);
    }
}
