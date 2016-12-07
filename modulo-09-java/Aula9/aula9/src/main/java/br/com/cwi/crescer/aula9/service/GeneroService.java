package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entities.Genero;
import br.com.cwi.crescer.aula9.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository repositorio;

    public Page<Genero> findAll(Pageable pgbl) {
        return repositorio.findAll(pgbl);
    }

    public Iterable<Genero> findAll() {
        return repositorio.findAll();
    }

    public Genero save(Genero g) {
        return repositorio.save(g);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }

    public Genero findOne(Long id) {
        return repositorio.findOne(id);
    }
}
