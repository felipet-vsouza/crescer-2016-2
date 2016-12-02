package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Filme;
import br.com.cwi.crescer.exerc.aula5.entity.FilmeBean;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroFilmes {

    @EJB
    private FilmeBean filmeBean;

    private Filme filme;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
    }

    public Filme getFilme() {
        return filme;
    }

    public void setElenco(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        List<Filme> l = filmeBean.findAll();
        return l;
    }

    public void cadastrar() {
        this.filmeBean.insert(filme);
        this.init();
    }
}
