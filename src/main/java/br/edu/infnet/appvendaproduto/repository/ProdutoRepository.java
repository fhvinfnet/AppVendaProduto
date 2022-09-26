package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Produto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

    @Query("from Produto p where p.usuario.id = :idUsuario")
    Collection<Produto> findAll(Integer idUsuario);
}
