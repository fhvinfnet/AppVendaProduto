package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Venda;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class VendaController {

    private static List<Venda> vendas = new ArrayList<>();;

    public static void incluir(Venda venda) {
        vendas.add(venda);
        AppImpressao.relatorio(venda, "inclusao do celular: " + venda.getDescricao());
    }

    @GetMapping(value = "/venda/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", vendas);

        return "venda/lista";
    }
}
