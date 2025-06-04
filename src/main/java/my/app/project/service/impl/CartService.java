package my.app.project.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import my.app.project.model.Cart;
import my.app.project.repo.CartRepository;
import my.app.project.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;
    private CustomerService customerRepository;

    public Cart getById(Long id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart not found with ID: " + id));
    }

    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Transactional
    public void addProductToCart(Long cart_id, Long product, int quantity) {
        Cart cart = cartRepository.findById(cart_id).get();
        HashMap<Long, Integer> products = cart.getProducts();
        products.put(product, quantity);

        cartRepository.save(cart);
    }
}


