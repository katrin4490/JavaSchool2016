package logic;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    @Column(name = "number", unique = true, nullable = false)
    private String number;

    @ManyToOne
    @JoinColumn(name = "idClient", referencedColumnName = "id")
    private Client client;

    @Column(name = "saldo")
    private BigDecimal saldo;

    public Account() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccNumber() {
        return number;
    }

    public void setAccNumber(String accNumber) {
        this.number = accNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setData(String accNumber, Client client, BigDecimal saldo){
        this.number = accNumber;
        this.client = client;
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", accNumber='" + number + '\'' +
                ", client=" + client +
                ", saldo=" + saldo +
                '}';
    }

}