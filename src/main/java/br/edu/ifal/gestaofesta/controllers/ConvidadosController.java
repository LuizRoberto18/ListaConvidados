package br.edu.ifal.gestaofesta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifal.gestaofesta.model.Convidado;
import br.edu.ifal.gestaofesta.repository.Convidados;

@RestController
public class ConvidadosController{

    @Autowired
    private Convidados convidados;
    
    Convidado convidado = new Convidado();

    
@RequestMapping("/convidados")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("ListaConvidados.html");
        mv.addObject("convidados", convidados.findAll());
        mv.addObject(new Convidado());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Convidado convidado){
        this.convidados.save(convidado);
        return new ModelAndView("redirect:/convidados");
    }

    @RequestMapping("/excluir/{id}")
    public ModelAndView excluirConvidado(@PathVariable(name = "id") Long id){
        convidados.deleteById(id);
        return new ModelAndView("redirect:/convidados");
    }
}