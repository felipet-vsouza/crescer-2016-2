package br.com.cwi.crescer.aula9.rest;

import br.com.cwi.crescer.aula9.entities.Elenco;
import br.com.cwi.crescer.aula9.service.ElencoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/index")
public class IndexRest {
    
    @Autowired
    ElencoService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Elenco> elencos = service.findAll(pageable);
        model.addAttribute("elencos", elencos);
        return "elenco";
    }
}
