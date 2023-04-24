package br.edu.infnet.appAgricola.model.controller;

import br.edu.infnet.appAgricola.model.domain.Vegetal;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.VegetalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class VegetalController {

    @Autowired
    private VegetalService vegetalService;

    @GetMapping(value = "/vegetal")
    public String telaCadastro() {
        return "/vegetal/cadastro";
    }

    @GetMapping("/vegetal/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", vegetalService.obterLista(usuario));
        return "/vegetal/lista";
    }

    @PostMapping("/vegetal/incluir")
    public String incluir(Model model, Vegetal vegetal, @SessionAttribute("user") Usuario usuario) {
        new Vegetal(vegetal.getNome(), vegetal.getValorBase());
        vegetal.setUsuario(usuario);
        vegetalService.incluir(vegetal);
        String mensagem = "A decoração " + vegetal.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/vegetal/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Vegetal vegetal = vegetalService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            vegetalService.excluir(id);
            mensagem = "A decoração  " + vegetal.getNome() + " foi excluída com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão da decoração " + vegetal.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }

}
