package my.app.project.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cart_id;
    private Long owner_id;
    @OneToOne
    private Customer owner;
    @SuppressWarnings("JpaAttributeTypeInspection")
    private List<Long> product_ids;


    public Cart(Customer owner) {
        this.owner = owner;
        this.owner_id = owner.getId();
        this.product_ids = new ArrayList<>();
    }

    public Cart() {
        this.product_ids = new ArrayList<>();
    }

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }
}
