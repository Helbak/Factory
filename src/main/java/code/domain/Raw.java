package code.domain;

import javax.persistence.*;

@Entity
@Table(name = "Raws")
public class Raw {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String producer;
    private String measure;
    private float amount;
    private float purchasePrice;
    private float costPrice;

    public Raw() {
    }

    public Raw(String name, String producer, String measure, float amount, float purchasePrice, float costPrice) {
        this.name = name;
        this.producer = producer;
        this.measure = measure;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.costPrice = costPrice;
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

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }
}
