package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Usuario;
import br.com.menz.to_do_list_api.infraestructure.dto.UsuarioDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.UsuarioEntity;

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
        UsuarioEntity entity = new UsuarioEntity();

        entity.setSequencial(model.getSequencial());
        entity.setNome(model.getNome());
        entity.setEmail(model.getEmail());
        entity.setSenha(model.getSenha());

        return entity;
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
        return new UsuarioDTO(
                model.getSequencial(),
                model.getNome(),
                model.getEmail(),
                model.getSenha()
        );
    }
}
