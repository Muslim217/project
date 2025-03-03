package my.app.project.service;

import my.app.project.model.Customer;
import java.util.List;

public interface CustomerService {
    public void save(Customer customer);
    public Customer getCustomer(Long id);
    public List<Customer> getAllCustomers();
    public void deleteCustomer(Long id);
}
