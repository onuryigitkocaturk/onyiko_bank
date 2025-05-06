import java.util.*;

public class Customer {
    private String customerId;
    private String password;
    private String firstName;
    private String lastName;
    private Map<String, Account> accounts = new HashMap<>();

    public Customer(String customerId, String password, String firstName, String lastName) {
        this.customerId = customerId;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getCustomerId() { return customerId; }
    public String getPassword() { return password; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Collection<Account> getAccounts() {
        return accounts.values();
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}
