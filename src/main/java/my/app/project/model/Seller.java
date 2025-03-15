package my.app.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Data
@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seller_id")
    private Long id;
    @Column(name = "seller_name")
    private String name;
    @OneToMany(mappedBy = "seller")
    private ArrayList<Product> assortment;

}
