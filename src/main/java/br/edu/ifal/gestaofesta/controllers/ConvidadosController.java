package br.edu.ifal.gestaofesta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.gestaofesta.model.Convidado;
import br.edu.ifal.gestaofesta.repository.Convidados;

@RestController
@RequestMapping("/convidados")
public class ConvidadosController{

    @Autowired
    private Convidados convidados;

    @RequestMapping
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("ListaConvidados.html");
        mv.addObject("convidados", convidados.todos());
        mv.addObject(new Convidado());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String salvar(Convidado convidado){
        this.convidados.adicionar(convidado);
        return "redirect:/convidados";
    }
}