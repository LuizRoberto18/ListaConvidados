package br.edu.ifal.gestaofesta.controllers;

import java.util.List;

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
    private Convidados Repoconvidados;
    
    Convidado convidado = new Convidado();

    
    @RequestMapping("/convidados")
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("ListaConvidados.html");
        mv.addObject("convidados", Repoconvidados.findAll());
        mv.addObject(new Convidado());
        return mv;
    }

    @RequestMapping("/convidados/salvar")
    public ModelAndView salvar(Convidado convidado){
        this.Repoconvidados.save(convidado);
        return new ModelAndView("redirect:/convidados");
    }

    @RequestMapping("/procurarConvidado")
    public ModelAndView listarConvidados(String nome) {
        ModelAndView mv = new ModelAndView("ListaConvidados.html");
        List<Convidado> convidados = Repoconvidados.findByNomeContaining(nome);
        if (!convidados.isEmpty()) {
            mv.addObject("convidados", convidados);
            return mv;
        }
        mv.addObject("msgErro", "convidado nao esta na lista");
        return mv;
    }
    
    @RequestMapping("/excluir/{id}")
    public ModelAndView excluirConvidado(@PathVariable(name = "id") Long id){
        Repoconvidados.deleteById(id);
        return new ModelAndView("redirect:/convidados");
    }
}