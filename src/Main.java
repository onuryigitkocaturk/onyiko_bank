import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Customer ve hesapları
        Customer c1 = new Customer("c1", "1234", "Ali", "Yılmaz");
        c1.addAccount(new SavingsAccounts("1001", 1000, "Ali", "Yılmaz", "1234"));
        c1.addAccount(new CheckingAccount("2001", 2000, "Ali", "Yılmaz", "1234"));

        Customer c2 = new Customer("c2", "5678", "Ayşe", "Demir");
        c2.addAccount(new SavingsAccounts("1002", 1500, "Ayşe", "Demir", "5678"));
        c2.addAccount(new CheckingAccount("2002", 2500, "Ayşe", "Demir", "5678"));

        bank.addCustomer(c1);
        bank.addCustomer(c2);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bank!");

        System.out.print("Customer ID: ");
        String custId = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        Customer currentUser = bank.login(custId, password);
        if (currentUser == null) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        System.out.println("\nLogin successful! Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName());

        while (true) {
            System.out.println("\nYour accounts:");
            for (Account acc : currentUser.getAccounts()) {
                System.out.println("- " + acc.getAccountNumber() + " (" + acc.getClass().getSimpleName() + ")");
            }

            System.out.print("Enter account number to manage (or type 'exit'): ");
            String accNum = scanner.nextLine();
            if (accNum.equalsIgnoreCase("exit")) break;

            Account selectedAccount = currentUser.getAccount(accNum);
            if (selectedAccount != null) {
                manageAccountMenu(selectedAccount, scanner);
            } else {
                System.out.println("Invalid account number.");
            }
        }
    }

    private static void manageAccountMenu(Account account, Scanner scanner) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Managing Account " + account.getAccountNumber() + " ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Calculate Interest");
            System.out.println("5. Back to Customer Menu");
            System.out.print("Your choice: ");

            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1":
                        System.out.println("Balance: $" + account.getBalance());
                        break;
                    case "2":
                        System.out.print("Amount to deposit: ");
                        double dep = Double.parseDouble(scanner.nextLine());
                        account.deposit(dep);
                        System.out.println("Deposit successful. New balance: $" + account.getBalance());
                        break;
                    case "3":
                        System.out.print("Amount to withdraw: ");
                        double wd = Double.parseDouble(scanner.nextLine());
                        account.withdraw(wd);
                        System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
                        break;
                    case "4":
                        account.calculateInterest();
                        break;
                    case "5":
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
