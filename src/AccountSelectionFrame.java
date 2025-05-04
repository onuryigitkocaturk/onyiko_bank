import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class AccountSelectionFrame extends JFrame {
    public AccountSelectionFrame(Bank bank) {
        setTitle("Select Account");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        Collection<Account> accounts = bank.getAllAccounts();

        if (accounts != null && !accounts.isEmpty()) {
            for (Account account : accounts) {
                String buttonText = account.getAccountNumber() + " (" +
                        account.getClass().getSimpleName() + ") - " +
                        account.getFirstName() + " " + account.getLastName();

                JButton button = new JButton(buttonText);
                button.addActionListener(e -> {
                    if (account != null) {
                        new BankFrame(account);
                        dispose();
                    }
                });

                panel.add(button);
            }
        } else {
            JLabel label = new JLabel("No accounts found.");
            panel.add(label);
        }

        add(panel);
        setVisible(true);
    }
}
