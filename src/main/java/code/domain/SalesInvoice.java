package code.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SalesInvoices")
public class SalesInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;
    private Date data;
    private float salesAmount;

    public SalesInvoice() {
    }

    public SalesInvoice(Product product, Date data, float salesAmount) {
        this.product = product;
        this.data = data;
        this.salesAmount = salesAmount;
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

    public float getSalesAmount() {
        return salesAmount;
    }

    public void setSalesAmount(float salesAmount) {
        this.salesAmount = salesAmount;
    }
}
