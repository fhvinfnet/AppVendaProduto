package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Venda;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class VendaService {

    private static Map<Integer, Venda> mapaVenda = new HashMap<>();

    private static Integer id = 1;

    public Collection<Venda> obterLista() {
        return mapaVenda.values();
    }

    public void excluir(Integer id) {
        mapaVenda.remove(id);
    }

    public void incluir(Venda venda) {
        venda.setId(id++);
        mapaVenda.put(venda.getId(), venda);
        AppImpressao.relatorio(venda, "inclusao de veda: " + venda.getDescricao());
    }

}
