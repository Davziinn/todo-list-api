package br.com.menz.to_do_list_api.domain.service;

import br.com.menz.to_do_list_api.domain.exceptions.EmailUsuarioNotFoundException;
import br.com.menz.to_do_list_api.domain.exceptions.UsuarioJaExisteException;
import br.com.menz.to_do_list_api.domain.exceptions.UsuariosNaoEncontradosException;
import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.domain.ports.in.UsuarioServiceInboundPort;
import br.com.menz.to_do_list_api.domain.ports.out.UsuarioRepositoryOutboundPort;

import java.util.List;
import java.util.UUID;

public class UsuarioService implements UsuarioServiceInboundPort {

    private final UsuarioRepositoryOutboundPort usuarioRepositoryOutbound;

    public UsuarioService(UsuarioRepositoryOutboundPort usuarioRepositoryOutbound) {
        this.usuarioRepositoryOutbound = usuarioRepositoryOutbound;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        usuarioRepositoryOutbound.buscarUsuarioByEmail(usuario.getEmail())
                .ifPresent(u -> {
                    throw new UsuarioJaExisteException("Já existe um usuário para esse email");
                });

        return usuarioRepositoryOutbound.salvarUsuario(usuario);
    }

    @Override
    public Usuario buscarUsuarioByEmail(String email) {
        return usuarioRepositoryOutbound.buscarUsuarioByEmail(email)
                .orElseThrow(() -> new EmailUsuarioNotFoundException("Email não encontrado"));
    }

    @Override
    public List<Usuario> buscarTodosOsUsuarios() {
        try {
            return usuarioRepositoryOutbound.buscarTodos();
        } catch (Exception e) {
            throw new UsuariosNaoEncontradosException("Nenhum usuário foi encontrado");
        }
    }

    @Override
    public Usuario editarUsuario(UUID sequencial, Usuario usuario) {
        Usuario usuarioBuscado = usuarioRepositoryOutbound.buscarUsuarioBySequencial(sequencial)
                .orElseThrow(() -> new UsuariosNaoEncontradosException("Usuário não encontrado"));

        usuarioBuscado.setSequencial(sequencial);
        usuarioBuscado.setNome(usuario.getNome());
        usuarioBuscado.setEmail(usuario.getEmail());
        usuarioBuscado.setSenha(usuario.getSenha());

        return usuarioRepositoryOutbound.editarUsuario(usuarioBuscado);
    }

    @Override
    public void deletarUsuarioBySequencial(UUID sequencial) {
        usuarioRepositoryOutbound.deletarUsuarioBySequencial(sequencial);
    }

}
