public class CheckingAccount extends Account{
    private double overdraftLimit = 500;

    public CheckingAccount(String accountNumber, double balance, String firstName, String lastName, String password){
        super(accountNumber,balance,firstName,lastName,password);
    }

    @Override
    public void calculateInterest(){
        System.out.println("Checking accounts have no interest.");
    }
    @Override
    public void withdraw(double amount) throws InsufficientFundsException,InvalidAmountException{
        if(amount<=0){
            throw new InvalidAmountException("Amount must be greater than zero");
        }
        if(amount > getBalance() + overdraftLimit){
            throw new InsufficientFundsException("Overdraft limit exceeded.");
        }
        double newBalance = getBalance() - amount;
        super.deposit(-amount);
        System.out.println(amount + " withdrawn(with overdraft). New balance: " + getBalance());
    }
}
