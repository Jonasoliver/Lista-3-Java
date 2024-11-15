package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Mercadoria;
import com.autobots.automanager.repositorios.RepositorioMercadoria;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoMercadoria {

    @Autowired
    private RepositorioMercadoria repositorioMercadoria;

    public Mercadoria salvar(Mercadoria mercadoria) {
        return repositorioMercadoria.save(mercadoria);
    }

    public Optional<Mercadoria> buscarPorId(Long id) {
        return repositorioMercadoria.findById(id);
    }

    public List<Mercadoria> buscarTodos() {
        return repositorioMercadoria.findAll();
    }

    public void excluir(Long id) {
        repositorioMercadoria.deleteById(id);
    }
}
