package my.app.project.service;

import my.app.project.enumeration.OrderStatus;
import my.app.project.model.Customer;
import my.app.project.model.Order;
import my.app.project.model.Product;
import my.app.project.repo.CustomerRepository;
import my.app.project.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
