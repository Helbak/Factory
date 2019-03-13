package code.domain;

import javax.persistence.*;

@Entity
@Table(name = "Products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String producer;
    private String measure;
    private float amount;
    private float price;

    public Product() {
    }

    public Product(String name, String producer, String measure, float amount, float price) {
        this.name = name;
        this.producer = producer;
        this.measure = measure;
        this.amount = amount;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", measure='" + measure + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
