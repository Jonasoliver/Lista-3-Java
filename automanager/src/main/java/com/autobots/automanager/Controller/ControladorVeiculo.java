package com.autobots.automanager.Controller;

import com.autobots.automanager.entitades.Veiculo;
import com.autobots.automanager.repositorios.RepositorioVeiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class ControladorVeiculo {

    @Autowired
    private RepositorioVeiculo repositorioVeiculo;

    // Listar todos os veículos
    @GetMapping
    public List<Veiculo> listarTodos() {
        return repositorioVeiculo.findAll();
    }

    // Buscar veículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable Long id) {
        Optional<Veiculo> veiculo = repositorioVeiculo.findById(id);
        return veiculo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar novo veículo
    @PostMapping
    public Veiculo criar(@RequestBody Veiculo veiculo) {
        return repositorioVeiculo.save(veiculo);
    }

    // Atualizar veículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        if (!repositorioVeiculo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        veiculo.setId(id);  // Certificar-se de que o ID do veículo que está sendo atualizado é o correto
        return ResponseEntity.ok(repositorioVeiculo.save(veiculo));
    }

    // Deletar veículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repositorioVeiculo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositorioVeiculo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
