package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entities.Genero;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneroRepository extends PagingAndSortingRepository<Genero, Long> {
    
}
