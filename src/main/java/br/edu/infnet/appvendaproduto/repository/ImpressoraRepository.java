package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ImpressoraRepository extends CrudRepository<Impressora, Integer> {

    @Query("from Impressora i where i.usuario.id = :idUsuario")
    Collection<Impressora> findAll(Integer idUsuario);
}
