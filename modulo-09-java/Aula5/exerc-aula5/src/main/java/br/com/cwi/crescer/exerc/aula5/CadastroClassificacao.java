package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Classificacao;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.ejb.EJB;
import br.com.cwi.crescer.exerc.aula5.entity.ClassificacaoBean;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean
@ViewScoped
public class CadastroClassificacao {

    @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
    }

    @EJB
    private ClassificacaoBean classificacaoBean;

    private Classificacao classificacao;

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public List<Classificacao> getClasssificacoes() {
        return classificacaoBean.findAll();
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public void cadastrar() {
        classificacaoBean.insert(classificacao);
        this.init();
    }
}
