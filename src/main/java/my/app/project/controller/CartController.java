package my.app.project.controller;

import jakarta.persistence.EntityNotFoundException;
import my.app.project.model.Cart;
import my.app.project.model.Product;
import my.app.project.service.CartService;
import my.app.project.service.CustomerService;
import my.app.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long id) {
        return ResponseEntity.ok(cartService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        cartService.saveCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(cart);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Cart> addProductToCart(
            @PathVariable Long cartId,
            @RequestBody HashMap<String, Integer> productQuantityMap)
    {

        Cart updatedCart = cartService.getById(cartId);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedCart);
    }
}



