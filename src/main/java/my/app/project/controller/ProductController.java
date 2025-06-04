package my.app.project.controller;

import my.app.project.model.Product;
import my.app.project.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("{idP}")
    public Product getById(@PathVariable long idP) {
        return service.getById(idP);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity(service.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }
}
