package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.CelularController;
import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import br.edu.infnet.appvendaproduto.model.teste.AppImpressao;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CelularTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) {
        System.out.println("###### Celular");

        try {
            Celular c1 = new Celular();
            c1.setCodigo(1);
            c1.setNome("meu celular 1");
            c1.setValor(100F);
            c1.setCameraFrontal(Boolean.FALSE);
            c1.setDimensao("4 x 3");
            c1.setMemoria(8F);
            System.out.println("calculo da venda: " + c1.calcularVenda());
            CelularController.incluir(c1);
        } catch (MemoriaDeCelularInvalidaException e) {
            System.out.println("[ERROR - CELULAR] " + e.getMessage());
        }

        try {
            Celular c2 = new Celular();
            c2.setCodigo(2);
            c2.setNome("meu celular 2");
            c2.setValor(150F);
            c2.setCameraFrontal(Boolean.TRUE);
            c2.setDimensao("5 x 3");
            c2.setMemoria(16F);
            System.out.println("calculo da venda: " + c2.calcularVenda());
            CelularController.incluir(c2);
        } catch (MemoriaDeCelularInvalidaException e) {
            System.out.println("[ERROR - CELULAR] " + e.getMessage());
        }

        try {
            Celular c3 = new Celular();
            c3.setCodigo(3);
            c3.setNome("meu celular 3");
            c3.setValor(200F);
            c3.setCameraFrontal(Boolean.TRUE);
            c3.setDimensao("4 x 3");
            c3.setMemoria(32F);
            System.out.println("calculo da venda: " + c3.calcularVenda());
            CelularController.incluir(c3);
        } catch (MemoriaDeCelularInvalidaException e) {
            System.out.println("[ERROR - CELULAR] " + e.getMessage());
        }

        try {
            Celular c4 = new Celular();
            c4.setCodigo(4);
            c4.setNome("meu celular 4");
            c4.setValor(200F);
            c4.setCameraFrontal(Boolean.TRUE);
            c4.setDimensao("4 x 3");
            c4.setMemoria(4F);
            System.out.println("calculo da venda: " + c4.calcularVenda());
            CelularController.incluir(c4);
        } catch (MemoriaDeCelularInvalidaException e) {
            System.out.println("[ERROR - CELULAR] " + e.getMessage());
        }
    }

}
