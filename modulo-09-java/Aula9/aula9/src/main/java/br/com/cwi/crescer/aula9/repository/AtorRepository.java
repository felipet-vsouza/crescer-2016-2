package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entities.Ator;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AtorRepository extends PagingAndSortingRepository<Ator, Long> {
    
}
