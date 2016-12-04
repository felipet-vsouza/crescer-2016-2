package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.Usuario;
import br.com.cwi.crescer.exerc.aula5.entity.UsuarioBean;
import br.com.cwi.crescer.exerc.aula5.infraestrutura.ServicoDeCriptografia;
import br.com.cwi.crescer.exerc.aula5.utils.FacesUtils;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CadastroUsuario {

    @PostConstruct
    public void init() {
        this.usuario = new Usuario();
    }

    private Usuario usuario;

    @EJB
    private UsuarioBean usuarioBean;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarioBean.findAll();
    }

    public void cadastrar() {
        try {
            String criptografada = ServicoDeCriptografia.criptografar(usuario.getSenha());
            usuario.setSenha(criptografada);
            boolean existe = usuarioBean.findAll()
                    .stream()
                    .anyMatch(user -> user.getEmail().equals(usuario.getEmail()));
            if (existe) {
                FacesMessage err = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        String.format("O email %s já foi cadastrado.",
                                usuario.getEmail()), "");
                FacesUtils.addMessage(err);
            } else {
                usuarioBean.insert(usuario);
            }
            this.init();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            System.err.println("Problema no processo de cadastro do usuário.");
        }
    }
}
