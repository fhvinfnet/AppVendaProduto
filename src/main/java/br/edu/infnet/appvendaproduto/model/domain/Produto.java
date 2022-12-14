package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.exceptions.MemoriaDeCelularInvalidaException;
import br.edu.infnet.appvendaproduto.exceptions.PolegadaNotebookInvalidaException;
import br.edu.infnet.appvendaproduto.exceptions.SistemaDeImpressaoInvalido;
import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private float valor;
    private int codigo;

    @ManyToMany(mappedBy = "produtos")
    private List<Venda> vendas;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Produto() {
    }

    public abstract float calcularVenda() throws MemoriaDeCelularInvalidaException, SistemaDeImpressaoInvalido,
            PolegadaNotebookInvalidaException;

    @Override
    public String toString() {
        return nome + ";" + valor + ";" + codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Produto produto = (Produto) o;
        return codigo == produto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
