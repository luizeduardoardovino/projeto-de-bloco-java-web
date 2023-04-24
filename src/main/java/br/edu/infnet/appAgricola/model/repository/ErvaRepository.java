package br.edu.infnet.appAgricola.model.repository;

import br.edu.infnet.appAgricola.model.domain.Erva;
import br.edu.infnet.appAgricola.model.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErvaRepository extends CrudRepository<Erva, Long> {
    @Query("from Erva a where a.usuario = :usuario order by a.nome")
    public List<Erva> obterLista(Usuario usuario);

    @Query("select count(b) from Erva b")
    public Integer obterQtd();

}
