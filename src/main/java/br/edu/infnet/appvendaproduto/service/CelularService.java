package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.repository.CelularRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CelularService {

    @Autowired
    CelularRepository celularRepository;

    public Collection<Celular> obterLista() {
        return (Collection<Celular>) celularRepository.findAll();
    }

    public void excluir(Integer id) {
        celularRepository.deleteById(id);
    }

    public void incluir(Celular celular) {
        celularRepository.save(celular);

        AppImpressao.relatorio(celular, "inclusao do celular: " + obterLista());
    }

}
