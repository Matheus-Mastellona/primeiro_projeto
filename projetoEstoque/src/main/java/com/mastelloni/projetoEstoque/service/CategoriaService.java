package com.mastelloni.projetoEstoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastelloni.projetoEstoque.model.Categoria;
import com.mastelloni.projetoEstoque.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvar(CategoriaRepository categoria) {
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria atualizar(Long id, Categoria novaCategoria) {
        return categoriaRepository.findById(id).map(categoriaExistente -> {
            categoriaExistente.setNome(novaCategoria.getNome());
            categoriaExistente.setDescricao(novaCategoria.getDescricao());
            return categoriaRepository.save(categoriaExistente);
        }).orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public void excluir(Long id) {
        categoriaRepository.deletedById(id);
    }

}