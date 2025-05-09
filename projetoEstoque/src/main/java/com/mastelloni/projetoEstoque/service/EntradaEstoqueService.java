package com.mastelloni.projetoEstoque.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastelloni.projetoEstoque.model.EntradaEstoque;
import com.mastelloni.projetoEstoque.repository.EntradaEstoqueRepository;

@Service
public class EntradaEstoqueService {

    @Autowired
    private EntradaEstoqueRepository entradaEstoqueRepository;

    public EntradaEstoque salvar(EntradaEstoqueRepository entradaEstoque) {
        return entradaEstoqueRepository.save(entradaEstoque);
    }

    public List<EntradaEstoque> listarTodos() {
        return entradaEstoqueRepository.findAll();
    }

    public EntradaEstoque buscarPorId(Long id) {
        return entradaEstoqueRepository.findById(id);
    }

    public EntradaEstoque atualizar(Long id, EntradaEstoque novaEntrada) {
        return entradaEstoqueRepository.findById(id).map(entradaExistente -> {
            entradaExistente.setQuantidade(novaEntrada.getQuantidade());
            entradaExistente.setProduto(novaEntrada.getProduto());
            entradaExistente.setDataEntrada(novaEntrada.getDataEntrada());
            return entradaEstoqueRepository.save(entradaExistente);
        }).orElseThrow(() -> new RuntimeException("Entrada de estoque não encontrada"));
    }

    public void excluir(Long id) {
        entradaEstoqueRepository.deletedById(id);
    }
}
