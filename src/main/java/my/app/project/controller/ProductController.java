package my.app.project.controller;

import my.app.project.model.Image;
import my.app.project.model.Product;
import my.app.project.service.ImageService;
import my.app.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ImageService imageService;

    @GetMapping("{idP}")
    public Product getById(@PathVariable long idP) {
        return productService.getById(idP);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity(productService.getAllProduct(), HttpStatus.OK);
    }

    @PostMapping
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);

    }
}
