package model;

public abstract class BankAccount implements Loggable {
    private String accountNumber;
    private String ownerName;
    protected double balance;

    public BankAccount(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            log("Deposited $" + amount + " into account " + accountNumber);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            log("Withdrew $" + amount + " from account " + accountNumber);
            return true;
        } else {
            log("Failed withdrawal of $" + amount + " from account " + accountNumber);
            return false;
        }
    }

    public abstract double calculateInterest();

    @Override
    public String toString() {
        return "Account[" + accountNumber + "] - Owner: " + ownerName + ", Balance: $" + balance;
    }
}
