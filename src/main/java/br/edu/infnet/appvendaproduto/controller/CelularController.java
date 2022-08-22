package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

@Controller
public class CelularController {

    private static Map<Integer, Celular> mapaCelular = new HashMap<>();

    private static Integer id = 1;

    public static Collection<Celular> obterLista() {
        return mapaCelular.values();
    }

    public static void incluir(Celular celular) {
        celular.setId(id++);
        mapaCelular.put(celular.getId(), celular);

        AppImpressao.relatorio(celular, "inclusao do celular: " + obterLista());
    }

    @GetMapping(value = "/celular/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", mapaCelular.values());
        return "celular/lista";
    }
}
