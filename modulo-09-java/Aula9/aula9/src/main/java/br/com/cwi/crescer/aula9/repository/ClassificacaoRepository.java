package br.com.cwi.crescer.aula9.repository;

import br.com.cwi.crescer.aula9.entitites.Classificacao;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClassificacaoRepository extends PagingAndSortingRepository<Classificacao, Long> {
    
}
