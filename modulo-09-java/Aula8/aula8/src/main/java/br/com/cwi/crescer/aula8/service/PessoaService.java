package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoas;
    
    public Iterable<Pessoa> listAll() {
        return pessoas.findAll();
    }
    
    public Iterable<Pessoa> add(Pessoa p) {
        this.pessoas.save(p);
        return pessoas.findAll();
    }
}
