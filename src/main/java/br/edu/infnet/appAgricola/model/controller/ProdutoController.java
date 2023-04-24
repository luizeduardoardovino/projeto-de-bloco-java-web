package br.edu.infnet.appAgricola.model.controller;

import br.edu.infnet.appAgricola.model.domain.Agricola;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.AgricolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProdutoController {

    @Autowired
    private AgricolaService produtoService;

    @GetMapping(value = "/produto")
    public String telaCadastro() {
        return "/produto/cadastro";
    }

    @GetMapping("/produto/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("lista", produtoService.obterLista(usuario.getId()));
        return "/produto/lista";
    }

    @GetMapping("/produto/{id}/excluir")
    public String excluir(Model model, @SessionAttribute("user") Usuario usuarioUser, @PathVariable Long id) {
        Agricola produto = produtoService.findById(id);
        String mensagem = null;
        String idMsg = null;
        try {
            produtoService.excluir(id);
            mensagem = "O produto " + produto.getNome() + " foi excluído com sucesso!!!";
            idMsg = "sucesso";
        } catch (Exception e) {
            mensagem = "Não foi possível realizar a exclusão do produto " + produto.getNome() + ". Erro retornado: " + e.getMessage();
            idMsg = "erro";
        }
        model.addAttribute("msg", mensagem);
        model.addAttribute("idMsg", idMsg);
        return telaLista(model, usuarioUser);
    }
}
