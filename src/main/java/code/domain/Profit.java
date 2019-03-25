package code.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Profit")
public class Profit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date data;
    private String payReceive;
    private long idInvoice;
    private float oneProfit;
    private float totalProfit;

    public Profit() {
    }

    public Profit(Date data, String payReceive, long idInvoice, float oneProfit, float totalProfit) {
        this.data = data;
        this.payReceive = payReceive;
        this.idInvoice = idInvoice;
        this.oneProfit = oneProfit;
        this.totalProfit = totalProfit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPayReceive() {
        return payReceive;
    }

    public void setPayReceive(String payReceive) {
        this.payReceive = payReceive;
    }

    public long getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(long idInvoice) {
        this.idInvoice = idInvoice;
    }

    public float getOneProfit() {
        return oneProfit;
    }

    public void setOneProfit(float oneProfit) {
        this.oneProfit = oneProfit;
    }

    public float getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(float totalProfit) {
        this.totalProfit = totalProfit;
    }
}
