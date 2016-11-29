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
    private long idCotacao;

    @Basic(optional = false)
    @Column(name = "DS_COTACAO_DOLLAR_AUSTRALIANO")
    private double dsCotacaoDollarAustraliano;
    
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
