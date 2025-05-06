import java.util.*;

public class Bank {
    private Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        customers.put(customer.getCustomerId(), customer);
    }

    public Customer login(String customerId, String password) {
        Customer cust = customers.get(customerId);
        if (cust != null && cust.getPassword().equals(password)) {
            return cust;
        }
        return null;
    }
}
