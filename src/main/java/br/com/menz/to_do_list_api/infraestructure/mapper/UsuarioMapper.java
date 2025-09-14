package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.infraestructure.dto.UsuarioDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.UsuarioEntity;

public interface UsuarioMapper {

    Usuario toModel (UsuarioDTO dto);

    UsuarioEntity toEntity (Usuario model);

    Usuario toModel (UsuarioEntity entity);

    UsuarioDTO toDTO (Usuario model);
}
