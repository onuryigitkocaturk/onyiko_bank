public class SavingsAccounts extends Account {
    private double interestRate = 0.03;

    public SavingsAccounts(String accountNumber, double balance, String firstName, String lastName) {
        super(accountNumber, balance, firstName, lastName);
    }

    @Override
    public void calculateInterest() {
        double interest = getBalance() * interestRate;
        System.out.println("Savings account interest: " + interest);
    }
}
