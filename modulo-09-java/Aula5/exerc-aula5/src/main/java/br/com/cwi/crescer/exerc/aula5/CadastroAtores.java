package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Ator;
import br.com.cwi.crescer.exerc.aula5.entity.AtorBean;
import br.com.cwi.crescer.exerc.aula5.entity.Elenco;
import br.com.cwi.crescer.exerc.aula5.entity.ElencoBean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroAtores {
    
    @EJB
    private AtorBean atorBean;
    
//    @EJB
//    private ElencoBean elencoBean;
    
    private Ator ator;
    private List<Elenco> elencos;
    
    private List<Ator> atores;
    
    @PostConstruct
    public void init() {
        this.ator = new Ator();
//        this.elencos = elencoBean.findAll();
        this.atores = atorBean.findAll();
    }
    
    public Ator getAtor() {
        return ator;
    }
    
    public void setAtor(Ator ator) {
        this.ator = ator;
    }
    
    public List<Ator> getAtores() {   
        return this.atorBean.findAll();
    }
    
    public void cadastrar() {
        this.atorBean.insert(ator);
//        this.init();
        this.ator = new Ator();
    }
}