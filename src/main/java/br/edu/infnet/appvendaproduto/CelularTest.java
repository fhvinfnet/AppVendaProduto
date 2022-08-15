package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Celular;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class CelularTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("#Celular");

        Celular c1 = new Celular();
        c1.setCodigo(1);
        c1.setNome("meu celular 1");
        c1.setValor(100F);
        c1.setCameraFrontal(Boolean.FALSE);
        c1.setDimensao("4 x 3");
        c1.setMemoria(2.3F);
        System.out.println(c1);

        Celular c2 = new Celular();
        c2.setCodigo(2);
        c2.setNome("meu celular 2");
        c2.setValor(150F);
        c2.setCameraFrontal(Boolean.TRUE);
        c2.setDimensao("5 x 3");
        c2.setMemoria(3.3F);
        System.out.println(c2);

        Celular c3 = new Celular();
        c3.setCodigo(3);
        c3.setNome("meu celular 3");
        c3.setValor(200F);
        c3.setCameraFrontal(Boolean.TRUE);
        c3.setDimensao("4 x 3");
        c3.setMemoria(5.0F);
        System.out.println(c3);
    }

}