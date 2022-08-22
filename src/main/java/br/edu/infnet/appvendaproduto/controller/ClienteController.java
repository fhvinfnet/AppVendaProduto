package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Controller
public class ClienteController {

    private static Map<Integer, Cliente> mapaCliente = new HashMap<>();

    private static Integer id = 1;

    public static Collection<Cliente> obterLista() {
        return mapaCliente.values();
    }

    public static void excluir(Integer id) {
        mapaCliente.remove(id);
    }

    public static void incluir(Cliente cliente) {
        cliente.setId(id++);
        mapaCliente.put(cliente.getId(), cliente);

        AppImpressao.relatorio(cliente, "inclusao do cliente: " + cliente.getNome());
    }

    @GetMapping(value = "/cliente/lista")
    public String telaHome(Model model) {
        model.addAttribute("listagem", obterLista());

        return "cliente/lista";
    }

    @GetMapping("/cliente/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {
        excluir(id);

        return "redirect:/cliente/lista";
    }
}
