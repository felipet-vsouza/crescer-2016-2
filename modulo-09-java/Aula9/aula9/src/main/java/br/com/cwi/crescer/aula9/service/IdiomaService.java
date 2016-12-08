package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entities.Idioma;
import br.com.cwi.crescer.aula9.repository.IdiomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class IdiomaService {
    @Autowired
    IdiomaRepository repositorio;

    public Page<Idioma> findAll(Pageable pgbl) {
        return repositorio.findAll(pgbl);
    }

    public Iterable<Idioma> findAll() {
        return repositorio.findAll();
    }

    public Idioma save(Idioma i) {
        return repositorio.save(i);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }

    public Idioma findOne(Long id) {
        return repositorio.findOne(id);
    }
}
