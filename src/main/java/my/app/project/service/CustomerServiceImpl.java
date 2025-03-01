package my.app.project.service;

import my.app.project.model.Customer;
import my.app.project.model.Product;
import my.app.project.repo.CustomerRepository;
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

    @Override
    public void addProductToCart(Long cust_id, Product prod, int quantity) {
        Customer customer = repo.findById(cust_id).get();
        HashMap<Product, Integer> cart = customer.getCart();
        cart.put(prod, quantity);
        customer.setCart(cart);
        repo.save(customer);
    }

    @Override
    public void deleteProductFromCart(Long cust_id, Long prod_id, int quantity) {

    }
}
