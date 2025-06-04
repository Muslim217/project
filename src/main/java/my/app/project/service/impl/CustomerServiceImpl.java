package my.app.project.service.impl;

import my.app.project.model.Customer;
import my.app.project.model.Product;
import my.app.project.repo.CustomerRepository;
import my.app.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository repo;
    @Autowired
    OrderService orderService;

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

    @Override
    public void createNewOrder(Long customerId, HashMap<Product, Integer> orderList) {
        orderService.createOrder(customerId, orderList);
    }

}
