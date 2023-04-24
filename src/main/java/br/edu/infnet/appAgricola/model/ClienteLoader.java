package br.edu.infnet.appAgricola.model;

import br.edu.infnet.appAgricola.model.domain.Cliente;
import br.edu.infnet.appAgricola.model.domain.Endereco;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.ClienteService;
import br.edu.infnet.appAgricola.model.service.EnderecoService;
import br.edu.infnet.appAgricola.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class ClienteLoader implements ApplicationRunner {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Usuario usuario = usuarioService.findById(1L);

        Endereco endereco = new Endereco();
        endereco = enderecoService.obterCep("31741455");

        endereco.setComplemento("apto. 401");
        endereco.setNumero(237);

        Cliente cliente = new Cliente();
        cliente.setNome("Primeiro Cliente");
        cliente.setEmail("email_cliente@mail");
        cliente.setTelefone("(31) 99991-0001");
        cliente.setEndereco(endereco);
        cliente.setUsuario(usuario);
        clienteService.incluir(cliente);

    }
}
