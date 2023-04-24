package br.edu.infnet.appAgricola.model.service;

import br.edu.infnet.appAgricola.model.domain.Erva;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.repository.ErvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErvaService {

    @Autowired
    private ErvaRepository ervaRepository;

    public List<Erva> obterLista(Usuario usuario) {
        return (List<Erva>) ervaRepository.obterLista(usuario);
    }

    public void incluir(Erva erva)  {ervaRepository.save(erva);
    }

    public Erva findById(Long id){
        return ervaRepository.findById(id).orElse(null);
    }

    public void excluir(Long id) {
        ervaRepository.deleteById(id);
    }
    public List<Erva> findAll(){
        return (List<Erva>) ervaRepository.findAll();
    }

    public Integer obterQtd(){
        return ervaRepository.obterQtd();
    }

}
