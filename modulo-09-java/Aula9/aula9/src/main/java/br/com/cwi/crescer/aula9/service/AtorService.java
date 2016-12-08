package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entities.Ator;
import br.com.cwi.crescer.aula9.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AtorService {
    @Autowired
    AtorRepository repositorio;

    public Page<Ator> findAll(Pageable pgbl) {
        return repositorio.findAll(pgbl);
    }

    public Iterable<Ator> findAll() {
        return repositorio.findAll();
    }

    public Ator save(Ator a) {
        return repositorio.save(a);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }

    public Ator findOne(Long id) {
        return repositorio.findOne(id);
    }
}
