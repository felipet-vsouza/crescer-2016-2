package br.com.cwi.crescer.aula8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DataController {

    @ResponseBody
    @RequestMapping(value = "/current_date_time")
    public Date date() {
        return new Date();
    }

//    @ResponseBody
//    @RequestMapping(value = "/pessoa.json", method = RequestMethod.POST)
//    public List<Pessoa> list(@RequestBody Pessoa p) {
//        p.setNascimento(new Date());
//        return Stream.of(p).collect(Collectors.toList());
//    }
}
