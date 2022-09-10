package br.edu.infnet.appvendaproduto.service;

import br.edu.infnet.appvendaproduto.model.domain.app.Projeto;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    private Projeto projeto;

    public void incluir(Projeto p) {
        projeto = p;

        AppImpressao.relatorio(projeto, "inclusao de projeto realizada com sucesso");
    }

    public Projeto obterProjeto() {
        return  projeto;
    }
}
