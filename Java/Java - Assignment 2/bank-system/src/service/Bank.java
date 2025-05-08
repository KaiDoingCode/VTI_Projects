package service;

import model.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, BankAccount> accounts = new HashMap<>();

    public void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account added: " + account);
    }

    public boolean depositToAccount(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            return true;
        }
        System.out.println("Account not found: " + accountNumber);
        return false;
    }

    public boolean withdrawFromAccount(String accountNumber, double amount) {
        BankAccount account = accounts.get(accountNumber);
        if (account != null) {
            return account.withdraw(amount);
        }
        System.out.println("Account not found: " + accountNumber);
        return false;
    }

    public double getTotalBalance() {
        double total = 0;
        for (BankAccount account : accounts.values()) {
            total += account.getBalance();
        }
        return total;
    }

    public void applyInterestToAllAccounts() {
        System.out.println("\nInterest Summary:");
        for (BankAccount account : accounts.values()) {
            double interest = account.calculateInterest();
            System.out.println("Account " + account.getAccountNumber() + ": Interest = $" + interest);
        }
    }

    public void printAllAccounts() {
        System.out.println("\nAll Accounts:");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
}
