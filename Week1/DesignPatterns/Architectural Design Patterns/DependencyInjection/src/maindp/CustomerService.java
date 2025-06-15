package maindp;
public class CustomerService {
    private CustomerRepository customerRepository;

//    // Constructor Injection
//    public CustomerService(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public CustomerService(CustomerRepository repo) {
		// TODO Auto-generated constructor stub
    	this.customerRepository = repo;
	}

	public void getCustomerDetails(String customerId) {
        Customer customer = customerRepository.findCustomerById(customerId);
        if (customer != null) {
            System.out.println("Customer Found:");
            System.out.println("ID   : " + customer.getId());
            System.out.println("Name : " + customer.getName());
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
}

