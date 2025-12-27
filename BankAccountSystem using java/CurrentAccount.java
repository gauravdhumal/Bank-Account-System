public class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void calculateInterest() {
        // No interest for current account
        transactions.add(new Transaction("No Interest (Current Account)", 0));
    }
}
