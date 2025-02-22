package my.app.project.repo;

import my.app.project.model.Customer;
import my.app.project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
