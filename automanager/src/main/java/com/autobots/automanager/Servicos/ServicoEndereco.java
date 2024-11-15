package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Endereco;
import com.autobots.automanager.repositorios.RepositorioEndereco;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoEndereco {

    @Autowired
    private RepositorioEndereco repositorioEndereco;

    public Endereco salvar(Endereco endereco) {
        return repositorioEndereco.save(endereco);
    }

    public Optional<Endereco> buscarPorId(Long id) {
        return repositorioEndereco.findById(id);
    }

    public List<Endereco> buscarTodos() {
        return repositorioEndereco.findAll();
    }

    public void excluir(Long id) {
        repositorioEndereco.deleteById(id);
    }
}
