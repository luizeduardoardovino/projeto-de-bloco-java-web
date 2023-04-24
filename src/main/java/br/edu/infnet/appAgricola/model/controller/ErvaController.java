package br.edu.infnet.appAgricola.model.controller;

import br.edu.infnet.appAgricola.model.domain.Erva;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.ErvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ErvaController {

    @Autowired
    private ErvaService ervaService;

    @GetMapping(value = "/erva")
    public String telaCadastro() {
        return "/erva/cadastro";
    }

    @GetMapping("/erva/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", ervaService.obterLista(usuario));
        return "/erva/lista";
    }

    @PostMapping("/erva/incluir")
    public String incluir(Model model, Erva erva, @SessionAttribute("user") Usuario usuario) {
        new Erva(erva.getNome(), erva.getValorBase());
        erva.setUsuario(usuario);
        ervaService.incluir(erva);
        String mensagem = "O acessório " + erva.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/erva/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Erva erva = ervaService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            ervaService.excluir(id);
            mensagem = "A erva " + erva.getNome() + " foi excluída com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão da erva " + erva.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
