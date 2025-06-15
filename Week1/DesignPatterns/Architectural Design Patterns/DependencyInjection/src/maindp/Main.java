package maindp;

public class Main {
    public static void main(String[] args) {
        // Dependency creation
        CustomerRepository repo = new CustomerRepositoryImpl();

        // Injecting dependency via constructor
        CustomerService service = new CustomerService(repo);

        // Using the service
        service.getCustomerDetails("C001");
        service.getCustomerDetails("C003"); // Not existing
    }
}
