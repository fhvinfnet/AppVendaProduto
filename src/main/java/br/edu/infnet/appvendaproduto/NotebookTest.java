package br.edu.infnet.appvendaproduto;

import br.edu.infnet.appvendaproduto.model.domain.Notebook;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NotebookTest implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("#notebook");

        Notebook n1 = new Notebook();
        n1.setCodigo(1);
        n1.setNome("meu Notebook 1");
        n1.setValor(100F);
        n1.setConfiguracao("coinfiguracao do meu notebook 1");
        n1.setPolegadas(13F);
        n1.setSsd(Boolean.FALSE);
        System.out.println(n1);

        Notebook n2 = new Notebook();
        n2.setCodigo(2);
        n2.setNome("meu Notebook 2");
        n2.setValor(150F);
        n2.setConfiguracao("configuracao do meu notebook 2");
        n2.setPolegadas(15F);
        n2.setSsd(Boolean.TRUE);
        System.out.println(n2);

        Notebook n3 = new Notebook();
        n3.setCodigo(3);
        n3.setNome("meu Notebook 3");
        n3.setValor(200F);
        n3.setConfiguracao("configuracao do meu notebook 3");
        n3.setPolegadas(14F);
        n3.setSsd(Boolean.TRUE);
        System.out.println(n3);
    }
}
