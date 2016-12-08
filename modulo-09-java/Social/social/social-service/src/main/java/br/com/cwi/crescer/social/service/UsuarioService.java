package br.com.cwi.crescer.social.service;

import br.com.cwi.crescer.social.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioService extends PagingAndSortingRepository<Usuario, Long> {
    public Usuario findByEmUsuario(String emUsuario);
}
