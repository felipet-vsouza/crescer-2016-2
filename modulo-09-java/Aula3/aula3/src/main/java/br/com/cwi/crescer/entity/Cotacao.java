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
@Table(name = "COTACAO")
public class Cotacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_COTACAO")
    @SequenceGenerator(name = "SEQ_COTACAO", sequenceName = "SEQ_COTACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_COTACAO")
    private Long idCotacao;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO")
    private double dsCotacaoDollarAustraliano;

    public Long getIdCotacao() {
        return idCotacao;
    }

    public void setIdCotacao(Long idCotacao) {
        this.idCotacao = idCotacao;
    }

    public double getDsCotacaoDollarAustraliano() {
        return dsCotacaoDollarAustraliano;
    }

    public void setDsCotacaoDollarAustraliano(double dsCotacaoDollarAustraliano) {
        this.dsCotacaoDollarAustraliano = dsCotacaoDollarAustraliano;
    }

    public double getDsCotacaoDollarCanadense() {
        return dsCotacaoDollarCanadense;
    }

    public void setDsCotacaoDollarCanadense(double dsCotacaoDollarCanadense) {
        this.dsCotacaoDollarCanadense = dsCotacaoDollarCanadense;
    }

    public double getDsCotacaoEuro() {
        return dsCotacaoEuro;
    }

    public void setDsCotacaoEuro(double dsCotacaoEuro) {
        this.dsCotacaoEuro = dsCotacaoEuro;
    }

    public double getDsCotacaoFrancoSuico() {
        return dsCotacaoFrancoSuico;
    }

    public void setDsCotacaoFrancoSuico(double dsCotacaoFrancoSuico) {
        this.dsCotacaoFrancoSuico = dsCotacaoFrancoSuico;
    }

    public double getDsCotacaoLibra() {
        return dsCotacaoLibra;
    }

    public void setDsCotacaoLibra(double dsCotacaoLibra) {
        this.dsCotacaoLibra = dsCotacaoLibra;
    }

    public double getDsCotacaoReal() {
        return dsCotacaoReal;
    }

    public void setDsCotacaoReal(double dsCotacaoReal) {
        this.dsCotacaoReal = dsCotacaoReal;
    }

    public double getDsCotacaoYen() {
        return dsCotacaoYen;
    }

    public void setDsCotacaoYen(double dsCotacaoYen) {
        this.dsCotacaoYen = dsCotacaoYen;
    }

    public double getDsCotacaoYuan() {
        return dsCotacaoYuan;
    }

    public void setDsCotacaoYuan(double dsCotacaoYuan) {
        this.dsCotacaoYuan = dsCotacaoYuan;
    }

    public Date getDtCotacao() {
        return dtCotacao;
    }

    public void setDtCotacao(Date dtCotacao) {
        this.dtCotacao = dtCotacao;
    }
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_CANADENSE")
    private double dsCotacaoDollarCanadense;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_EURO")
    private double dsCotacaoEuro;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_FRANCO_SUICO")
    private double dsCotacaoFrancoSuico;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_LIBRA")
    private double dsCotacaoLibra;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_REAL")
    private double dsCotacaoReal;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YEN")
    private double dsCotacaoYen;
    
    @Basic(optional = false)
    @Column(name = "DS_COTACAO_YUAN")
    private double dsCotacaoYuan;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DT_COTACAO")
    private Date dtCotacao;
}
