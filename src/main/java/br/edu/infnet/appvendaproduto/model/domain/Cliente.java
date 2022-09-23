package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.exceptions.CpfInvalidoException;
import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import javax.persistence.*;

@Entity
@Table(name = "TCliente")
public class Cliente implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String email) throws CpfInvalidoException {

        if (cpf == null) {
            throw new CpfInvalidoException("Não é possível aceitar CPF nulo");
        }

        if (cpf.isBlank()) {
            throw new CpfInvalidoException("Não é possível aceitar CPF vazio");
        }

        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + ";" + cpf + ";" + email;
    }

    @Override
    public void impressao() {
        System.out.println("#cliente");
        System.out.println(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
