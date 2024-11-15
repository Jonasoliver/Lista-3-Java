package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Veiculo;
import com.autobots.automanager.repositorios.RepositorioVeiculo;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoVeiculo {

    @Autowired
    private RepositorioVeiculo repositorioVeiculo;

    public Veiculo salvar(Veiculo veiculo) {
        return repositorioVeiculo.save(veiculo);
    }

    public Optional<Veiculo> buscarPorId(Long id) {
        return repositorioVeiculo.findById(id);
    }

    public List<Veiculo> buscarTodos() {
        return repositorioVeiculo.findAll();
    }

    public void excluir(Long id) {
        repositorioVeiculo.deleteById(id);
    }
}
