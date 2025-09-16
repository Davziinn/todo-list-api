package br.com.menz.to_do_list_api.infraestructure.mapper;

import br.com.menz.to_do_list_api.domain.model.Tag;
import br.com.menz.to_do_list_api.infraestructure.dto.TagDTO;
import br.com.menz.to_do_list_api.infraestructure.entity.TagEntity;
import org.springframework.stereotype.Component;

@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag toModel(TagDTO dto) {
        return Tag.builder()
                .sequencial(dto.getSequencial())
                .nomeTag(dto.getNomeTag())
                .build();
    }

    @Override
    public TagEntity toEntity(Tag model) {
        return TagEntity.builder()
                .sequencial(model.getSequencial())
                .nomeTag(model.getNomeTag())
                .build();
    }

    @Override
    public Tag toModel(TagEntity entity) {
        return Tag.builder()
                .sequencial(entity.getSequencial())
                .nomeTag(entity.getNomeTag())
                .build();
    }

    @Override
    public TagDTO toDTO(Tag model) {
        return TagDTO.builder()
                .sequencial(model.getSequencial())
                .nomeTag(model.getNomeTag())
                .build();
    }
}
