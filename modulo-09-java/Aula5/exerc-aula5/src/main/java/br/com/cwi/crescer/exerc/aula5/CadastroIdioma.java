package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Idioma;
import br.com.cwi.crescer.exerc.aula5.entity.IdiomaBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroIdioma {

    @PostConstruct
    public void init() {
        this.idioma = new Idioma();
    }

    private Idioma idioma;

    @EJB
    private IdiomaBean idiomaBean;

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma genero) {
        this.idioma = genero;
    }

    public List<Idioma> getIdiomas() {
        return idiomaBean.findAll();
    }

    public void cadastrar() {
        idiomaBean.insert(idioma);
        this.init();
    }
}
