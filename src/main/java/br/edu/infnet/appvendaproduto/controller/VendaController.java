package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Venda;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class VendaController {

    private static Map<Integer, Venda> mapaVenda = new HashMap<>();

    private static Integer id = 1;

    public static Collection<Venda> obterLista() {
        return mapaVenda.values();
    }

    public static void excluir(Integer id) {
        mapaVenda.remove(id);
    }

    public static void incluir(Venda venda) {
        venda.setId(id++);
        mapaVenda.put(venda.getId(), venda);
        AppImpressao.relatorio(venda, "inclusao de veda: " + venda.getDescricao());
    }

    @GetMapping(value = "/venda/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", obterLista());

        return "venda/lista";
    }

    @GetMapping("/venda/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        excluir(id);

        return "redirect:/venda/lista";
    }
}
