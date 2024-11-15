package com.autobots.automanager.Controller;

import com.autobots.automanager.entitades.Empresa;
import com.autobots.automanager.repositorios.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/empresas")
public class ControladorEmpresa {

    @Autowired
    private RepositorioEmpresa repositorioEmpresa;

    // Listar todas as empresas
    @GetMapping
    public List<Empresa> listarTodas() {
        return repositorioEmpresa.findAll();
    }

    // Buscar empresa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {
        Optional<Empresa> empresa = repositorioEmpresa.findById(id);
        return empresa.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Criar nova empresa
    @PostMapping
    public Empresa criar(@RequestBody Empresa empresa) {
        return repositorioEmpresa.save(empresa);
    }

    // Atualizar empresa existente
    @PutMapping("/{id}")
    public ResponseEntity<Empresa> atualizar(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (!repositorioEmpresa.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        empresa.setId(id);  // Certificar-se de que o ID da empresa que está sendo atualizado é o correto
        return ResponseEntity.ok(repositorioEmpresa.save(empresa));
    }

    // Deletar empresa
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repositorioEmpresa.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repositorioEmpresa.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
