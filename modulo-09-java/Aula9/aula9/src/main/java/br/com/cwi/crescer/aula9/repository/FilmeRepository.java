package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entitites.Filme;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmeRepository extends PagingAndSortingRepository<Filme, Long> {
    
}
