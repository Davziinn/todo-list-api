package br.com.menz.to_do_list_api.domain.ports.out;

import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.infraestructure.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepositoryOutboundPort {

    Usuario salvarUsuario (Usuario usuario);

    Optional<Usuario> buscarUsuarioBySequencial (UUID sequencial);

    List<Usuario> buscarTodos ();

    Usuario editarUsuario (Usuario usuario);

    void deletarUsuarioBySequencial(UUID sequencial);

    Optional<Usuario> buscarUsuarioByEmail(String email);
}
