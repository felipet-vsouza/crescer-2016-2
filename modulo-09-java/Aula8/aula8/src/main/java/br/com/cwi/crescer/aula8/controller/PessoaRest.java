package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaRest {

    @Autowired
    PessoaService service;

    @ResponseBody
    @RequestMapping(value = "/pessoa", method = RequestMethod.GET)
    public Iterable<Pessoa> pessoa() {
        return service.listAll();
    }
    
    @ResponseBody
    @RequestMapping(value = "/pessoa", method = RequestMethod.POST)
    public Iterable<Pessoa> pessoa(@RequestBody Pessoa p) {
        p.setDtNascimento(new Date());
        service.add(p);
        return service.listAll();
    }
}
