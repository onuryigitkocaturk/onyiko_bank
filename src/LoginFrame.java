import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {
    private Bank bank;

    public LoginFrame(Bank bank) {
        this.bank = bank;

        setTitle("Bank Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField usernameField = new JTextField(15);
        JPasswordField passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("Login");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("kanka") && password.equals("1234")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                dispose();
                new AccountSelectionFrame(bank);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
