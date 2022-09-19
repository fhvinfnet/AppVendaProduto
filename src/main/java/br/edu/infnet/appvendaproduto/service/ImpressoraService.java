package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ImpressoraService {

    private static Map<Integer, Impressora> mapaImpressora = new HashMap<>();

    private static Integer id = 1;

    public void excluir(Integer id) {
        mapaImpressora.remove(id);
    }

    public Collection<Impressora> obterLista() {
        return mapaImpressora.values();
    }

    public void incluir(Impressora impressora) {
        impressora.setId(id++);
        mapaImpressora.put(impressora.getId(), impressora);

        AppImpressao.relatorio(impressora, "inclusao de impressora: " + obterLista());
    }
}
