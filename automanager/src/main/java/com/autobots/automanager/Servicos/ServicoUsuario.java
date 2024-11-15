package com.autobots.automanager.Servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.autobots.automanager.entitades.Usuario;
import com.autobots.automanager.repositorios.RepositorioUsuario;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public Usuario salvar(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repositorioUsuario.findById(id);
    }

    public List<Usuario> buscarTodos() {
        return repositorioUsuario.findAll();
    }

    public void excluir(Long id) {
        repositorioUsuario.deleteById(id);
    }

    public Usuario buscarPorNome(String nome) {
        return repositorioUsuario.findByNome(nome);
    }
}
