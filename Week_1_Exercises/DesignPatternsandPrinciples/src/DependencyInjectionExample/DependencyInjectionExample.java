package DependencyInjectionExample;

interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        return "Customer with ID " + id;
    }
}

class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomer(int id) {
        return customerRepository.findCustomerById(id);
    }
}

public class DependencyInjectionExample {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        CustomerService customerService = new CustomerService(customerRepository);

        String customerDetails = customerService.getCustomer(1);
        System.out.println(customerDetails);
    }
}
