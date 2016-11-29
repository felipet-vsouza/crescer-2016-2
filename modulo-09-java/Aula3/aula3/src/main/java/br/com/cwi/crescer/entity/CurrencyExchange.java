package br.com.cwi.crescer.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCY_EXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCY_EXCHANGE", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private long idCurrencyExchange;

    public long getIdCurrencyExchange() {
        return idCurrencyExchange;
    }

    public void setIdCurrencyExchange(long idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    public Date getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(Date dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public double getVlRate() {
        return vlRate;
    }

    public void setVlRate(double vlRate) {
        this.vlRate = vlRate;
    }

    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_CURRENCY_EXCHANGE")
    private Date dtCurrencyExchange;

    @Basic(optional = false)
    @Column(name = "VL_RATE")
    private double vlRate;
}
