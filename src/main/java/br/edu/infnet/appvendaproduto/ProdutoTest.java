package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.controller.ProdutoController;
import br.edu.infnet.appvendaproduto.model.domain.Celular;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class ProdutoTest implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Celular c1 = new Celular();
        c1.setCodigo(1);
        c1.setNome("meu celular 1");
        c1.setValor(100F);

        ProdutoController.incluir(c1);
    }
}
