package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Venda;
import com.autobots.automanager.repositorios.RepositorioVenda;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoVenda {

    @Autowired
    private RepositorioVenda repositorioVenda;

    public Venda salvar(Venda venda) {
        return repositorioVenda.save(venda);
    }

    public Optional<Venda> buscarPorId(Long id) {
        return repositorioVenda.findById(id);
    }

    public List<Venda> buscarTodos() {
        return repositorioVenda.findAll();
    }

    public void excluir(Long id) {
        repositorioVenda.deleteById(id);
    }
}
