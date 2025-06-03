package my.app.project.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Data
@Entity
@Table(name = "carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cart_id;
    @ManyToOne(cascade = CascadeType.ALL) // Добавьте CascadeType.ALL
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ElementCollection
    @CollectionTable(name = "cart_product", joinColumns = {@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")})
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private HashMap<Long, Integer> products;
}
