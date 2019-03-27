package code.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RawInvoices")
public class RawInvoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Raw raw;

    private Date data;
    private float purchasePrice;
    private float plusAmount;

    public RawInvoice() {
    }

    public RawInvoice(Raw raw, Date data, float purchasePrice, float plusAmount) {
        this.raw = raw;
        this.data = data;
        this.purchasePrice = purchasePrice;
        this.plusAmount = plusAmount;
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Raw getRaw() {
        return raw;
    }

    public void setRaw(Raw raw) {
        this.raw = raw;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public float getPlusAmount() {
        return plusAmount;
    }

    public void setPlusAmount(float plusAmount) {
        this.plusAmount = plusAmount;
    }
}
