package br.edu.infnet.appvendaproduto.model.domain;

import br.edu.infnet.appvendaproduto.exceptions.ClienteNuloException;
import br.edu.infnet.appvendaproduto.exceptions.VendaSemProdutoException;
import br.edu.infnet.appvendaproduto.interfaces.IPrinter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TVenda")
public class Venda implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDateTime data;
    private boolean web;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToMany(cascade = CascadeType.DETACH)
    private Set<Produto> produtos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Venda() {
    }

    public Venda(Cliente cliente, Set<Produto> produtos) throws ClienteNuloException, VendaSemProdutoException {

        if (cliente == null) {
            throw new ClienteNuloException("cliente deve ser informado");
        }

//        if (produtos == null || produtos.size() < 1) {
//            throw new VendaSemProdutoException("uma venda deve ter ao menos um produto");
//        }

        this.cliente = cliente;
        this.data = LocalDateTime.now();
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return descricao + ";" + data + ";" + web + ";" + cliente + ";" + produtos.size();
    }

    @Override
    public void impressao() {
        System.out.println("#venda");
        System.out.println(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public LocalDateTime getData() {
        return data;
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
