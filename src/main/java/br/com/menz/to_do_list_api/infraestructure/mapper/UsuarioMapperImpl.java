package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.infraestructure.dto.UsuarioDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapperImpl implements UsuarioMapper {
    @Override
    public Usuario toModel(UsuarioDTO dto) {
        return Usuario.builder()
                .sequencial(dto.getSequencial())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .senha(dto.getSenha())
                .build();
    }

    @Override
    public UsuarioEntity toEntity(Usuario model) {
        return UsuarioEntity.builder()
                .sequencial(model.getSequencial())
                .nome(model.getNome())
                .email(model.getEmail())
                .senha(model.getSenha())
                .build();
    }

    @Override
    public Usuario toModel(UsuarioEntity entity) {
        return Usuario.builder()
                .sequencial(entity.getSequencial())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .senha(entity.getSenha())
                .build();
    }

    @Override
    public UsuarioDTO toDTO(Usuario model) {
        return UsuarioDTO.builder()
                .sequencial(model.getSequencial())
                .nome(model.getNome())
                .email(model.getEmail())
                .senha(model.getSenha())
                .build();
    }
}
