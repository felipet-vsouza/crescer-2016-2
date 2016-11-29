package br.com.cwi.crescer.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICO")
public class Servico implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_SERVICO")
    @SequenceGenerator(name = "SEQ_SERVICO", sequenceName = "SEQ_SERVICO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_SERVICO")
    private long idServico;
    
    @Basic(optional = false)
    @Column(name = "DS_DESCRICAO")
    private String dsDescricao;

    public long getIdServico() {
        return idServico;
    }

    public void setIdServico(long idServico) {
        this.idServico = idServico;
    }

    public String getDsDescricao() {
        return dsDescricao;
    }

    public void setDsDescricao(String dsDescricao) {
        this.dsDescricao = dsDescricao;
    }

    public String getDsPeriodicidade() {
        return dsPeriodicidade;
    }

    public void setDsPeriodicidade(String dsPeriodicidade) {
        this.dsPeriodicidade = dsPeriodicidade;
    }

    public String getDsSimboloMoeda() {
        return dsSimboloMoeda;
    }

    public void setDsSimboloMoeda(String dsSimboloMoeda) {
        this.dsSimboloMoeda = dsSimboloMoeda;
    }

    public String getDsSituacao() {
        return dsSituacao;
    }

    public void setDsSituacao(String dsSituacao) {
        this.dsSituacao = dsSituacao;
    }

    public String getDsWebsite() {
        return dsWebsite;
    }

    public void setDsWebsite(String dsWebsite) {
        this.dsWebsite = dsWebsite;
    }

    public String getNmServico() {
        return nmServico;
    }

    public void setNmServico(String nmServico) {
        this.nmServico = nmServico;
    }

    public double getVlMensalUsd() {
        return vlMensalUsd;
    }

    public void setVlMensalUsd(double vlMensalUsd) {
        this.vlMensalUsd = vlMensalUsd;
    }

    public double getVlTotalServico() {
        return vlTotalServico;
    }

    public void setVlTotalServico(double vlTotalServico) {
        this.vlTotalServico = vlTotalServico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Basic(optional = false)
    @Column(name = "DS_PERIODICIDADE")
    private String dsPeriodicidade;
    
    @Basic(optional = false)
    @Column(name = "DS_SIMBOLO_MOEDA")
    private String dsSimboloMoeda;
    
    @Basic(optional = false)
    @Column(name = "DS_SITUACAO")
    private String dsSituacao;
    
    @Basic(optional = false)
    @Column(name = "DS_WEBSITE")
    private String dsWebsite;
    
    @Basic(optional = false)
    @Column(name = "NM_SERVICO")
    private String nmServico;
    
    @Basic(optional = false)
    @Column(name = "VL_MENSAL_USD")
    private double vlMensalUsd;
    
    @Basic(optional = false)
    @Column(name = "VL_TOTAL_SERVICO")
    private double vlTotalServico;
    
    @ManyToOne
    @JoinColumn(name = "USUARIO_ID_USUARIO")
    private Usuario usuario;
}
