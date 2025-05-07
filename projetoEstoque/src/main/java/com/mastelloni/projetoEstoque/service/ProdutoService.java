package com.mastelloni.projetoEstoque.service;

import com.mastelloni.projetoEstoque.model.Produto;
import com.mastelloni.projetoEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        // Aqui você pode adicionar lógica antes de salvar (ex: validações)
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto atualizar(Long id, Produto novoProduto) {
        return produtoRepository.findById(id).map(produtoExistente -> {
            produtoExistente.setNome(novoProduto.getNome());
            produtoExistente.setDescricao(novoProduto.getDescricao());
            produtoExistente.setPreco(novoProduto.getPreco());
            produtoExistente.setQuantidade(novoProduto.getQuantidade());
            produtoExistente.setCategoria(novoProduto.getCategoria());
            produtoExistente.setFornecedor(novoProduto.getFornecedor());
            return produtoRepository.save(produtoExistente);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
