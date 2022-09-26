package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Venda;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendaRepository extends CrudRepository<Venda, Integer> {

    @Query("from Venda v where v.usuario.id = :userId")
    List<Venda> findAll(Integer userId);
}
