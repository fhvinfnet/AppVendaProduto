package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CelularService {

    private static Map<Integer, Celular> mapaCelular = new HashMap<>();

    private static Integer id = 1;

    public Collection<Celular> obterLista() {
        return mapaCelular.values();
    }

    public void excluir(Integer id) {
        mapaCelular.remove(id);
    }

    public void incluir(Celular celular) {
        celular.setId(id++);
        mapaCelular.put(celular.getId(), celular);

        AppImpressao.relatorio(celular, "inclusao do celular: " + obterLista());
    }

}
