package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Credencial;
import com.autobots.automanager.repositorios.RepositorioCredencial;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoCredencial {

    @Autowired
    private RepositorioCredencial repositorioCredencial;

    public Credencial salvar(Credencial credencial) {
        return repositorioCredencial.save(credencial);
    }

    public Optional<Credencial> buscarPorId(Long id) {
        return repositorioCredencial.findById(id);
    }

    public List<Credencial> buscarTodos() {
        return repositorioCredencial.findAll();
    }

    public void excluir(Long id) {
        repositorioCredencial.deleteById(id);
    }
}
