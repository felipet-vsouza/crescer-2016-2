package br.com.cwi.crescer.exerc.aula5;

import br.com.cwi.crescer.exerc.aula5.entity.UsuarioBean;
import static br.com.cwi.crescer.exerc.aula5.utils.UserDetails.USER_AUTH;

import br.com.cwi.crescer.exerc.aula5.filters.User;
import br.com.cwi.crescer.exerc.aula5.infraestrutura.ServicoDeCriptografia;
import br.com.cwi.crescer.exerc.aula5.utils.FacesUtils;
import br.com.cwi.crescer.exerc.aula5.utils.UserDetails;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class Login implements Serializable {

    @EJB
    UsuarioBean usuarioBean;

    private User user;

    @PostConstruct
    public void init() {
        this.user = new User();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLoggedUsername() {
        final UserDetails userDetails;
        userDetails = (UserDetails) FacesUtils.getSession().getAttribute(USER_AUTH);
        return userDetails == null ? null : userDetails.getUsername();
    }

    public String login() {
        try {
            final String cripto = ServicoDeCriptografia.criptografar(user.getPassword());
            if (usuarioBean.findAll().stream().anyMatch(
                    u -> u.getEmail().equals(user.getEmail())
                    && u.getSenha().equals(cripto)
            )) {
                FacesUtils.getSession().setAttribute(USER_AUTH, this.user);
                return "filme";
            } else {
                FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "E-mail ou senha não cadastrados.", ""));
                return "login";
            }
        } catch (Exception e) {
                FacesUtils.addMessage(new FacesMessage(FacesMessage.SEVERITY_ERROR,
                        "Erro na autorização de login.", ""));
                return "login";
        }
    }

    public String logout() {
        FacesUtils.getSession().invalidate();
        return "login";
    }
}
