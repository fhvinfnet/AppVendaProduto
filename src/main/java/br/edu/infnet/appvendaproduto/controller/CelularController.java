package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CelularController {

    private static List<Celular> celulares = new ArrayList<>();;

    public static void incluir(Celular celular) {
        celulares.add(celular);
        AppImpressao.relatorio(celular, "inclusao do celular: " + celular.getNome());
    }

    @GetMapping(value = "/celular/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", celulares);
        return "celular/lista";
    }
}
