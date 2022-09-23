package br.edu.infnet.appvendaproduto.repository;

import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
