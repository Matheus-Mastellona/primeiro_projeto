package com.mastelloni.projetoEstoque.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class EntradaEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer quantidade;
    private LocalDateTime dataEntrada;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Usuario usuario;

    public EntradaEstoque() {
        dataEntrada = LocalDateTime.now();
    }

    public EntradaEstoque(long id, Integer quantidade, LocalDateTime dataEntrada, Produto produto, Usuario usuario) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
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

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
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
