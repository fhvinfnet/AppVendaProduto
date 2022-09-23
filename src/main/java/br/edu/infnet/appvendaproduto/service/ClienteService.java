package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public Collection<Cliente> obterLista() {
        return (Collection<Cliente>) clienteRepository.findAll();
    }

    public Collection<Cliente> obterLista(Usuario usuario) {
        return (Collection<Cliente>) clienteRepository.obterList(usuario.getId());
    }

    public void excluir(Integer id) {
        clienteRepository.deleteById(id);
    }

    public void incluir(Cliente cliente) {
        clienteRepository.save(cliente);

        AppImpressao.relatorio(cliente, "inclusao do cliente: " + cliente.getNome());
    }
}
