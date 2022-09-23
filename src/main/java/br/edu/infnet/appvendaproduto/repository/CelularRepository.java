package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CelularRepository extends CrudRepository<Celular, Integer> {

}
