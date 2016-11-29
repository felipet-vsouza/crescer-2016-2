package br.com.cwi.crescer.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CURRENCY_EXCHANGE")
public class CurrencyExchange implements Serializable {

    @Basic(optional = false)
    @Lob
    @Column(name = "DT_CURRENCY_EXCHANGE")
    private byte[] dtCurrencyExchange;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VL_RATE")
    private BigDecimal vlRate;

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CURRENCY_EXCHANGE")
    @SequenceGenerator(name = "SEQ_CURRENCY_EXCHANGE", sequenceName = "SEQ_CURRENCY_EXCHANGE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CURRENCY_EXCHANGE")
    private Long idCurrencyExchange;

    public Long getIdCurrencyExchange() {
        return idCurrencyExchange;
    }

    public void setIdCurrencyExchange(Long idCurrencyExchange) {
        this.idCurrencyExchange = idCurrencyExchange;
    }

    public String getDsCoin() {
        return dsCoin;
    }

    public void setDsCoin(String dsCoin) {
        this.dsCoin = dsCoin;
    }

    @Basic(optional = false)
    @Column(name = "DS_COIN")
    private String dsCoin;

    public CurrencyExchange() {
    }

    public byte[] getDtCurrencyExchange() {
        return dtCurrencyExchange;
    }

    public void setDtCurrencyExchange(byte[] dtCurrencyExchange) {
        this.dtCurrencyExchange = dtCurrencyExchange;
    }

    public BigDecimal getVlRate() {
        return vlRate;
    }

    public void setVlRate(BigDecimal vlRate) {
        this.vlRate = vlRate;
    }
}
