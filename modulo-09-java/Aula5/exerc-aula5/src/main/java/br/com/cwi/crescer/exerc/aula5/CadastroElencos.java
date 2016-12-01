package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Ator;
import br.com.cwi.crescer.exerc.aula5.entity.Elenco;
import br.com.cwi.crescer.exerc.aula5.entity.ElencoBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class CadastroElencos {
    
    @EJB
    private ElencoBean elencoBean;

    private Elenco elenco;
    
    @PostConstruct
    public void init() {
        this.elenco = new Elenco();
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }
    
    public List<Elenco> getElencos() {
        List<Elenco> l =  elencoBean.findAll();
        return l;
    }
    
    public void cadastrar() {
        this.elencoBean.insert(elenco);
        this.init();
    }
}
