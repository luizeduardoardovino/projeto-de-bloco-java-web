package br.edu.infnet.appAgricola.model;

import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String email = "luizeduardo@al.infnet.edu.br";
        if (usuarioService.buscarPorEmail(email) == null) {
            Usuario usuario = new Usuario();
            usuario.setNome("Luiz Eduardo");
            usuario.setEmail(email);
            usuario.setSenha("123");
            usuario.setAdmin(true);

            usuarioService.incluir(usuario);

            System.out.println("Inclusão de usuário realizada!!!");
        } else {
            System.out.println("Usuário já existe. Nenhuma inclusão realizada.");
        }
    }
}
