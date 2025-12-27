import java.util.ArrayList;

public abstract class BankAccount {
    protected String accountNumber;
    protected double balance;
    protected ArrayList<Transaction> transactions = new ArrayList<>();

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        transactions.add(new Transaction("Account Created", balance));
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
        }
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public abstract void calculateInterest();
}
