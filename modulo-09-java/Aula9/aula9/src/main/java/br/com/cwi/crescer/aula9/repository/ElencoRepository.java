package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entities.Elenco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ElencoRepository extends PagingAndSortingRepository<Elenco, Long> {
    
}
