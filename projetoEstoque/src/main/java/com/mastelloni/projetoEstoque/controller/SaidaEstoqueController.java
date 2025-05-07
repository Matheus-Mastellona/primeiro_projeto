package com.mastelloni.projetoEstoque.controller;

import com.mastelloni.projetoEstoque.model.SaidaEstoque;
import com.mastelloni.projetoEstoque.service.SaidaEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/saidas")
public class SaidaEstoqueController {

    @Autowired
    private SaidaEstoqueService saidaEstoqueService;

    @PostMapping
    public ResponseEntity<SaidaEstoque> registrarSaida(@RequestBody SaidaEstoque saidaEstoque) {
        // Define a data atual se não for fornecida
        if (saidaEstoque.getDataSaida() == null) {
            saidaEstoque.setDataSaida(LocalDateTime.now());
        }
        SaidaEstoque novaSaida = saidaEstoqueService.salvar(saidaEstoque);
        return ResponseEntity.ok(novaSaida);
    }

    @GetMapping
    public ResponseEntity<List<SaidaEstoque>> listarSaidas() {
        return ResponseEntity.ok(saidaEstoqueService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaidaEstoque> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.of(saidaEstoqueService.buscarPorId(id));
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<SaidaEstoque>> buscarPorProdutoId(@PathVariable Long produtoId) {
        return ResponseEntity.ok(saidaEstoqueService.buscarPorProdutoId(produtoId));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<SaidaEstoque>> buscarPorUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(saidaEstoqueService.buscarPorUsuarioId(usuarioId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SaidaEstoque> atualizarSaida(@PathVariable Long id, @RequestBody SaidaEstoque saidaEstoque) {
        return ResponseEntity.ok(saidaEstoqueService.atualizar(id, saidaEstoque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        saidaEstoqueService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}