package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Produto;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProdutoController {

    private static List<Produto> produtos = new ArrayList<>();;

    public static void incluir(Produto produto) {
        produtos.add(produto);
        AppImpressao.relatorio(produto, "inclusao do produto: " + produto.getNome());
    }

    @GetMapping(value = "/produto/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", produtos);

        return "produto/lista";
    }
}
