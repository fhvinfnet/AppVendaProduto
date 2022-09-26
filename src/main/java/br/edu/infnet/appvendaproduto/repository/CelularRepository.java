package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CelularRepository extends CrudRepository<Celular, Integer> {

    @Query("from Celular c where c.usuario.id = :idUsuario")
    Collection<Celular> findAll(Integer idUsuario);
}
