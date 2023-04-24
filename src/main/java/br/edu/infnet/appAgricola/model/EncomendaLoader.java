package br.edu.infnet.appAgricola.model;

import br.edu.infnet.appAgricola.model.domain.Agricola;
import br.edu.infnet.appAgricola.model.domain.Cliente;
import br.edu.infnet.appAgricola.model.domain.Encomenda;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.AgricolaService;
import br.edu.infnet.appAgricola.model.service.ClienteService;
import br.edu.infnet.appAgricola.model.service.EncomendaService;
import br.edu.infnet.appAgricola.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Order(4)
public class EncomendaLoader implements ApplicationRunner {

    @Autowired
    private AgricolaService produtoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EncomendaService encomendaService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = usuarioService.findById(1L);
        Cliente cliente = clienteService.findById(1L);

        List<Agricola> produtoList = produtoService.obterLista(usuario.getId());

        Encomenda encomenda = new Encomenda();
        encomenda.setCliente(cliente);
        encomenda.setUsuario(usuario);
        encomenda.setData(LocalDate.now());
        encomenda.setFeira(false);
        encomenda.setObservacao("Incluído na inicialização do sistema com todos os itens de produtos existentes na criação");
        encomenda.setProdutoList(produtoList);

        encomendaService.incluir(encomenda);

    }
}
