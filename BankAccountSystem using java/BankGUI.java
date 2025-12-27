import javax.swing.*;

public class BankGUI {
    private BankAccount account;

    public BankGUI() {
        JFrame frame = new JFrame("Bank Account System");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] options = {"Savings Account", "Current Account"};
        int choice = JOptionPane.showOptionDialog(
                frame,
                "Select Account Type",
                "Account Type",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            account = new SavingsAccount("SA123", 1000);
        } else {
            account = new CurrentAccount("CA123", 1000);
        }

        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton interestBtn = new JButton("Calculate Interest");
        JButton historyBtn = new JButton("Transaction History");
        JButton balanceBtn = new JButton("Check Balance");

        JPanel panel = new JPanel();
        panel.add(depositBtn);
        panel.add(withdrawBtn);
        panel.add(interestBtn);
        panel.add(historyBtn);
        panel.add(balanceBtn);

        frame.add(panel);
        frame.setVisible(true);

        depositBtn.addActionListener(e -> {
            double amt = Double.parseDouble(JOptionPane.showInputDialog("Enter amount"));
            account.deposit(amt);
        });

        withdrawBtn.addActionListener(e -> {
            double amt = Double.parseDouble(JOptionPane.showInputDialog("Enter amount"));
            account.withdraw(amt);
        });

        interestBtn.addActionListener(e -> account.calculateInterest());

        balanceBtn.addActionListener(e ->
                JOptionPane.showMessageDialog(frame, "Balance: " + account.getBalance()));

        historyBtn.addActionListener(e -> {
            StringBuilder history = new StringBuilder();
            for (Transaction t : account.getTransactions()) {
                history.append(t).append("\n");
            }
            JOptionPane.showMessageDialog(frame, history.toString());
        });
    }

    public static void main(String[] args) {
        new BankGUI();
    }
}

