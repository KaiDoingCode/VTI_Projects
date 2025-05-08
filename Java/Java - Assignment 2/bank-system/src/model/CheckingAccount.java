package model;

public class CheckingAccount extends BankAccount {
    private final double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= withdrawalLimit && amount <= balance) {
            balance -= amount;
            log("Withdrew $" + amount + " from checking account " + getAccountNumber());
            return true;
        } else {
            log("Failed withdrawal of $" + amount + " from checking account " + getAccountNumber());
            return false;
        }
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest
    }
}
