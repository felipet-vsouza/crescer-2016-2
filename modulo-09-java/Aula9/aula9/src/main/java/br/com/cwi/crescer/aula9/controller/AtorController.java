package br.com.cwi.crescer.aula9.controller;

import br.com.cwi.crescer.aula9.service.AtorService;
import br.com.cwi.crescer.aula9.entities.Ator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ator")
public class AtorController {
    
    @Autowired
    AtorService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Ator ator = new Ator();
        if (id != null) {
            ator = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("ator", ator);
        model.addAttribute("atores", service.findAll(pageable));
        return "ator";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Ator ator, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(ator);
            return "redirect:ator";
        }
        return "ator";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Ator> ator = service.findAll(pageable);
        model.addAttribute("atores", ator);
        return "ator";
    }
}
