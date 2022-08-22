package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    private static List<Cliente> clientes = new ArrayList<>();;

    public static void incluir(Cliente cliente) {
        clientes.add(cliente);
        AppImpressao.relatorio(cliente, "inclusao do cliente: " + cliente.getNome());
    }

    @GetMapping(value = "/cliente/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", clientes);

        return "cliente/lista";
    }
}
