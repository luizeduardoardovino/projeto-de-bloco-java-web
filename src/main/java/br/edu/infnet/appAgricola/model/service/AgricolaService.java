package br.edu.infnet.appAgricola.model.service;

import br.edu.infnet.appAgricola.model.domain.Agricola;
import br.edu.infnet.appAgricola.model.repository.AgricolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AgricolaService {
    @Autowired
    private AgricolaRepository produtoRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<Agricola> obterLista(Long id) {
        return (List<Agricola>) produtoRepository.obterLista(id);
    }

    public void incluir(Agricola produto) {
        produtoRepository.save(produto);
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public Agricola findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Agricola> findAll(){
        return (List<Agricola>) produtoRepository.findAll();
    }

    public Integer obterQtd(){
        return produtoRepository.obterQtd();
    }

}
