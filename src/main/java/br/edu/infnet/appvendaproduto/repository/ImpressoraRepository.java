package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImpressoraRepository extends CrudRepository<Impressora, Integer> {

    @Query("from Impressora i where i.usuario.id = :idUsuario")
    Object findAll(Integer id);
}
