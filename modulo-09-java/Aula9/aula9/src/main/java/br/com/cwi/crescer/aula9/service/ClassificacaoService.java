package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entitites.Classificacao;
import br.com.cwi.crescer.aula9.repository.ClassificacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClassificacaoService {
    @Autowired
    ClassificacaoRepository repositorio;

    public Page<Classificacao> findAll(Pageable pgbl) {
        return repositorio.findAll(pgbl);
    }

    public Iterable<Classificacao> findAll() {
        return repositorio.findAll();
    }

    public Classificacao save(Classificacao c) {
        return repositorio.save(c);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }

    public Classificacao findOne(Long id) {
        return repositorio.findOne(id);
    }
}
