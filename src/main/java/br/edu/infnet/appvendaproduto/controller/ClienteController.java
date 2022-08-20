package br.edu.infnet.appvendaproduto.controller;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.domain.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {

    private static List<Cliente> clientes = new ArrayList<>();;

    @GetMapping(value = "/cliente/lista")
    public String telaHome() {
        return "cliente/lista";
    }
}
