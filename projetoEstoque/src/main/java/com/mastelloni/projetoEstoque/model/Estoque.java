package com.mastelloni.projetoEstoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Integer Disponivel;

    @ManyToOne
    private Produto produto;

    public Estoque() {
    }

    public Estoque(long id, Integer disponivel, Produto produto) {
        this.id = id;
        Disponivel = disponivel;
        this.produto = produto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getDisponivel() {
        return Disponivel;
    }

    public void setDisponivel(Integer disponivel) {
        Disponivel = disponivel;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

}
