package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Genero;
import br.com.cwi.crescer.exerc.aula5.entity.GeneroBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroGenero {
    
    @PostConstruct
    public void init() {
        this.genero = new Genero();
    }
    
    private Genero genero;

    @EJB
    private GeneroBean generoBean;

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    
    public List<Genero> getGeneros() {
        return generoBean.findAll();
    }

    public void cadastrar() {
        generoBean.insert(genero);
        this.init();
    }
}
