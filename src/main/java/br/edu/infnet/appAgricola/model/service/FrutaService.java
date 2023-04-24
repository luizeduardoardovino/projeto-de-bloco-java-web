package br.edu.infnet.appAgricola.model.service;

import br.edu.infnet.appAgricola.model.domain.Fruta;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import br.edu.infnet.appAgricola.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrutaService {

    @Autowired
    private FrutaRepository frutaRepository;

    public List<Fruta> obterLista(Usuario usuario) {
        return (List<Fruta>) frutaRepository.obterLista(usuario);
    }

    public Fruta findById(Long id){
        return frutaRepository.findById(id).orElse(null);
    }

    public void incluir(Fruta fruta) {
        frutaRepository.save(fruta);
    }

    public void excluir(Long id) {
        frutaRepository.deleteById(id);
    }

    public List<Fruta> findAll(){
        return (List<Fruta>) frutaRepository.findAll();
    }

    public Integer obterQtd(){
        return frutaRepository.obterQtd();
    }

}
