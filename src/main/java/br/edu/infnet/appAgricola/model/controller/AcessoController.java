package br.edu.infnet.appAgricola.model.controller;

import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@SessionAttributes("user")
@Controller
public class AcessoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FrutaService frutaService;
    @Autowired
    private ErvaService ervaService;
    @Autowired
    private VegetalService vegetalService;
    @Autowired
    private AgricolaService produtoService;
    @Autowired
    private EncomendaService encomendaService;

    @GetMapping(value = "/app")
    public String telaApp(Model model) {

//        List<String> lista = new ArrayList<String >();

        Map<String, Integer> mapaTotal = new HashMap<String, Integer>();
        mapaTotal.put("Usuários", usuarioService.obterQtd());
        mapaTotal.put("Clientes", clienteService.obterQtd());
        mapaTotal.put("Frutas", frutaService.obterQtd());
        mapaTotal.put("Ervas", ervaService.obterQtd());
        mapaTotal.put("Vegetais", vegetalService.obterQtd());
        mapaTotal.put("Produtos", produtoService.obterQtd());
        mapaTotal.put("Encomendas", encomendaService.obterQtd());

        model.addAttribute("totalizacao", mapaTotal);

        return "home";
    }

    @GetMapping(value = "/")
    public String telaHome() {
        return "index";
    }

    @GetMapping(value = "/login")
    public String telaLogin() {
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(Model model, @RequestParam String email, @RequestParam String senha) {
        Usuario usuario = usuarioService.validar(email, senha);
        if(usuario != null) {
            model.addAttribute("user", usuario);
            return "index";
        } else {
            model.addAttribute("mensagem", "Autenticação inválida para o usuário "+ email +"!!!");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }

}