package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Impressora;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class ImpressoraController {

    private static Map<Integer, Impressora> mapaImpressora = new HashMap<>();

    private static Integer id = 1;

    public static void excluir(Integer id) {
        mapaImpressora.remove(id);
    }

    public static Collection<Impressora> obterLista() {
        return mapaImpressora.values();
    }

    public static void incluir(Impressora impressora) {
        impressora.setId(id++);
        mapaImpressora.put(impressora.getId(), impressora);

        AppImpressao.relatorio(impressora, "inclusao de impressora: " + obterLista());
    }

    @GetMapping(value = "/impressora/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", obterLista());

        return "impressora/lista";
    }

    @GetMapping("/impressora/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        excluir(id);

        return "redirect:/impressora/lista";
    }
}
