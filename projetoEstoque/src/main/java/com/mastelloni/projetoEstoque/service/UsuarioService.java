package com.mastelloni.projetoEstoque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastelloni.projetoEstoque.model.Usuario;
import com.mastelloni.projetoEstoque.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizar(Long id, Usuario novoUsuario) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {
            usuarioExistente.setNome(novoUsuario.getNome());
            usuarioExistente.setEmail(novoUsuario.getEmail());
            usuarioExistente.setSenha(novoUsuario.getSenha());
            return usuarioRepository.save(usuarioExistente);
        }).orElseThrow(() -> new RuntimeException("Usuario não encontrado"));
    }

    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
