package my.app.project.service;

import my.app.project.model.Product;
import my.app.project.model.Seller;
import my.app.project.repo.ProductRepository;
import my.app.project.repo.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {
    @Autowired
    SellerRepository repository;

    public Seller getById(long id) {
        return repository.findById(id).get();
    }

    public void saveSeller(Seller seller) {
        repository.save(seller);


    }
}
