package br.edu.infnet.appAgricola.model.controller;

import br.edu.infnet.appAgricola.model.domain.Fruta;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @GetMapping(value = "/fruta")
    public String telaCadastro() {
        return "/fruta/cadastro";
    }

    @GetMapping("/fruta/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", frutaService.obterLista(usuario));
        return "/fruta/lista";
    }

    @PostMapping("/fruta/incluir")
    public String incluir(Model model, Fruta fruta, @SessionAttribute("user") Usuario usuario) {
        new Fruta(fruta.getNome(), fruta.getValorBase());
        fruta.setUsuario(usuario);
        frutaService.incluir(fruta);
        String mensagem = "O acessório " + fruta.getNome() + " foi cadastrado com sucesso!!!";
        model.addAttribute("msg", mensagem);
        return telaLista(model, usuario);
    }

    @GetMapping("/fruta/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Fruta fruta = frutaService.findById(id);
        String mensagem = null;
        String idMsg = null;
        
        try {
            frutaService.excluir(id);
            mensagem = "O acessório " + fruta.getNome() + " foi excluído com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão do acessório " + fruta.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
