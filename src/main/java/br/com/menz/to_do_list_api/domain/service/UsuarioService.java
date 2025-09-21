package br.com.menz.to_do_list_api.domain.service;

import br.com.menz.to_do_list_api.domain.exceptions.EmailUsuarioNotFoundException;
import br.com.menz.to_do_list_api.domain.exceptions.UsuarioJaExisteException;
import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.domain.ports.in.UsuarioServiceInboundPort;
import br.com.menz.to_do_list_api.domain.ports.out.UsuarioRepositoryOutboundPort;

public class UsuarioService implements UsuarioServiceInboundPort {

    private final UsuarioRepositoryOutboundPort usuarioRepositoryOutbound;
    // private final UsuarioRepositoryOutboundPort usuarioRepositoryOutbound;

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
}
