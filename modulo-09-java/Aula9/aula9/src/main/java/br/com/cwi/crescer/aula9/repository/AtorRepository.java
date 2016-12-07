package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entitites.Ator;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AtorRepository extends PagingAndSortingRepository<Ator, Long> {
    
}
