package br.com.cwi.crescer.social.repository;

import br.com.cwi.crescer.social.entity.Usuario;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long> {
    public Usuario findByEmUsuario(String emUsuario);
}
