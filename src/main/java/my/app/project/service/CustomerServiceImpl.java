package my.app.project.service;

import my.app.project.model.Customer;
import my.app.project.model.Product;
import my.app.project.repo.CustomerRepository;
import my.app.project.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository repo;

    @Override
    public void save(Customer customer) {
        repo.save(customer);
    }

    @Override
    public Customer getCustomer(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Override
    public void deleteCustomer(Long id) {
        repo.deleteById(id);
    }
}
