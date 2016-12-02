package br.com.cwi.crescer.exerc.aula5.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSIFICAO")
public class Classificacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASSIFICACAO")
    @SequenceGenerator(name = "SEQ_CLASSIFICACAO", sequenceName = "SEQ_CLASSIFICACAO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLASSIFICACAO")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Basic(optional = false)
    @Column(name = "DS_CLASSIFICACAO")
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Basic(optional = true)
    @Column(name = "NM_IDADE")
    private Integer idade;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    @Override
    public boolean equals(Object outro) {
        if(!(outro instanceof Classificacao)) return false;
        Classificacao outraClassificacao = (Classificacao) outro;
        if(!outraClassificacao.getDescricao().equals(this.descricao)) return false;
        if(!outraClassificacao.getId().equals(this.id)) return false;
        if(outraClassificacao.getIdade() != null && 
                !outraClassificacao.getIdade().equals(this.idade)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.descricao);
        hash = 79 * hash + Objects.hashCode(this.idade);
        return hash;
    }
}
