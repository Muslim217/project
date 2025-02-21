package my.app.project.controller;


import my.app.project.model.Product;
import my.app.project.model.Seller;
import my.app.project.service.ProductService;
import my.app.project.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerService service;

    @GetMapping("{idP}")
    public Seller getById(@PathVariable long idP) {
        return service.getById(idP);
    }

    @PostMapping
    public void saveSeller(@RequestBody Seller seller) {
        service.saveSeller(seller);
    }

    @PostMapping("/{id}")
    public void addProductInSeller(
            @PathVariable Long id,
            @RequestBody Product product) {
        Seller seller = service.getById(id);
        seller.getAssortment().add(product);
        service.saveSeller(seller);
    }
}
