package br.com.crescer.social.security.service;

import br.com.crescer.social.security.enumeration.SocialRoles;
import br.com.cwi.crescer.social.entity.Usuario;
import br.com.cwi.crescer.social.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class SocialUserDetailsService implements UserDetailsService {

    @Autowired
    UsuarioService service;
    
    private static final String CRESCER = "crescer";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = service.findByEmUsuario(username);
        if (username.isEmpty() || usuario == null) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", username));
        }
        return new User(usuario.getEmUsuario(), usuario.getSnUsuario(), SocialRoles.valuesToList());
    }

}
