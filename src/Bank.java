import java.util.*;

public class Bank {
    private Map<String, SavingsAccounts> savingsAccounts = new HashMap<>();
    private Map<String, CheckingAccount> checkingAccounts = new HashMap<>();

    public void addSavingsAccount(SavingsAccounts account) {
        savingsAccounts.put(account.getAccountNumber(), account);
    }

    public void addCheckingAccount(CheckingAccount account) {
        checkingAccounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        if (savingsAccounts.containsKey(accountNumber)) {
            return savingsAccounts.get(accountNumber);
        } else if (checkingAccounts.containsKey(accountNumber)) {
            return checkingAccounts.get(accountNumber);
        }
        return null;
    }

    public Collection<Account> getAllAccounts() {
        List<Account> all = new ArrayList<>();
        all.addAll(savingsAccounts.values());
        all.addAll(checkingAccounts.values());
        return all;
    }
}
