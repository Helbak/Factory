package code.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "IncomingInvoices")
public class IncomingInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private Date data;
    private float sellingPrice;
    private float plusAmount;

    public IncomingInvoice() {
    }

    public IncomingInvoice(Product product, Date data, float sellingPrice, float plusAmount) {
        this.product = product;
        this.data = data;
        this.sellingPrice = sellingPrice;
        this.plusAmount = plusAmount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getPlusAmount() {
        return plusAmount;
    }

    public void setPlusAmount(float plusAmount) {
        this.plusAmount = plusAmount;
    }
}
