package code.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private float purchasePrice;
    private float sellingPrice;
    private float costPrice;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<IncomingInvoice> incomingInvoices= new ArrayList<IncomingInvoice>();
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<SalesInvoice> salesInvoices= new ArrayList<SalesInvoice>();

    public Product() {
    }

    public Product(String name, String producer, String measure, float amount, float purchasePrice, float sellingPrice, float costPrice) {
        this.name = name;
        this.producer = producer;
        this.measure = measure;
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
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

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public List<IncomingInvoice> getIncomingInvoices() {
        return incomingInvoices;
    }

    public void setIncomingInvoices(List<IncomingInvoice> incomingInvoices) {
        this.incomingInvoices = incomingInvoices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", measure='" + measure + '\'' +
                ", amount=" + amount +
                ", purchasePrice=" + purchasePrice +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
