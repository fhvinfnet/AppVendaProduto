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

    @GetMapping(value = "/celular/lista")
    public String telaHome(Model model) {

        Celular c1 = new Celular();
        c1.setCodigo(1);
        c1.setNome("meu celular 1");
        c1.setValor(100F);
        c1.setCameraFrontal(Boolean.FALSE);
        c1.setDimensao("4 x 3");
        c1.setMemoria(2.3F);

        Celular c2 = new Celular();
        c2.setCodigo(2);
        c2.setNome("meu celular 2");
        c2.setValor(150F);
        c2.setCameraFrontal(Boolean.TRUE);
        c2.setDimensao("5 x 3");
        c2.setMemoria(3.3F);

        Celular c3 = new Celular();
        c3.setCodigo(3);
        c3.setNome("meu celular 3");
        c3.setValor(200F);
        c3.setCameraFrontal(Boolean.TRUE);
        c3.setDimensao("4 x 3");
        c3.setMemoria(5.0F);

        celulares.add(c1);
        celulares.add(c2);
        celulares.add(c3);

        model.addAttribute("listagem", celulares);
        return "celular/lista";
    }
}
