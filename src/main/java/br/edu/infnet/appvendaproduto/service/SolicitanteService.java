package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class SolicitanteService {

    private static Map<Integer, Cliente> mapaCliente = new HashMap<>();

    private static Integer id = 1;

    public Collection<Cliente> obterLista() {
        return mapaCliente.values();
    }

    public void excluir(Integer id) {
        mapaCliente.remove(id);
    }

    public void incluir(Cliente cliente) {
        cliente.setId(id++);
        mapaCliente.put(cliente.getId(), cliente);

        AppImpressao.relatorio(cliente, "inclusao do cliente: " + cliente.getNome());
    }
}
