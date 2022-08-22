package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Produto;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class ProdutoController {

    private static Map<Integer, Produto> mapaProduto = new HashMap<>();

    private static Integer id = 1;

    public static Collection<Produto> obterLista() {
        return mapaProduto.values();
    }

    public static void excluir(Integer id) {
        mapaProduto.remove(id);
    }

    public static void incluir(Produto produto) {
        produto.setId(id++);
        mapaProduto.put(produto.getId(), produto);

        AppImpressao.relatorio(produto, "inclusao do produto: " + obterLista());
    }

    @GetMapping(value = "/produto/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", obterLista());

        return "produto/lista";
    }

    @GetMapping("/produto/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        excluir(id);

        return "redirect:/produto/lista";
    }
}
