package my.app.project.controller;


import my.app.project.model.Product;
import my.app.project.model.Seller;
import my.app.project.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping("{id}")
    public ResponseEntity<Seller> getById(@PathVariable long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatusCode.valueOf(200));
    }

    @PostMapping
    public ResponseEntity<Seller> saveSeller(@RequestBody Seller seller) {
        service.saveSeller(seller);
        return ResponseEntity.status(HttpStatus.CREATED).body(seller);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Product> addProductInSeller(
            @PathVariable Long id,
            @RequestBody Product product) {
        service.addProductInSeller(id, product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}
