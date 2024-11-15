package com.autobots.automanager.Controller;

import com.autobots.automanager.entitades.Venda;
import com.autobots.automanager.repositorios.RepositorioVenda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendas")
public class ControladorVenda {

    @Autowired
    private RepositorioVenda repositorioVenda;

    // Listar todas as vendas
    @GetMapping
    public List<Venda> listarTodas() {
        return repositorioVenda.findAll();
    }

    // Buscar venda por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venda> buscarPorId(@PathVariable Long id) {
        Optional<Venda> venda = repositorioVenda.findById(id);
        return venda.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar nova venda
    @PostMapping
    public Venda criar(@RequestBody Venda venda) {
        return repositorioVenda.save(venda);
    }

    // Atualizar venda existente
    @PutMapping("/{id}")
    public ResponseEntity<Venda> atualizar(@PathVariable Long id, @RequestBody Venda venda) {
        if (!repositorioVenda.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        venda.setId(id);  // Certificar-se de que o ID da venda que está sendo atualizado é o correto
        return ResponseEntity.ok(repositorioVenda.save(venda));
    }

    // Deletar venda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repositorioVenda.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositorioVenda.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
