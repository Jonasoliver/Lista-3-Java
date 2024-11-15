package com.autobots.automanager.Controller;

import com.autobots.automanager.entitades.Usuario;
import com.autobots.automanager.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class ControladorUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    // Listar todos os usuários
    @GetMapping
    public List<Usuario> listarTodos() {
        return repositorioUsuario.findAll();
    }

    // Buscar usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        return usuario.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar novo usuário
    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    // Atualizar usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        if (!repositorioUsuario.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);  // Certificar-se de que o ID do usuário que está sendo atualizado é o correto
        return ResponseEntity.ok(repositorioUsuario.save(usuario));
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repositorioUsuario.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositorioUsuario.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
