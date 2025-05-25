package api;

public class CryptoAPI {
    public void transferCrypto(String walletAddress, double amountInBTC) {
        System.out.println("Crypto: Transferred " + amountInBTC + " BTC to " + walletAddress);
    }
}

