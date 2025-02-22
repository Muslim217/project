package my.app.project.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String number;
    private String state;
    private String email;
    @OneToOne
    private Cart cart;
    private String avatarPage;

    public Customer(Long id, String name, String number, String state, String email, Cart cart, String avatarPage) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.state = state;
        this.email = email;
        this.cart = new Cart(this);
        this.avatarPage = avatarPage;
    }

    public Customer() {
        this.cart = new Cart(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getAvatarPage() {
        return avatarPage;
    }

    public void setAvatarPage(String avatarPage) {
        this.avatarPage = avatarPage;
    }
}
