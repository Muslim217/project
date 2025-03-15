package my.app.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;
    private String number;
    private String state;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "customer")
    private List<Cart> carts;
}
