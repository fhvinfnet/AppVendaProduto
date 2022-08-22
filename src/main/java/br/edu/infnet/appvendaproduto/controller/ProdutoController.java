package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class ProdutoController {

    private static Map<Integer, Celular> mapaProduto = new HashMap<>();

    private static Integer id = 1;

    public static Collection<Celular> obterLista() {
        return mapaProduto.values();
    }

    public static void incluir(Celular celular) {
        celular.setId(id++);
        mapaProduto.put(celular.getId(), celular);

        AppImpressao.relatorio(celular, "inclusao do produto: " + obterLista());
    }

    @GetMapping(value = "/produto/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", obterLista());

        return "produto/lista";
    }
}
