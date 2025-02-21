package my.app.project.service;

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
        seller.getAssortment().add(product);
        repository.save(seller);
    }
}
