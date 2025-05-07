package com.mastelloni.projetoEstoque.controller;

import com.mastelloni.projetoEstoque.model.EntradaEstoque;
import com.mastelloni.projetoEstoque.service.EntradaEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/entradas")
public class EntradaEstoqueController {

    @Autowired
    private EntradaEstoqueService entradaEstoqueService;

    @PostMapping
    public ResponseEntity<EntradaEstoque> registrarEntrada(@RequestBody EntradaEstoque entradaEstoque) {
        // Define a data atual se não for fornecida
        if (entradaEstoque.getDataEntrada() == null) {
            entradaEstoque.setDataEntrada(LocalDateTime.now());
        }
        EntradaEstoque novaEntrada = entradaEstoqueService.salvar(entradaEstoque);
        return ResponseEntity.ok(novaEntrada);
    }

    @GetMapping
    public ResponseEntity<List<EntradaEstoque>> listarEntradas() {
        return ResponseEntity.ok(entradaEstoqueService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaEstoque> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(entradaEstoqueService.buscarPorId(id));
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<EntradaEstoque>> buscarPorProdutoId(@PathVariable Long produtoId) {
        return ResponseEntity.ok(entradaEstoqueService.buscarPorProdutoId(produtoId));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<EntradaEstoque>> buscarPorUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(entradaEstoqueService.buscarPorUsuarioId(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaEstoque> atualizarEntrada(@PathVariable Long id, @RequestBody EntradaEstoque entradaEstoque) {
        return ResponseEntity.ok(entradaEstoqueService.atualizar(id, entradaEstoque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        entradaEstoqueService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}