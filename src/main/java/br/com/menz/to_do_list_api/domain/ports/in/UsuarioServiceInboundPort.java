package br.com.menz.to_do_list_api.domain.ports.in;

import br.com.menz.to_do_list_api.domain.model.Usuario;

public interface UsuarioServiceInboundPort {

    Usuario criarUsuario(Usuario usuario);
}
