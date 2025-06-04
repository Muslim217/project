package my.app.project.service.impl;

import jakarta.transaction.Transactional;
import my.app.project.model.Product;
import my.app.project.model.Seller;
import my.app.project.repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    private SellerRepository repository;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    public Seller getById(long id) {
        return repository.findById(id).get();
    }

    public void saveSeller(Seller seller) {
        repository.save(seller);
    }

    @Transactional
    public void addProductInSeller(Long id, Product product) {
        Seller seller = repository.findById(id).get();
        productService.saveProduct(product);
        product.setSeller(seller);
        seller.getAssortment().add(product);
        repository.save(seller);
    }

    @Transactional
    public void sellProduct(Long seller_id, Product product , Integer qty) {
        Seller seller = repository.findById(seller_id).get();
        if (productService.getById(product.getId()) != null) {
            product.setQuantity(product.getQuantity() - qty);
            productService.saveProduct(product);
        } else {
            productService.saveProduct(product);
            product.setSeller(seller);
            seller.getAssortment().add(product);
            product.setQuantity(product.getQuantity() - qty);
            repository.save(seller);
            productService.saveProduct(product);
        }
    }

}
