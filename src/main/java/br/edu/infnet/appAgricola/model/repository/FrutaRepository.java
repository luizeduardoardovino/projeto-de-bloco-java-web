package br.edu.infnet.appAgricola.model.repository;

import br.edu.infnet.appAgricola.model.domain.Fruta;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrutaRepository extends CrudRepository<Fruta, Long> {
    @Query("from Fruta a where a.usuario = :usuario order by a.nome")
    public List<Fruta> obterLista(Usuario usuario);

    @Query("select count(a) from Fruta a")
    public Integer obterQtd();

}
