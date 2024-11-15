package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Servico;
import com.autobots.automanager.repositorios.RepositorioServico;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoServico {

    @Autowired
    private RepositorioServico repositorioServico;

    public Servico salvar(Servico servico) {
        return repositorioServico.save(servico);
    }

    public Optional<Servico> buscarPorId(Long id) {
        return repositorioServico.findById(id);
    }

    public List<Servico> buscarTodos() {
        return repositorioServico.findAll();
    }

    public void excluir(Long id) {
        repositorioServico.deleteById(id);
    }
}
