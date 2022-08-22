package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ImpressoraController {

    private static List<Impressora> impressoras = new ArrayList<>();;

    public static void incluir(Impressora impressora) {
        impressoras.add(impressora);
        AppImpressao.relatorio(impressora, "inclusao da impressora: " + impressora.getNome());
    }

    @GetMapping(value = "/impressora/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", impressoras);

        return "impressora/lista";
    }
}
