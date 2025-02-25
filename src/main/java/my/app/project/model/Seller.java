package my.app.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany
    private List<Product> assortment;
 //Рамзан лох
}
