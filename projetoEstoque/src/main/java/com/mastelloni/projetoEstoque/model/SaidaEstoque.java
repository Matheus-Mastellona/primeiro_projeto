package com.mastelloni.projetoEstoque.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class SaidaEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer quantidade;
    private LocalDateTime dataSaida;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Usuario usuario;

    public SaidaEstoque() {
        dataSaida = LocalDateTime.now();
    }

    public SaidaEstoque(long id, Integer quantidade, LocalDateTime dataSaida, Produto produto, Usuario usuario) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataSaida = dataSaida;
        this.produto = produto;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDateTime dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
