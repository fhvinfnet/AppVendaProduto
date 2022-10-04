package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.controller.NotebookController;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import br.edu.infnet.appvendaproduto.model.domain.Usuario;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import br.edu.infnet.appvendaproduto.repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class NotebookService {

    @Autowired
    private NotebookRepository notebookRepository;

    public Collection<Notebook> obterLista() {
        return (Collection<Notebook>) notebookRepository.findAll();
    }

    public Collection<Notebook> obterLista(Usuario usuario) {
        return (Collection<Notebook>) notebookRepository.findAll(usuario.getId());
    }

    public void excluir(Integer id) {
        notebookRepository.deleteById(id);
    }

    public void incluir(Notebook notebook) {
        notebookRepository.save(notebook);

        AppImpressao.relatorio(notebook, "inclusao do notebook: " + obterLista());
    }
}
