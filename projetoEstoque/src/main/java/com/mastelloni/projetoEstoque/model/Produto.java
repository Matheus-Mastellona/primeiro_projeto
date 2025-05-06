package main.java.com.mastelloni.projetoEstoque.model;

public class Produto {
    private String nome;
    private double preco;
    Estoque quantidadeEstoque;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setQuantidadeEstoque(Estoque quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Estoque getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}
