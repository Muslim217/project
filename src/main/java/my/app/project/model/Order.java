package my.app.project.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import my.app.project.enumeration.OrderStatus;

import java.util.Calendar;
import java.util.HashMap;
@Entity
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    private Long customerId;
    private OrderStatus status;
    private Calendar dateOfCreation;
    private Calendar dateOfDelivery;
    @ElementCollection
    @CollectionTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "order_id")})
    @MapKeyColumn(name = "product_id")
    @Column(name = "quantity")
    private HashMap<Product, Integer> productQtyMap;
}