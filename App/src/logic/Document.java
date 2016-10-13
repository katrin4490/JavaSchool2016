package logic;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "documents")
public class Document implements Serializable{
    private long id;
    private Account accDT;
    private Account accCT;
    private BigDecimal summa;
    private String purpose;
    private Date date;

    public Document() {
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @JoinColumn(name = "acc_dt")
    @ManyToOne
    public Account getAccDT() {
        return accDT;
    }

    public void setAccDT(Account accDT) {
        this.accDT = accDT;
    }

    @JoinColumn(name = "acc_ct")
    @ManyToOne
    public Account getAccCT() {
        return accCT;
    }

    public void setAccCT(Account accCT) {
        this.accCT = accCT;
    }

    public BigDecimal getSumma() {
        return summa;
    }

    public void setSumma(BigDecimal summa) {
        this.summa = summa;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    @Column(name = "data")
    public Date getDate() {
        return new Date(date.getTime());
    }

    public void setDate(Date date) {
        this.date = new Date(date.getTime());
    }

    @Override
    public String toString() {
        return "{ Document : " +
                " { Client : { name : " + accDT.getClient().getName() + " }, " +
                " { acc_num : " + accDT.getAccNum() + " }, " +
                " { type : DT }, { summa : " + this.getSumma() + " }, { saldo : " + accDT.getSaldo() + " } }," +
                " { Client : { name : " + accCT.getClient().getName() + " }, " +
                " { acc_num : " + accCT.getAccNum() + " }, " +
                " { type : CT }, { summa : " + this.getSumma() + " }, { saldo : " + accCT.getSaldo() + " } }";
    }

    @Transactional
    public void exec(){
        if (validData()){
            accDT.setSaldo(accDT.getSaldo().add(summa.negate()));
            accCT.setSaldo(accCT.getSaldo().add(summa));
        }
    }

    private boolean validData(){
        boolean result = false;
        if (accDT != null) result = true;
        if (accCT != null) result = true;
        if (accDT.getSaldo().compareTo(summa) != -1) result = true;
        return result;
    }


}