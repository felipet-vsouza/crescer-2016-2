package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entitites.Idioma;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IdiomaRepository extends PagingAndSortingRepository<Idioma, Long> {
    
}
