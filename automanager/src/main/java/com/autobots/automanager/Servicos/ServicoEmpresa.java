package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Empresa;
import com.autobots.automanager.repositorios.RepositorioEmpresa;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoEmpresa {

    @Autowired
    private RepositorioEmpresa repositorioEmpresa;

    public Empresa salvar(Empresa empresa) {
        return repositorioEmpresa.save(empresa);
    }

    public Optional<Empresa> buscarPorId(Long id) {
        return repositorioEmpresa.findById(id);
    }

    public List<Empresa> buscarTodos() {
        return repositorioEmpresa.findAll();
    }

    public void excluir(Long id) {
        repositorioEmpresa.deleteById(id);
    }
}