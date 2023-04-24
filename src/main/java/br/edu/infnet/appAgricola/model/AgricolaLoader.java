package br.edu.infnet.appAgricola.model;

import br.edu.infnet.appAgricola.model.domain.Fruta;
import br.edu.infnet.appAgricola.model.domain.Erva;
import br.edu.infnet.appAgricola.model.domain.Vegetal;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.service.FrutaService;
import br.edu.infnet.appAgricola.model.service.ErvaService;
import br.edu.infnet.appAgricola.model.service.VegetalService;
import br.edu.infnet.appAgricola.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class AgricolaLoader implements ApplicationRunner {
    @Autowired
    private FrutaService frutaService;

    @Autowired
    private ErvaService ervaService;

    @Autowired
    private VegetalService vegetalService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Fruta fruta = new Fruta();
        Erva erva = new Erva();
        Vegetal vegetal = new Vegetal();

        Usuario usuario = usuarioService.findById(1L);

        fruta.setNome("Laranja");
      
        fruta.setValorBase(25.00F);
        fruta.setUsuario(usuario);
        fruta.setTipo("madura");
        fruta.setQtdFruta(50);
        
        frutaService.incluir(fruta);


        erva.setNome("salsinha");
        
        erva.setValorBase(235.00F);
        erva.setUsuario(usuario);
        erva.setTipoFolha("raiz");
        erva.setQtdErva(500);
    
        ervaService.incluir(erva);

        vegetal.setNome("Beringela");
        
        vegetal.setValorBase(24.00F);
        vegetal.setUsuario(usuario);
        vegetal.setTipo("Grande");
        vegetal.setQtdVegetal(45);
        vegetalService.incluir(vegetal);

        System.out.println("Inclusão de produto realizada!!!");

    }
}
