package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired ImpressoraService impressoraService;

    @Autowired CelularService celularService;

    public List<Produto> obterLista() {

        List<Produto> produtos = new ArrayList<>();

        produtos.addAll(impressoraService.obterLista());
        produtos.addAll(celularService.obterLista());

        return produtos;
    }
}
