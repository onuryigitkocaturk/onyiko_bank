import javax.swing.*;
import java.awt.event.*;

public class BankFrame extends JFrame {
    private Account account;
    private JLabel balanceLabel;
    private JTextField amountField;

    public BankFrame(Account account) {
        this.account = account;
        setTitle("Bank Account: " + account.getAccountNumber() + " - " + account.getFirstName() + " " + account.getLastName());
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        balanceLabel = new JLabel("Balance: " + account.getBalance());
        amountField = new JTextField(10);
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton interestButton = new JButton("Calculate Interest");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Owner: " + account.getFirstName() + " " + account.getLastName()));
        panel.add(balanceLabel);
        panel.add(new JLabel("Amount:"));
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);
        panel.add(interestButton);

        add(panel);

        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= 0) throw new NumberFormatException("Amount must be positive.");
                account.deposit(amount);
                updateBalance();
                amountField.setText("");
            } catch (Exception ex) {
                showError("Invalid input or operation: " + ex.getMessage());
            }
        });

        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(amountField.getText());
                if (amount <= 0) throw new NumberFormatException("Amount must be positive.");
                account.withdraw(amount);
                updateBalance();
                amountField.setText("");
            } catch (Exception ex) {
                showError("Invalid input or operation: " + ex.getMessage());
            }
        });

        interestButton.addActionListener(e -> {
            account.calculateInterest();
            updateBalance();
        });

        setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: " + account.getBalance());
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
