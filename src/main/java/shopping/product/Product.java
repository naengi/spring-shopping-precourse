package shopping.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageUrl;
    private int price;

    protected Product() {
    }

    public Product(String name, int price, String imageUrl) {
        this.name = new ProductName(name).getValue();
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public void update(String name, int price, String imageUrl) {
        this.name = new ProductName(name).getValue();
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

}
