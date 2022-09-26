package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.domain.Venda;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public Collection<Venda> obterLista() {
        return (Collection<Venda>) vendaRepository.findAll();
    }

    public Collection<Venda> obterLista(Usuario usuario) {
        return (Collection<Venda>) vendaRepository.findAll(usuario.getId());
    }

    public void excluir(Integer id) {
        vendaRepository.deleteById(id);
    }

    public void incluir(Venda venda) {
        vendaRepository.save(venda);

        AppImpressao.relatorio(venda, "inclusao de veda: " + venda.getDescricao());
    }

}
