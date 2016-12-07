package br.com.cwi.crescer.aula9.service;

import br.com.cwi.crescer.aula9.entitites.Filme;
import br.com.cwi.crescer.aula9.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmeService {
    @Autowired
    FilmeRepository repositorio;

    public Page<Filme> findAll(Pageable pgbl) {
        return repositorio.findAll(pgbl);
    }

    public Iterable<Filme> findAll() {
        return repositorio.findAll();
    }

    public Filme save(Filme f) {
        return repositorio.save(f);
    }

    public void delete(Long id) {
        repositorio.delete(id);
    }

    public Filme findOne(Long id) {
        return repositorio.findOne(id);
    }
}
