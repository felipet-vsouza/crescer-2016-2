package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entitites.Elenco;
import br.com.cwi.crescer.aula9.repository.ElencoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ElencoService {
    @Autowired
    ElencoRepository repositorio;

    public Page<Elenco> findAll(Pageable pgbl) {
        return repositorio.findAll(pgbl);
    }

    public Iterable<Elenco> findAll() {
        return repositorio.findAll();
    }

    public Elenco save(Elenco e) {
        return repositorio.save(e);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }

    public Elenco findOne(Long id) {
        return repositorio.findOne(id);
    }
}
