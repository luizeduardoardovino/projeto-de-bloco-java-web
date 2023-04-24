package br.edu.infnet.appAgricola.model.repository;

import br.edu.infnet.appAgricola.model.domain.Vegetal;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VegetalRepository extends CrudRepository<Vegetal, Long> {
    @Query("from Vegetal a where a.usuario = :usuario order by a.nome")
    public List<Vegetal> obterLista(Usuario usuario);

    @Query("select count(d) from Vegetal d")
    public Integer obterQtd();

}
