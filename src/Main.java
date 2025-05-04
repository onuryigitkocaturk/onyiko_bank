public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addSavingsAccount(new SavingsAccounts("SA123", 1000, "Ali", "Yılmaz"));
        bank.addCheckingAccount(new CheckingAccount("CA123", 500, "Ali", "Yılmaz"));
        bank.addSavingsAccount(new SavingsAccounts("SA456", 2000, "Ayşe", "Kara"));
        bank.addCheckingAccount(new CheckingAccount("CA456", 1000, "Ayşe", "Kara"));

        new LoginFrame(bank);
    }
}
