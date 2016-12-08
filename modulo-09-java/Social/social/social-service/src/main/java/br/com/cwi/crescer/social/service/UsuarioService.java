package br.com.cwi.crescer.social.service;

import br.com.cwi.crescer.social.entity.Usuario;
import br.com.cwi.crescer.social.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioService {
    
    @Autowired
    UsuarioRepository repository;
    
    public Usuario findByEmUsuario(String emUsuario) {
        return repository.findByEmUsuario(emUsuario);
    }
    
    public void save(Usuario usuario) {
        repository.save(usuario);
    }
}
