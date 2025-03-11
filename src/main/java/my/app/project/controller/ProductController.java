package my.app.project.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ResponseEntity<String> saveProduct(@RequestParam("product") String productJson, @RequestParam("image") MultipartFile file) {
        if(file.isEmpty()){
            return new ResponseEntity<>("Запрос пустой", HttpStatus.NO_CONTENT);
        }

        try {
            ObjectMapper mapper = new ObjectMapper();
            Product product = mapper.readValue(productJson, Product.class);

            productService.saveProduct(product);
            imageService.save(file);
            return new ResponseEntity<>("Все круто записалось", HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>("Ошибка записи в бд", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}