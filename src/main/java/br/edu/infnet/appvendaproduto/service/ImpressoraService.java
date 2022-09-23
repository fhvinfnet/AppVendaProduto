package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.repository.ImpressoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImpressoraService {

    @Autowired
    ImpressoraRepository impressoraRepository;

    public void excluir(Integer id) {
        impressoraRepository.deleteById(id);
    }

    public Collection<Impressora> obterLista() {
        return (Collection<Impressora>) impressoraRepository.findAll();
    }

    public void incluir(Impressora impressora) {
        impressoraRepository.save(impressora);

        AppImpressao.relatorio(impressora, "inclusao de impressora: " + obterLista());
    }
}
