public interface Transferable {
    void transfer(Account toAccount, double amount) throws InsufficientFundsException,InvalidAmountException;
}
