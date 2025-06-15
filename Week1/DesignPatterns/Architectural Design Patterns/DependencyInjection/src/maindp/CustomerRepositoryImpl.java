package maindp;
import java.util.*;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Sample customers
        database.put("C001", new Customer("C001", "Dasta"));
        database.put("C002", new Customer("C002", "Giri"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}
