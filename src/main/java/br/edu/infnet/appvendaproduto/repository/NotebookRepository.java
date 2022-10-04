package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Integer> {

    @Query("from Notebook n where n.usuario.id = :idUsuario")
    Collection<Notebook> findAll(Integer idUsuario);
}
