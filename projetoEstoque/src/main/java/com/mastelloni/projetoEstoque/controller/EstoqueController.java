package com.mastelloni.projetoEstoque.controller;

import com.mastelloni.projetoEstoque.model.Estoque;
import com.mastelloni.projetoEstoque.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping
    public ResponseEntity<Estoque> criarEstoque(@RequestBody Estoque estoque) {
        Estoque novoEstoque = estoqueService.salvar(estoque);
        return ResponseEntity.ok(novoEstoque);
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> listarEstoques() {
        return ResponseEntity.ok(estoqueService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(estoqueService.buscarPorId(id));
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<Estoque> buscarPorProdutoId(@PathVariable Long produtoId) {
        return ResponseEntity.of(estoqueService.buscarPorProdutoId(produtoId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> atualizarEstoque(@PathVariable Long id, @RequestBody Estoque estoque) {
        return ResponseEntity.ok(estoqueService.atualizar(id, estoque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        estoqueService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}