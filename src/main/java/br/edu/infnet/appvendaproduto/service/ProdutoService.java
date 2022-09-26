package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Produto;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Collection<Produto> obterLista() {
        return (Collection<Produto>) produtoRepository.findAll();
    }

    public Collection<Produto> obterLista(Usuario usuario) {
        return (Collection<Produto>) produtoRepository.findAll(usuario.getId());
    }

    public void excluir(Integer id) {
        produtoRepository.deleteById(id);
    }
}
