package br.com.cwi.crescer.aula8.repository;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
    
}
