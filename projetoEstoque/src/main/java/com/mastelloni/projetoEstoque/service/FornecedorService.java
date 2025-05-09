package com.mastelloni.projetoEstoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastelloni.projetoEstoque.model.Fornecedor;
import com.mastelloni.projetoEstoque.repository.FornecedorRepository;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor salvar(FornecedorRepository fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarTodos() {
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long id) {
        return fornecedorRepository.findById(id);
    }

    public Fornecedor atualizar(Long id, Fornecedor novoFornecedor) {
        return fornecedorRepository.findById(id).map(fornecedorExistente -> {
            fornecedorExistente.setNome(novoFornecedor.getNome());
            fornecedorExistente.setEndereco(novoFornecedor.getEndereco());
            fornecedorExistente.setTelefone(novoFornecedor.getTelefone());
            fornecedorExistente.setEmail(novoFornecedor.getEmail());
            fornecedorExistente.setCnpj(novoFornecedor.getCnpj());
            return fornecedorRepository.save(fornecedorExistente);
        }).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public void excluir(Long id) {
        fornecedorRepository.deleteById(id);
    }
}
