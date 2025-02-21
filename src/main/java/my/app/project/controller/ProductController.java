package my.app.project.controller;

import my.app.project.model.Product;
import my.app.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("{idP}")
    public Product getById(@PathVariable long idP) {
        return service.getById(idP);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }
}
