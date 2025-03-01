package my.app.project.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
@Entity
@Setter
@Getter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String number;
    private String state;
    private String email;
    private String avatarPage;
    @Column(columnDefinition = "jsonb")
    @Convert
    private HashMap<Product, Integer> cart = new HashMap<>();

    public Customer(Long id, String password ,String name, String number, String state, String email, String avatarPage, HashMap<Product, Integer> cart) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.state = state;
        this.email = email;
        this.avatarPage = avatarPage;
        this.cart = cart;
        this.password = password;
    }

    public Customer() {

    }

}
