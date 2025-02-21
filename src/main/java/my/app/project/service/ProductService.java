package my.app.project.service;

import my.app.project.model.Product;
import my.app.project.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository repository;

    public Product getById(long id) {
        return repository.findById(id).get();
    }

    public void saveProduct(Product product) {
        repository.save(product);


    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }
}
