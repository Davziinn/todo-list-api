package br.com.menz.to_do_list_api.domain.ports.in;

import br.com.menz.to_do_list_api.domain.model.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioServiceInboundPort {

    Usuario criarUsuario(Usuario usuario);

    Usuario buscarUsuarioByEmail(String email);

    List<Usuario> buscarTodosOsUsuarios();

    Usuario editarUsuario (UUID sequencial, Usuario usuario);
}
