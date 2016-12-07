package br.com.cwi.crescer.aula9.controller;

import br.com.cwi.crescer.aula9.entities.Classificacao;
import br.com.cwi.crescer.aula9.service.ClassificacaoService;
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
@RequestMapping("/classificacao")
public class ClassificacaoController {
    
    @Autowired
    ClassificacaoService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Classificacao classificacao = new Classificacao();
        if (id != null) {
            classificacao = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("classificacao", classificacao);
        model.addAttribute("classificacoes", service.findAll(pageable));
        return "classificacao";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Classificacao classificacao, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("msg", "Registro salvo com sucesso!");
            service.save(classificacao);
            return "redirect:classificacao";
        }
        return "classificacao";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Classificacao> classificacoes = service.findAll(pageable);
        model.addAttribute("classificacoes", classificacoes);
        return "classificacao";
    }
}
