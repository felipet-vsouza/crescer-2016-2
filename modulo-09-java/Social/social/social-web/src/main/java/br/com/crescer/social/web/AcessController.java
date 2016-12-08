package br.com.crescer.social.web;

import br.com.cwi.crescer.social.entity.Usuario;
import br.com.cwi.crescer.social.service.UsuarioService;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
public class AcessController {

    @Autowired
    UsuarioService service;
    
    @RequestMapping("/login")
    String login(User user) {
        return "login"; 
    } 
    
    @RequestMapping("/logout")
    String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:login";
    } 
    
    @RequestMapping(value="/add", method = GET)
    String add(User user) {
        return "usuario";
    }
    
    @RequestMapping(value="/add", method = POST)
    String add(@Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasErrors()) {
            service.save(usuario);
            return "redirect: index";
        }
        redirectAttributes.addAttribute("error", bindingResult.getFieldError().getDefaultMessage());
        redirectAttributes.addAttribute("field", bindingResult.getFieldError().getField());
        return "usuario";
    } 
    
    
}
