package my.app.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;
    //Тут должен быть image
    private String measure;
    private String quantity;// кол-во
    private String CountryOfOrigin;// страна производитель
    // я не стал добавлять поле еще одно поле характеристики
    // у нас и так есть description
}
