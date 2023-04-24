package br.edu.infnet.appAgricola.model.service;

import br.edu.infnet.appAgricola.model.domain.Vegetal;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.repository.VegetalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VegetalService {

    @Autowired
    private VegetalRepository vegetalRepository;

    public List<Vegetal> obterLista(Usuario usuario) {
        return (List<Vegetal>) vegetalRepository.obterLista(usuario);
    }

    public Vegetal findById(Long id){
        return vegetalRepository.findById(id).orElse(null);
    }

    public void incluir(Vegetal vegetal) {
        vegetalRepository.save(vegetal);
    }

    public void excluir(Long id) {
        vegetalRepository.deleteById(id);
    }
    public List<Vegetal> findAll(){
        return (List<Vegetal>) vegetalRepository.findAll();
    }

    public Integer obterQtd(){
        return vegetalRepository.obterQtd();
    }

}
