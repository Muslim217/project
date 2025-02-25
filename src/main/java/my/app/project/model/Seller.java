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
    private String number;
    private String mail;
    private String nameOfCompany;
    private String saleArea;//Область продажи
    @OneToMany
    private List<Product> assortment;

}
