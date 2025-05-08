//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.CheckingAccount;
import model.SavingsAccount;
import service.Bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new SavingsAccount("SA1001", "Alice", 5000));
        bank.addAccount(new CheckingAccount("CA1001", "Bob", 3000, 1000));
        bank.addAccount(new SavingsAccount("SA1002", "Charlie", 8000));

        bank.depositToAccount("SA1001", 1000);
        bank.withdrawFromAccount("CA1001", 700);
        bank.withdrawFromAccount("SA1002", 9000); // Should fail

        bank.printAllAccounts();

        bank.applyInterestToAllAccounts();

        System.out.println("\nTotal balance in system: $" + bank.getTotalBalance());
    }
}