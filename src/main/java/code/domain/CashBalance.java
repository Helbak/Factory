package code.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CashBalance")
public class CashBalance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date data;
    private String payReceive;
    private long idInvoice;
    private float cashBalance;

    public CashBalance() {
    }

    public CashBalance(Date data, String payReceive, long idInvoice, float cashBalance) {
        this.data = data;
        this.payReceive = payReceive;
        this.idInvoice = idInvoice;
        this.cashBalance = cashBalance;
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

    public float getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(float cashBalance) {
        this.cashBalance = cashBalance;
    }
}
