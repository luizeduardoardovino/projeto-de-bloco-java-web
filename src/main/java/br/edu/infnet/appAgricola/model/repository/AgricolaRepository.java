package br.edu.infnet.appAgricola.model.repository;

import br.edu.infnet.appAgricola.model.domain.Agricola;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgricolaRepository extends CrudRepository<Agricola, Long> {
    @Query("from Agricola a where a.usuario.id = :id order by a.nome")
    public List<Agricola> obterLista(Long id);

    @Query("select count(a) from Agricola a")
    public Integer obterQtd();

}
