package model;

public class SavingsAccount extends BankAccount {
    private final double interestRate = 0.03; // 3%

    public SavingsAccount(String accountNumber, String ownerName, double balance) {
        super(accountNumber, ownerName, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
}
